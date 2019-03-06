package br.com.arvak.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.arvak.domain.ItemPedido;
import br.com.arvak.domain.PagamentoComBoleto;
import br.com.arvak.domain.Pedido;
import br.com.arvak.domain.enums.SituacaoPagamento;
import br.com.arvak.repositories.ItemPedidoRepository;
import br.com.arvak.repositories.PagamentoRepository;
import br.com.arvak.repositories.PedidoRepository;
import br.com.arvak.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	public Pedido find (Integer id) {
		
		Pedido obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Pedido não encontrado!!! Id: " + id + "!! Objeto do tipo: " + Pedido.class.getName());
		}
		return obj;
		
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setIdPedido(null);
		obj.setDataVenda(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getIdCliente()));
		obj.getPagamento().setSituacao(SituacaoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();			
			boletoService.preencherPagamentoComBoleto(pagto, obj.getDataVenda());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip: obj.getItens()) {
			ip.setDesconto(0.0);
			//ip.setValor(produtoRepository.findOne(ip.getProduto().getIdProduto()).getPreco());
			ip.setProduto(produtoService.find(ip.getProduto().getIdProduto()));
			ip.setValor(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.save(obj.getItens());
		System.out.println(obj);
		return obj;
	}
}
