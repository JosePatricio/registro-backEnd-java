package com.sukasa.domain.entities;

import lombok.Data;

@Data
public class BeneficioEntity {
   
	private int id;

	private String nombre;
	private String tipo;
	private boolean estado;
}
