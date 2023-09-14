package com.sukasa.application.queries;

import com.sukasa.domain.entities.ClienteEntity;

import io.jkratz.mediator.core.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetClientesQuery implements Request<java.util.List<ClienteEntity>>{
    
    private String email;
}
