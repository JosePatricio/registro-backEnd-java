package com.sukasa.domain.services.validations;

import io.jkratz.mediator.core.CommandHandler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.sukasa.domain.exceptions.DomainException;
import com.sukasa.domain.interfaces.repositories.IBeneficioRepository;

import javax.validation.constraints.NotNull;

@Component
public class ValidateReservationServiceHandler implements  CommandHandler<ValidateBeneficioService>  {
    private final IBeneficioRepository repository;

    public ValidateReservationServiceHandler(IBeneficioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(@NotNull ValidateBeneficioService service) {

        if (repository.findByTipoAndEstado(service.getTipo(), service.isEstado()).isEmpty() )
        {
            throw new DomainException("Los beneficios del grupo "+service.getTipo()+" ya no están disponibles", HttpStatus.BAD_REQUEST);
        }

      }
}
