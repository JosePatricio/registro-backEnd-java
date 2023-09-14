package com.sukasa.domain.services.validations;

import io.jkratz.mediator.core.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidateBeneficioService implements Command{
    private String tipo;
    private boolean estado;

   
}
