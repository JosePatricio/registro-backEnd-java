package com.sukasa.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sukasa.application.commands.CreateClienteCommand;
import com.sukasa.application.dtos.responses.CreateClienteResponse;
import com.sukasa.application.queries.GetBeneficiosByTipoAndEstadoQuery;
import com.sukasa.application.queries.GetClientesQuery;

import io.jkratz.mediator.core.Mediator;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private final Mediator mediator;

	
	@Autowired
	public ClienteController(Mediator mediator) {
		this.mediator = mediator;
	}


	@PostMapping
	public ResponseEntity<CreateClienteResponse> create(@RequestBody CreateClienteCommand command) {

		return new ResponseEntity<>(this.mediator.dispatch(command), HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		var query = new GetClientesQuery("");

		return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
	}

}
