package br.com.arvak;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.arvak.domain.Grupo;
import br.com.arvak.repositories.GrupoRepository;

@SpringBootApplication
public class ArvakApplication implements CommandLineRunner {

	@Autowired
	private GrupoRepository grupoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ArvakApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Grupo gp1 = new Grupo (null, "Informática");
		Grupo gp2 = new Grupo (null, "Telefonia"); 
		
		grupoRepository.save(Arrays.asList(gp1, gp2));
		
	}

	
}

