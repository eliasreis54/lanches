package com.eliasreis.Lanches.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eliasreis.Lanches.entities.*;

public interface IngredientesRepositori extends JpaRepository<Ingredients, Long>{
	Ingredients findByNome(String nome);
}
