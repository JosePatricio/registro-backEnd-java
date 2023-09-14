package com.sukasa.application.commands;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.sukasa.application.dtos.responses.CreateClienteResponse;
import com.sukasa.domain.entities.ClienteEntity;
import com.sukasa.domain.events.domain.ClienteCreatedDomainEvent;
import com.sukasa.domain.exceptions.DomainException;
import com.sukasa.domain.interfaces.repositories.IBeneficioRepository;
import com.sukasa.domain.interfaces.repositories.IClienteRepository;
import com.sukasa.domain.services.validations.ValidateBeneficioService;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;

@Component
public class CreateClienteCommandHandler implements RequestHandler<CreateClienteCommand, CreateClienteResponse>{
    
    private final IClienteRepository userRepository; 
	private final IBeneficioRepository beneficioRepository; 
	private final Mediator mediator;

    public CreateClienteCommandHandler(IClienteRepository userRepository,IBeneficioRepository beneficioRepository,  Mediator mediator) {
		this.userRepository = userRepository;
		this.beneficioRepository=beneficioRepository;
		this.mediator = mediator;
	}

    @Override
	public CreateClienteResponse handle(CreateClienteCommand command) {
		if(command.getNombre().isEmpty()){
			 throw new DomainException("El campo nombre no puede estar nulo", HttpStatus.BAD_REQUEST);
		}	
		if(command.getCorreoElectronico().isEmpty()){
			 throw new DomainException("El campo Correo electrónico no puede estar nulo", HttpStatus.BAD_REQUEST);
		}	

		this.mediator.dispatch(new ValidateBeneficioService(command.getGrupo().getTipo(),true));

		CreateClienteResponse response = new CreateClienteResponse();
       
		var beneficioAsignado=beneficioRepository.findByTipoAndEstado(command.getGrupo().getTipo(),true).get(0);
		
		ClienteEntity entity = new ClienteEntity();
		entity.setNombre(command.getNombre());
		entity.setCorreoElectronico(command.getCorreoElectronico());
		entity.setTelefono(command.getTelefono());
		entity.setGrupo(beneficioAsignado.getTipo());
		entity.setBeneficio(beneficioAsignado.getNombre());
		entity = this.userRepository.registro(entity);
		response.setMensaje("El usuario "+entity.getNombre()+ " se ha registrado exitósamente en el grupo "+beneficioAsignado.getTipo()+" con el beneficio "+beneficioAsignado.getNombre());
		 
		beneficioAsignado.setEstado(false);
		beneficioRepository.save(beneficioAsignado);

		this.mediator.emitAsync(new ClienteCreatedDomainEvent(entity.getId()));
		return response;
	}

}
