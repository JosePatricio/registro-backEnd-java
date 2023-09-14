package com.sukasa.application.queries;

import com.sukasa.domain.entities.BeneficioEntity;

import io.jkratz.mediator.core.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetBeneficiosByTipoAndEstadoQuery implements Request<java.util.List<BeneficioEntity>>{
    private String tipo;
    private boolean estado;
}
