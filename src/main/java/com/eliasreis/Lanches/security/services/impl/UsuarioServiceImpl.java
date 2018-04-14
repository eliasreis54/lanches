package com.eliasreis.Lanches.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliasreis.Lanches.security.entities.Usuario;
import com.eliasreis.Lanches.security.repositories.UsuarioRepository;
import com.eliasreis.Lanches.security.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> buscarPorEmail(String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
}
