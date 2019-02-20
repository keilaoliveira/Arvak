package br.com.arvak;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.arvak.domain.Grupo;
import br.com.arvak.domain.Produto;
import br.com.arvak.repositories.GrupoRepository;
import br.com.arvak.repositories.ProdutoRepository;

@SpringBootApplication
public class ArvakApplication implements CommandLineRunner {

	@Autowired
	private GrupoRepository grupoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ArvakApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Grupo gp1 = new Grupo (null, "Informática");
		Grupo gp2 = new Grupo (null, "Telefonia"); 
		
		Produto p1 = new Produto (null, "Notebook Dell I15", 4500.00);
		Produto p2 = new Produto (null, "Fone de Ouvido Bluetooh JBL", 650.00);
		Produto p3 = new Produto (null, "Iphone XS Max 256 Gb", 7200.00);
		
		gp1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		gp2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getGrupos().addAll(Arrays.asList(gp1));
		p2.getGrupos().addAll(Arrays.asList(gp1));
		p3.getGrupos().addAll(Arrays.asList(gp1, gp2));
		
		grupoRepository.save(Arrays.asList(gp1, gp2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
	}

	
}

