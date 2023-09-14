package com.sukasa.domain.entities;

import lombok.Data;

@Data
public class ClienteEntity {
   
	private int id;

	private String nombre;
	private String correoElectronico;
	private String telefono;
	private String grupo;
	private String beneficio;
}
