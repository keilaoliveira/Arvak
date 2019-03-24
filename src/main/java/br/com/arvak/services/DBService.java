package br.com.arvak.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.arvak.domain.Cidade;
import br.com.arvak.domain.Cliente;
import br.com.arvak.domain.Endereco;
import br.com.arvak.domain.Estado;
import br.com.arvak.domain.Grupo;
import br.com.arvak.domain.ItemPedido;
import br.com.arvak.domain.Pagamento;
import br.com.arvak.domain.PagamentoComBoleto;
import br.com.arvak.domain.PagamentoComCartao;
import br.com.arvak.domain.Pedido;
import br.com.arvak.domain.Produto;
import br.com.arvak.domain.enums.Perfil;
import br.com.arvak.domain.enums.SituacaoPagamento;
import br.com.arvak.domain.enums.TipoCliente;
import br.com.arvak.repositories.CidadeRepository;
import br.com.arvak.repositories.ClienteRepository;
import br.com.arvak.repositories.EnderecoRepository;
import br.com.arvak.repositories.EstadoRepository;
import br.com.arvak.repositories.GrupoRepository;
import br.com.arvak.repositories.ItemPedidoRepository;
import br.com.arvak.repositories.PagamentoRepository;
import br.com.arvak.repositories.PedidoRepository;
import br.com.arvak.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDataBase() throws ParseException {
		
		Grupo gp1 = new Grupo (null, "Eletrônicos");
		Grupo gp2 = new Grupo (null, "Livros"); 
		Grupo gp3 = new Grupo (null, "Jogos"); 
		Grupo gp4 = new Grupo (null, "Decoração"); 
		Grupo gp5 = new Grupo (null, "Roupas"); 
		Grupo gp6 = new Grupo (null, "Esportes"); 
		Grupo gp7 = new Grupo (null, "Perfumaria");
		
		Produto p1 = new Produto(null, "Notebook Dell i15", 4500.00);
		Produto p2 = new Produto(null, "Iphone XS Max", 7999.00);
		Produto p3 = new Produto(null, "Os segredos da mente milionária", 35.00);
		Produto p4 = new Produto(null, "God of War - PlayStation 4", 143.00);
		Produto p5 = new Produto(null, "GT Sport - PlayStation 4", 99.00);
		Produto p6 = new Produto(null, "Almofada Bordada Forest", 50.00);
		Produto p7 = new Produto(null, "Pôster com Moldura Danger Zombie Area", 49.90);
		Produto p8 = new Produto(null, "Cardigan Drezzup Camuflado", 69.00);
		Produto p9 = new Produto(null, "Malha Colcci Básica Masculina", 189.00);
		Produto p10 = new Produto(null, "Kit Musculação 2 Barras Halteres", 250.00);
		Produto p11 = new Produto(null, "Perfume Angel - Thierry Mugler - 100ml", 779.00);
		
		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);
		
		gp1.getProdutos().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
		p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
		p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		p12.getGrupos().add(gp1);
		p13.getGrupos().add(gp1);
		p14.getGrupos().add(gp1);
		p15.getGrupos().add(gp1);
		p16.getGrupos().add(gp1);
		p17.getGrupos().add(gp1);
		p18.getGrupos().add(gp1);
		p19.getGrupos().add(gp1);
		p20.getGrupos().add(gp1);
		p21.getGrupos().add(gp1);
		p22.getGrupos().add(gp1);
		p23.getGrupos().add(gp1);
		p24.getGrupos().add(gp1);
		p25.getGrupos().add(gp1);
		p26.getGrupos().add(gp1);
		p27.getGrupos().add(gp1);
		p28.getGrupos().add(gp1);
		p29.getGrupos().add(gp1);
		p30.getGrupos().add(gp1);
		p31.getGrupos().add(gp1);
		p32.getGrupos().add(gp1);
		p33.getGrupos().add(gp1);
		p34.getGrupos().add(gp1);
		p35.getGrupos().add(gp1);
		p36.getGrupos().add(gp1);
		p37.getGrupos().add(gp1);
		p38.getGrupos().add(gp1);
		p39.getGrupos().add(gp1);
		p40.getGrupos().add(gp1);
		p41.getGrupos().add(gp1);
		p42.getGrupos().add(gp1);
		p43.getGrupos().add(gp1);
		p44.getGrupos().add(gp1);
		p45.getGrupos().add(gp1);
		p46.getGrupos().add(gp1);
		p47.getGrupos().add(gp1);
		p48.getGrupos().add(gp1);
		p49.getGrupos().add(gp1);
		p50.getGrupos().add(gp1);
		
		gp1.getProdutos().addAll(Arrays.asList(p1, p2));
		gp2.getProdutos().addAll(Arrays.asList(p3));
		gp3.getProdutos().addAll(Arrays.asList(p4, p5));
		gp4.getProdutos().addAll(Arrays.asList(p6, p7));
		gp5.getProdutos().addAll(Arrays.asList(p8, p9));
		gp6.getProdutos().addAll(Arrays.asList(p10));
		gp7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getGrupos().addAll(Arrays.asList(gp1));
		p2.getGrupos().addAll(Arrays.asList(gp1));
		p3.getGrupos().addAll(Arrays.asList(gp2));	
		p4.getGrupos().addAll(Arrays.asList(gp3));
		p5.getGrupos().addAll(Arrays.asList(gp3));
		p6.getGrupos().addAll(Arrays.asList(gp4));
		p7.getGrupos().addAll(Arrays.asList(gp4));
		p8.getGrupos().addAll(Arrays.asList(gp5));
		p9.getGrupos().addAll(Arrays.asList(gp5));
		p10.getGrupos().addAll(Arrays.asList(gp6));
		p11.getGrupos().addAll(Arrays.asList(gp7));
		
		/*
		Grupo gp1 = new Grupo (null, "Informática");
		Grupo gp2 = new Grupo (null, "Escritório"); 
		Grupo gp3 = new Grupo (null, "Cama Mesa e Banho"); 
		Grupo gp4 = new Grupo (null, "Eletrônicos"); 
		Grupo gp5 = new Grupo (null, "Jardinagem"); 
		Grupo gp6 = new Grupo (null, "Decoração"); 
		Grupo gp7 = new Grupo (null, "Perfumaria"); 
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de Escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Regador", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Quadro", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		gp1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		gp2.getProdutos().addAll(Arrays.asList(p2, p4));
		gp3.getProdutos().addAll(Arrays.asList(p5, p6));
		gp4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		gp5.getProdutos().addAll(Arrays.asList(p8));
		gp6.getProdutos().addAll(Arrays.asList(p9, p10));
		gp7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getGrupos().addAll(Arrays.asList(gp1, gp4));
		p2.getGrupos().addAll(Arrays.asList(gp1, gp2, gp4));
		p3.getGrupos().addAll(Arrays.asList(gp1, gp4));	
		p4.getGrupos().addAll(Arrays.asList(gp2));
		p5.getGrupos().addAll(Arrays.asList(gp3));
		p6.getGrupos().addAll(Arrays.asList(gp3));
		p7.getGrupos().addAll(Arrays.asList(gp4));
		p8.getGrupos().addAll(Arrays.asList(gp5));
		p9.getGrupos().addAll(Arrays.asList(gp6));
		p10.getGrupos().addAll(Arrays.asList(gp6));
		p11.getGrupos().addAll(Arrays.asList(gp7));
		*/
		
		grupoRepository.save(Arrays.asList(gp1, gp2, gp3, gp4, gp5, gp6, gp7));
		produtoRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		produtoRepository.save(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Santa Catarina");
		
		Cidade cid1 = new Cidade(null, "São Paulo", est1);
		Cidade cid2 = new Cidade(null, "Piracicaba", est1);
		Cidade cid3 = new Cidade(null, "Florianópolis", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.save(Arrays.asList(est1, est2));	
		cidadeRepository.save(Arrays.asList(cid1, cid2, cid3));		
				
		Cliente cli1 = new Cliente(null, "Noah Oliveira", "keila.oliveira08@hotmail.com", "19145008060", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("25749687", "999863214"));
		
		Cliente cli2 = new Cliente(null, "Keila de Oliveira", "keila.oliver08@gmail.com", "38879382080", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("38749687", "988863214"));
		cli2.addPerfil(Perfil.ADMIN);
		
		Endereco end1 = new Endereco(null, "Avenida Paulista", "1521", "Apto. 85", "Consolação", "04258746", cli1, cid1);
		Endereco end2 = new Endereco(null, "Avenida Engenheiro Carlos Berrini", "2220", "Bloco 1 Apto.43", "Cidade Monções", "98563478", cli1, cid2);
		Endereco end3 = new Endereco(null, "Avenida Marquês de São Vicente", "1785", null, "Barra Funda", "99585000", cli2, cid1);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		cli2.getEnderecos().addAll(Arrays.asList(end3));
		
		
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(end1, end2, end3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("28/02/2019 17:38"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("01/03/2019 08:13"), cli1, end2);
		
		Pagamento pgto1 = new PagamentoComCartao(null, SituacaoPagamento.QUITADO, ped1, 8);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoComBoleto(null, SituacaoPagamento.PENDENTE, ped2, sdf.parse("10/03/2019 00:00"), null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pgto1, pgto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 4500.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 35.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 7999.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip2));
		p3.getItens().addAll(Arrays.asList(ip3));
		
		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
		
	}

}
