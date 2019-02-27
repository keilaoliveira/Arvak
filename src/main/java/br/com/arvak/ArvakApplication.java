package br.com.arvak;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.arvak.domain.Cidade;
import br.com.arvak.domain.Cliente;
import br.com.arvak.domain.Endereco;
import br.com.arvak.domain.Estado;
import br.com.arvak.domain.Grupo;
import br.com.arvak.domain.Produto;
import br.com.arvak.domain.enums.TipoCliente;
import br.com.arvak.repositories.CidadeRepository;
import br.com.arvak.repositories.ClienteRepository;
import br.com.arvak.repositories.EnderecoRepository;
import br.com.arvak.repositories.EstadoRepository;
import br.com.arvak.repositories.GrupoRepository;
import br.com.arvak.repositories.ProdutoRepository;

@SpringBootApplication
public class ArvakApplication implements CommandLineRunner {

	@Autowired
	private GrupoRepository grupoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ArvakApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Grupo gp1 = new Grupo (null, "Informática");
		Grupo gp2 = new Grupo (null, "Telefonia"); 
		
		Produto p1 = new Produto(null, "Notebook Dell I15", 4500.00);
		Produto p2 = new Produto(null, "Fone de Ouvido Bluetooh JBL", 650.00);
		Produto p3 = new Produto(null, "Iphone XS Max 256 Gb", 7200.00);
		
		gp1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		gp2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getGrupos().addAll(Arrays.asList(gp1));
		p2.getGrupos().addAll(Arrays.asList(gp1));
		p3.getGrupos().addAll(Arrays.asList(gp1, gp2));				
		
		grupoRepository.save(Arrays.asList(gp1, gp2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Santa Catarina");
		
		Cidade cid1 = new Cidade(null, "São Paulo", est1);
		Cidade cid2 = new Cidade(null, "Piracicaba", est1);
		Cidade cid3 = new Cidade(null, "Florianópolis", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.save(Arrays.asList(est1, est2));	
		cidadeRepository.save(Arrays.asList(cid1, cid2, cid3));		
		
		Cliente cli1 = new Cliente(null, "Dean Whinchester", "dean@google.com.br", "44433355566", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("25749687", "999863214"));
		
		Endereco end1 = new Endereco(null, "Avenida Paulista", "1521", "Apto. 85", "Consolação", "04258746", cli1, cid1);
		Endereco end2 = new Endereco(null, "Avenida Engenheiro Carlos Berrini", "2220", "Bloco 1 Apto.43", "Cidade Monções", "98563478", cli1, cid2);
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(end1, end2));
		
	}

	
}

