package br.com.arvak.domain;

import java.util.Date;

import javax.persistence.Entity;

import br.com.arvak.domain.enums.SituacaoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto () {
	}

	public PagamentoComBoleto(Integer idPagamento, SituacaoPagamento situacao, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(idPagamento, situacao, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	

}
