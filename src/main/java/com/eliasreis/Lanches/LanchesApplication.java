package com.eliasreis.Lanches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eliasreis.Lanches.Utils.SenhaUtils;
import com.eliasreis.Lanches.security.entities.Usuario;
import com.eliasreis.Lanches.security.enums.PerfilEnum;
import com.eliasreis.Lanches.security.repositories.UsuarioRepository;

@SpringBootApplication
public class LanchesApplication {
	@Autowired
	private UsuarioRepository usuarioRepository;
	public static void main(String[] args) {
		SpringApplication.run(LanchesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args ->{
			Usuario usuario = new Usuario();
			usuario.setEmail("usuario@email.com");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(usuario);
			
			Usuario admin = new Usuario();
			admin.setEmail("admin@email.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(admin);
		};
	}
}
