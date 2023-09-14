package com.sukasa.domain.interfaces.repositories;


import com.sukasa.domain.entities.BeneficioEntity;

public interface IBeneficioRepository {
    
    java.util.List<BeneficioEntity> findByTipoAndEstado(String tipo,boolean estado);
    BeneficioEntity save(BeneficioEntity entity);
}
