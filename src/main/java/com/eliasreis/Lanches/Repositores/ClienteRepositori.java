package com.eliasreis.Lanches.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliasreis.Lanches.entities.Clientes;

public interface ClienteRepositori extends JpaRepository<Clientes, Long>{

}
