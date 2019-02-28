package br.com.arvak.domain;

import javax.persistence.Entity;

import br.com.arvak.domain.enums.SituacaoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao () {
	}

	public PagamentoComCartao(Integer idPagamento, SituacaoPagamento situacao, Pedido pedido, Integer numeroDeParcelas) {
		super(idPagamento, situacao, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	
	
	
	
}
