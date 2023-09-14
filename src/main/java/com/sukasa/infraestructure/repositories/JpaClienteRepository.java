package com.sukasa.infraestructure.repositories;

import com.sukasa.infraestructure.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClienteRepository  extends JpaRepository<ClienteModel, Integer> {

}
