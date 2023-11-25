package br.com.senai.gestaoDeCadastroFront;

import java.awt.EventQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.senai.gestaoDeCadastroFront.dto.CadastroClienteDto;
import br.com.senai.gestaoDeCadastroFront.views.login.ViewLogin;

@SpringBootApplication
public class InitApp {
	
	@Autowired
	private ViewLogin telaLogin;
	
//	@Autowired
//	private NovoClienteClient cliente;
//	
	@Autowired
	private CadastroClienteDto clienteDto;
	
	public static void main(String[] args) {		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(InitApp.class);
		builder.headless(false);
		builder.run(args);
	}
	
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {		
		return args -> {			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {						
						telaLogin.setVisible(true);
//						clienteDto.setNome("João da Silva");
//						clienteDto.setCpf("123.168.468-25");
//						clienteDto.setEmail("joao.silva@gmail.com");
//						clienteDto.setSenha("123");
//						clienteDto.setTel("(48) 91234-7562");
//						cliente.inserir(clienteDto);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		};
	}	
}
