package br.com.senai.gestaoDeCadastroFront;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;

import br.com.senai.gestaoDeCadastroFront.client.UserClient;
import br.com.senai.gestaoDeCadastroFront.dto.UsuarioDto;


@SpringBootApplication
public class InitApp {
	
	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
	@Bean
	public Hibernate5JakartaModule jsonHibernate5Module() {
		return new Hibernate5JakartaModule();
	}
	 
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			UserClient userClient = new UserClient();
			UsuarioDto dto = new UsuarioDto();
			dto.setEmail("example@gmail.com");
			dto.setSenha("12345678");
			dto.setRole("Administrador");
			UsuarioDto usuarioInserido = userClient.inserir(dto);
			System.out.println(usuarioInserido);
			
		};
	}
}
