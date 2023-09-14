package com.sukasa.infraestructure.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sukasa.domain.entities.BeneficioEntity;
import com.sukasa.domain.interfaces.repositories.IBeneficioRepository;
import com.sukasa.infraestructure.dtos.ThFormato;
import com.sukasa.infraestructure.dtos.sk_formatoModel;
import com.sukasa.infraestructure.models.BeneficioModel;

@Repository
public class BeneficioRepository implements IBeneficioRepository {

    @Autowired
    private JpaBeneficioRepository repository;

	
	@Override
	public List<BeneficioEntity> findByTipoAndEstado(String tipo,boolean estado) {

		var lista=repository.findByTipoAndEstado(tipo,estado);
		ArrayList<BeneficioEntity> list= new ArrayList<>();
	    BeneficioEntity entity;
		for (BeneficioModel model : lista) {
			entity= new BeneficioEntity();
			entity.setId(model.getId());
			entity.setNombre(model.getNombre());
			entity.setTipo(model.getTipo());
			entity.setEstado(model.isEstado());
			list.add(entity);
		}
		return list;
	}

	@Override
	public BeneficioEntity save(BeneficioEntity entity) {
		BeneficioModel model= new BeneficioModel();
		model.setId(entity.getId());
		model.setNombre(entity.getNombre());
		model.setTipo(entity.getTipo());
		model.setEstado(entity.isEstado());


		model= repository.save(model);
		entity.setId(model.getId());
		 return entity;
	}







	








}
	
	
	


