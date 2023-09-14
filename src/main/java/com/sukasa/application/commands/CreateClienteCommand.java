package com.sukasa.application.commands;

import javax.validation.constraints.NotNull;

import com.sukasa.application.dtos.responses.CreateClienteResponse;
import com.sukasa.application.enums.GrupoEnum;

import io.jkratz.mediator.core.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@AllArgsConstructor
public class CreateClienteCommand implements Request<CreateClienteResponse>{

	@NotNull
	private final String nombre;
	private final String correoElectronico;
    private final String telefono;
    private final GrupoEnum grupo;

}
