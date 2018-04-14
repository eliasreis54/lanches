package com.eliasreis.Lanches.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliasreis.Lanches.entities.Client;

public interface ClienteRepositori extends JpaRepository<Client, Long>{

}
