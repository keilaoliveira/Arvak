package br.com.arvak;

import java.text.SimpleDateFormat;
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
import br.com.arvak.domain.ItemPedido;
import br.com.arvak.domain.Pagamento;
import br.com.arvak.domain.PagamentoComBoleto;
import br.com.arvak.domain.PagamentoComCartao;
import br.com.arvak.domain.Pedido;
import br.com.arvak.domain.Produto;
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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ArvakApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Grupo gp1 = new Grupo (null, "Informática");
		Grupo gp2 = new Grupo (null, "Telefonia"); 
		Grupo gp3 = new Grupo (null, "Roupas"); 
		Grupo gp4 = new Grupo (null, "Pet"); 
		Grupo gp5 = new Grupo (null, "infantil"); 
		Grupo gp6 = new Grupo (null, "Games"); 
		Grupo gp7 = new Grupo (null, "Cultura e Entretenimento"); 
		
		Produto p1 = new Produto(null, "Notebook Dell I15", 4500.00);
		Produto p2 = new Produto(null, "Fone de Ouvido Bluetooh JBL", 650.00);
		Produto p3 = new Produto(null, "Iphone XS Max 256 Gb", 7200.00);
		
		gp1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		gp2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getGrupos().addAll(Arrays.asList(gp1));
		p2.getGrupos().addAll(Arrays.asList(gp1));
		p3.getGrupos().addAll(Arrays.asList(gp1, gp2));				
		
		grupoRepository.save(Arrays.asList(gp1, gp2, gp3, gp4, gp5, gp6, gp7));
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
		ItemPedido ip2 = new ItemPedido(ped1, p2, 0.00, 2, 650.00);
		ItemPedido ip3 = new ItemPedido(ped2, p3, 100.00, 1, 7200.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip2));
		p3.getItens().addAll(Arrays.asList(ip3));
		
		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
		
	}

	
}

