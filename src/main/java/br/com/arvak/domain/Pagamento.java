package br.com.arvak.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import br.com.arvak.domain.enums.SituacaoPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idPagamento;
	private Integer situacao;
	
	@OneToOne
	@JoinColumn(name="pedidoId")
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {		
	}

	public Pagamento(Integer idPagamento, SituacaoPagamento situacao, Pedido pedido) {
		super();
		this.idPagamento = idPagamento;
		this.situacao = situacao.getidPagamento();
		this.pedido = pedido;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public SituacaoPagamento getSituacao() {
		return SituacaoPagamento.toEnum(situacao);
	}

	public void setSituacao(SituacaoPagamento situacao) {
		this.situacao = situacao.getidPagamento();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPagamento == null) ? 0 : idPagamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (idPagamento == null) {
			if (other.idPagamento != null)
				return false;
		} else if (!idPagamento.equals(other.idPagamento))
			return false;
		return true;
	}
	
	
}
