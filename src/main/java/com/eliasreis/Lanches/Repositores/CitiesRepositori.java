package com.eliasreis.Lanches.Repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliasreis.Lanches.entities.City;

public interface CitiesRepositori extends JpaRepository<City, Long> {
	City findByNome (String name);
}
