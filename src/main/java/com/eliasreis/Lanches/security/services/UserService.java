package com.eliasreis.Lanches.security.services;

import java.util.Optional;

import com.eliasreis.Lanches.security.entities.User;

public interface UserService {

	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<User> buscarPorEmail(String email);

}
