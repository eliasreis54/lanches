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
	public static void main(String[] args) {
		SpringApplication.run(LanchesApplication.class, args);
	}
	
}
