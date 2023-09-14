package com.sukasa.infraestructure.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sukasa.domain.entities.ClienteEntity;
import com.sukasa.domain.interfaces.repositories.IClienteRepository;
import com.sukasa.infraestructure.models.ClienteModel;

@Repository
public class ClienteRepository implements IClienteRepository {

    @Autowired
    private JpaClienteRepository jpaUserRepository;

	

	@Override
	public ClienteEntity registro(ClienteEntity entity) {
		ClienteModel model= new ClienteModel();
		model.setId(entity.getId());
		model.setNombre(entity.getNombre());
		model.setTelefono(entity.getTelefono());
		model.setCorreoElectronico(entity.getCorreoElectronico());
		model.setGrupo(entity.getGrupo());
		model.setBeneficio(entity.getBeneficio());

		model= jpaUserRepository.save(model);

		entity.setId(model.getId());
		return entity;
	}



	@Override
	public List<ClienteEntity> usuariosRegistrados() {

		var lista=jpaUserRepository.findAll();

		ArrayList<ClienteEntity> list= new ArrayList<>();
		ClienteEntity entity;
		for (ClienteModel model : lista) {
			entity= new ClienteEntity();
			entity.setId(model.getId());
			entity.setNombre(model.getNombre());
			entity.setCorreoElectronico(model.getCorreoElectronico());
			entity.setTelefono(model.getTelefono());
			entity.setGrupo(model.getGrupo());
			entity.setBeneficio(model.getBeneficio());
			list.add(entity);
		}

		return list;
	}
    


}
	
	
	


