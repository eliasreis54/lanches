package com.eliasreis.Lanches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.eliasreis.Lanches.Utils.PasswordUtils;
import com.eliasreis.Lanches.security.entities.User;
import com.eliasreis.Lanches.security.enums.ProfileEnum;
import com.eliasreis.Lanches.security.repositories.UserRepository;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class LanchesApplication {
	@Autowired
	private UserRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LanchesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			User usuario = new User();
			usuario.setEmail("teste@email.com");
			usuario.setPerfil(ProfileEnum.ROLE_USUARIO);
			usuario.setSenha(PasswordUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(usuario);
			
			User admin = new User();
			admin.setEmail("admin@email.com");
			admin.setPerfil(ProfileEnum.ROLE_ADMIN);
			admin.setSenha(PasswordUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(admin);
			
		};
	}
}
