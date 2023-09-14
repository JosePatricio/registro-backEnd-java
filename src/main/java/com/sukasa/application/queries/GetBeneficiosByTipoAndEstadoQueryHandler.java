package com.sukasa.application.queries;

import org.springframework.stereotype.Component;

import com.sukasa.domain.entities.BeneficioEntity;
import com.sukasa.domain.entities.ClienteEntity;
import com.sukasa.domain.interfaces.repositories.IBeneficioRepository;
import com.sukasa.domain.interfaces.repositories.IClienteRepository;
import com.sukasa.infraestructure.repositories.BeneficioRepository;
import com.sukasa.infraestructure.repositories.ClienteRepository;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class GetBeneficiosByTipoAndEstadoQueryHandler implements RequestHandler<GetBeneficiosByTipoAndEstadoQuery, java.util.List<BeneficioEntity>>{
 
    private final IBeneficioRepository repository;

     public GetBeneficiosByTipoAndEstadoQueryHandler(BeneficioRepository repository) {
        this.repository = repository;
        
    }

    @Override
    public java.util.List<BeneficioEntity> handle(GetBeneficiosByTipoAndEstadoQuery query) {
        
        return this.repository.findByTipoAndEstado(query.getTipo(),true);
    }
}
