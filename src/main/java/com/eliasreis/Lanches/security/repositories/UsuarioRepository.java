package com.eliasreis.Lanches.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.eliasreis.Lanches.security.entities.Usuario;

@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
