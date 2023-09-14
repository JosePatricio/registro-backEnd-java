package com.sukasa.application.queries;

import org.springframework.stereotype.Component;

import com.sukasa.domain.entities.ClienteEntity;
import com.sukasa.domain.interfaces.repositories.IClienteRepository;
import com.sukasa.infraestructure.repositories.ClienteRepository;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class GetClientesQueryHandler implements RequestHandler<GetClientesQuery, java.util.List<ClienteEntity>>{
 
    private final IClienteRepository userRepository;

     public GetClientesQueryHandler(ClienteRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public java.util.List<ClienteEntity> handle(GetClientesQuery query) {
        
        return userRepository.usuariosRegistrados();
    }
}
