package com.eliasreis.Lanches.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliasreis.Lanches.security.entities.User;
import com.eliasreis.Lanches.security.repositories.UserRepository;
import com.eliasreis.Lanches.security.services.UserService;

@Service
public class UsuarioServiceImpl implements UserService {
	
	@Autowired
	private UserRepository usuarioRepository;
	
	public Optional<User> buscarPorEmail(String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
}
