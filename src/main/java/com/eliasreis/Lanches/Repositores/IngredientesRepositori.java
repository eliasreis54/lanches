package com.eliasreis.Lanches.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliasreis.Lanches.DTOs.LancheDTO;
import com.eliasreis.Lanches.entities.*;

public interface IngredientesRepositori extends JpaRepository<Ingredientes, Long>{
	Ingredientes findByNome(String nome);
}
