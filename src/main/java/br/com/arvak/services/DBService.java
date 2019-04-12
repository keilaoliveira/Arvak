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
		Produto p7 = new Produto(null, "Pôster com Moldura Danger Zombie Area", 49.00);
		Produto p8 = new Produto(null, "Cardigan Drezzup Camuflado", 69.00);
		Produto p9 = new Produto(null, "Malha Colcci Básica Masculina", 189.00);
		Produto p10 = new Produto(null, "Kit Musculação 2 Barras Halteres", 250.00);
		Produto p11 = new Produto(null, "Perfume Angel - Thierry Mugler - 100ml", 779.00);		
		Produto p12 = new Produto(null, "Perfume Olympéa Feminino - 80ml", 399.00);
		Produto p13 = new Produto(null, "Perfume Paco Rabanne One Million - 50ml", 359.90);
		Produto p14 = new Produto(null, "Euphoria Calvin Klein - 30ml", 210.00);
		Produto p15 = new Produto(null, "Apple Watch Series 4, 44 mm", 2900.00);
		Produto p16 = new Produto(null, "Headphone/Fone de Ouvido Beats Bluetooth", 1619.90);
		Produto p17 = new Produto(null, "Jbl Charge 4 - Preto", 899.00);
		Produto p18 = new Produto(null, "TV 50 Polegadas LED Smart 4K ", 2499.00);
		Produto p19 = new Produto(null, "Console PlayStation 4 - Pro 1 TB - Preto", 2999.00);
		Produto p20 = new Produto(null, "The Walking Dead: Busca e destruição (Vol. 7)", 34.00);
		Produto p21 = new Produto(null, "A Sutil Arte de Ligar o F*da-Se", 21.00);
		Produto p22 = new Produto(null, "Do Mil ao Milhão. Sem Cortar o Cafezinho", 42.00);
		Produto p23 = new Produto(null, "O milagre da manhã", 25.00);
		Produto p24 = new Produto(null, "Assassin's Creed Odyssey - PlayStation 4", 129.00);
		Produto p25 = new Produto(null, "FIFA 19 - PlayStation 4", 279.00);
		Produto p26 = new Produto(null, "Call of Duty WWII - Xbox One", 119.00);
		Produto p27 = new Produto(null, "Wolfenstein II - The New Colossus - Xbox One", 81.00);
		Produto p28 = new Produto(null, "Luminária Palavras - Letreiro de Cinema", 49.00);
		Produto p29 = new Produto(null, "POP! Dean Winchester: Supernatural #94", 109.00);
		Produto p30 = new Produto(null, "Pop Imperial Death Trooper: Star Wars Rogue One #144 ", 99.00);
		Produto p31 = new Produto(null, "Caixa De Música Harry Potter", 159.90);
		Produto p32 = new Produto(null, "Luminária Mini Bloco Interrogação: Super Mario Bros", 109.00);
		Produto p33 = new Produto(null, "Batman Luminária Bat Sinal", 109.00);
		Produto p34 = new Produto(null, "Luva Goleiro Profissional NGA Soccer Legacy", 205.00);
		Produto p35 = new Produto(null, "Colchonete Tapete Yoga Mat Pilates", 99.00);
		Produto p36 = new Produto(null, "Extensor Elástico Multi Função Aeróbico", 26.00);
		Produto p37 = new Produto(null, "Bola de Futebol Americano Oficial NFL", 89.00);
		Produto p38 = new Produto(null, "Blazer Rioutlet Fashion Preto", 75.00);
		Produto p39 = new Produto(null, "Moletom Flanelado Fechado Cativa Disney", 64.00);
		Produto p40 = new Produto(null, "Camisa Polo Colcci Reta", 89.00);
		Produto p41 = new Produto(null, "Casaco Moletom Gatinho Meow", 139.00);

		gp1.getProdutos().addAll(Arrays.asList(p1, p2, p15, p16, p17, p18, p19));
		gp2.getProdutos().addAll(Arrays.asList(p3, p20, p21, p22, p23));
		gp3.getProdutos().addAll(Arrays.asList(p4, p5, p24, p25, p26, p27));
		gp4.getProdutos().addAll(Arrays.asList(p6, p7, p27, p28, p29, p30, p31, p32, p33));
		gp5.getProdutos().addAll(Arrays.asList(p8, p9, p38, p39, p40, p41));
		gp6.getProdutos().addAll(Arrays.asList(p10, p34, p35, p36, p37));
		gp7.getProdutos().addAll(Arrays.asList(p11,p12, p13, p14));
		
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
		p12.getGrupos().addAll(Arrays.asList(gp7));
		p13.getGrupos().addAll(Arrays.asList(gp7));
		p14.getGrupos().addAll(Arrays.asList(gp7));
		p15.getGrupos().addAll(Arrays.asList(gp1));
		p16.getGrupos().addAll(Arrays.asList(gp1));
		p17.getGrupos().addAll(Arrays.asList(gp1));
		p18.getGrupos().addAll(Arrays.asList(gp1));
		p19.getGrupos().addAll(Arrays.asList(gp1));
		p20.getGrupos().addAll(Arrays.asList(gp2));
		p21.getGrupos().addAll(Arrays.asList(gp2));
		p22.getGrupos().addAll(Arrays.asList(gp2));
		p23.getGrupos().addAll(Arrays.asList(gp2));
		p24.getGrupos().addAll(Arrays.asList(gp3));
		p25.getGrupos().addAll(Arrays.asList(gp3));
		p26.getGrupos().addAll(Arrays.asList(gp3));
		p27.getGrupos().addAll(Arrays.asList(gp3));
		p28.getGrupos().addAll(Arrays.asList(gp4));
		p29.getGrupos().addAll(Arrays.asList(gp4));
		p30.getGrupos().addAll(Arrays.asList(gp4));
		p31.getGrupos().addAll(Arrays.asList(gp4));
		p32.getGrupos().addAll(Arrays.asList(gp4));
		p33.getGrupos().addAll(Arrays.asList(gp4));
		p34.getGrupos().addAll(Arrays.asList(gp6));
		p35.getGrupos().addAll(Arrays.asList(gp6));
		p36.getGrupos().addAll(Arrays.asList(gp6));
		p37.getGrupos().addAll(Arrays.asList(gp6));
		p38.getGrupos().addAll(Arrays.asList(gp5));
		p39.getGrupos().addAll(Arrays.asList(gp5));
		p40.getGrupos().addAll(Arrays.asList(gp5));
		p41.getGrupos().addAll(Arrays.asList(gp5));
		
		grupoRepository.save(Arrays.asList(gp1, gp2, gp3, gp4, gp5, gp6, gp7));
		produtoRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, 
				p11, p12, p13, p14, p15, p16, p17, p18,p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31,
				p32, p33, p34, p35, p36, p37, p38, p39, p40, p41));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Santa Catarina");
		Estado est3 = new Estado(null, "Rio de Janeiro");
		Estado est4 = new Estado(null, "Minas Gerais");
		Estado est5 = new Estado(null, "Bahia");
		
		Cidade cid1 = new Cidade(null, "São Paulo", est1);
		Cidade cid2 = new Cidade(null, "Piracicaba", est1);
		Cidade cid3 = new Cidade(null, "Florianópolis", est2);
		Cidade cid4 = new Cidade(null, "Rio de Janeiro", est3);
		Cidade cid5 = new Cidade(null, "Parati", est3);
		Cidade cid6 = new Cidade(null, "Arraial do Cabo", est3);
		Cidade cid7 = new Cidade(null, "Campinas", est1);
		Cidade cid8 = new Cidade(null, "Blumenau", est2);
		Cidade cid9 = new Cidade(null, "Belo Horizonte", est4);
		Cidade cid10 = new Cidade(null, "Ouro Preto", est4);
		Cidade cid11 = new Cidade(null, "Uberlândia", est4);
		Cidade cid12 = new Cidade(null, "Salvador", est5);
		Cidade cid13 = new Cidade(null, "Ilhéus", est5);
		Cidade cid14 = new Cidade(null, "Porto Seguro", est5);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2, cid7));
		est2.getCidades().addAll(Arrays.asList(cid3, cid8));
		est3.getCidades().addAll(Arrays.asList(cid4, cid5, cid6));
		est4.getCidades().addAll(Arrays.asList(cid9, cid10, cid11));
		est5.getCidades().addAll(Arrays.asList(cid12, cid13, cid14));
		
		estadoRepository.save(Arrays.asList(est1, est2, est3, est4, est5));	
		cidadeRepository.save(Arrays.asList(cid1, cid2, cid3, cid4, cid5, cid6, cid7, cid8, cid9, cid10, cid11, cid12, cid13, cid14));		
				
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
