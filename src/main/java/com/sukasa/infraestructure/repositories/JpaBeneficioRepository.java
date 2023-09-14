package com.sukasa.infraestructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sukasa.infraestructure.models.BeneficioModel;

@Repository
public interface JpaBeneficioRepository  extends JpaRepository<BeneficioModel, Integer> {
List<BeneficioModel> findByTipoAndEstado(String tipo,boolean estado);

}
