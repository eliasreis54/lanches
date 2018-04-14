package com.eliasreis.Lanches.security.services;

import java.util.Optional;

import com.eliasreis.Lanches.security.entities.Usuario;

public interface UsuarioService {

	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> buscarPorEmail(String email);

}
