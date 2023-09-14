package com.sukasa.infraestructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sukasa.infraestructure.models.BeneficioModel;
import com.sukasa.infraestructure.repositories.JpaBeneficioRepository;

@Service
public class BeneficioService {
       @Autowired
    JpaBeneficioRepository repository;

    public void save(List<BeneficioModel> models) {
      repository.saveAll(models);
    }
    public void deleteAll() {
        repository.deleteAll();
    }
}
