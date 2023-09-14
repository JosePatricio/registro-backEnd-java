package com.sukasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sukasa.domain.entities.BeneficioEntity;
import com.sukasa.domain.entities.ClienteEntity;
import com.sukasa.infraestructure.repositories.BeneficioRepository;
import com.sukasa.infraestructure.repositories.ClienteRepository;

@SpringBootTest
class SukasaApplicationTests {



	@MockBean
	private ClienteRepository repository;

    @MockBean
	private BeneficioRepository beneficioRepository;

	@Test
	public void registrarCliente() {
		
		ClienteEntity entity = new ClienteEntity();
		entity.setGrupo("SK");
		entity.setBeneficio("Beneficio 1");
		entity.setCorreoElectronico("correo@gmail.com");
		entity.setNombre("Jose Patricio Isama Pena");
		entity.setTelefono("099456789");
		when(repository.registro(entity)).thenReturn(entity);

		BeneficioEntity beneficioEntity=new BeneficioEntity();
		beneficioEntity.setId(1);
		beneficioEntity.setEstado(true);
		beneficioEntity.setNombre("Descuento 1");
		beneficioEntity.setTipo("SK");
		ArrayList<BeneficioEntity> beneficioEntities= new ArrayList<>();
		beneficioEntities.add(beneficioEntity);
		when(beneficioRepository.findByTipoAndEstado("SK",true)).thenReturn(beneficioEntities);
		
		//TEST PARA VALIDAR DISPONIBILIDAD DE BENEFICIOS
		assertEquals(1, beneficioRepository.findByTipoAndEstado("SK",true).size());


		ClienteEntity expectedModel=new ClienteEntity();
		expectedModel.setGrupo("SK");
		expectedModel.setBeneficio("Beneficio 1");
		expectedModel.setCorreoElectronico("correo@gmail.com");
		expectedModel.setNombre("Jose Patricio Isama Pena");
		expectedModel.setTelefono("099456789");

		ClienteEntity model=new ClienteEntity();
		model.setGrupo("SK");
		model.setBeneficio("Beneficio 1");
		model.setCorreoElectronico("correo@gmail.com");
		model.setNombre("Jose Patricio Isama Pena");
		model.setTelefono("099456789");

		//TEST PARA VALIDAR INGRESO EXITOSO
		assertEquals(expectedModel, repository.registro(model));
	}




	@Test
	public void validarBeneficiosDisponibles() {
		ArrayList<BeneficioEntity> beneficioEntities= new ArrayList<>();
		BeneficioEntity beneficioEntity=new BeneficioEntity();
		beneficioEntity.setId(1);
		beneficioEntity.setEstado(false);
		beneficioEntity.setNombre("Descuento 1");
		beneficioEntity.setTipo("SK");
        beneficioEntities.add(beneficioEntity);
		beneficioEntity=new BeneficioEntity();
		beneficioEntity.setId(2);
		beneficioEntity.setEstado(true);
		beneficioEntity.setNombre("Descuento 2");
		beneficioEntity.setTipo("SK");
		beneficioEntities.add(beneficioEntity);

		when(beneficioRepository.findByTipoAndEstado("SK",true)).thenReturn(beneficioEntities);
		

		//TEST PARA VALIDAR DISPONIBILIDAD DE BENEFICIOS
		assertTrue(beneficioRepository.findByTipoAndEstado("SK",true).size()>=1);
		
	}


	@Test
	public void informeUsuariosRegistrados() {
        ArrayList<ClienteEntity> entities= new ArrayList<>();
		ClienteEntity entity = new ClienteEntity();
		entity.setGrupo("SK");
		entity.setBeneficio("Beneficio 1");
		entity.setCorreoElectronico("correo@gmail.com");
		entity.setNombre("Jose Patricio Isama Pena");
		entity.setTelefono("099456789");
		entities.add(entity);
		entity = new ClienteEntity();
		entity.setGrupo("SK");
		entity.setBeneficio("Beneficio 2");
		entity.setCorreoElectronico("correo2@gmail.com");
		entity.setNombre("Peter Johan Svensson");
		entity.setTelefono("00468956454");
		entities.add(entity);
		entity = new ClienteEntity();
		entity.setGrupo("TH");
		entity.setBeneficio("Beneficio 3");
		entity.setCorreoElectronico("correo3@gmail.com");
		entity.setNombre("Jule Nibbengahen");
		entity.setTelefono("00491234874");
		entities.add(entity);
		when(repository.usuariosRegistrados()).thenReturn(entities);

		//TEST PARA VALIDAR QUE LISTA DE USUARIO REGISTRADOS
		assertTrue(repository.usuariosRegistrados().size()==3);
	}

}
