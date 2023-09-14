package com.sukasa.domain.interfaces.repositories;


import com.sukasa.domain.entities.ClienteEntity;

public interface IClienteRepository {
    ClienteEntity registro(ClienteEntity user);
    java.util.List<ClienteEntity> usuariosRegistrados();
}
