package br.com.arvak.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPedido;
	
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date dataVenda;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name="clienteId")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="enderecoDeEntregaId")
	private Endereco enderecoEntrega;
	
	@OneToMany(mappedBy="id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Pedido() {		
	}

	public Pedido(Integer idPedido, Date dataVenda, Cliente cliente, Endereco enderecoEntrega) {
		super();
		this.idPedido = idPedido;
		this.dataVenda = dataVenda;
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}
	
	public double getValorTotal() {
		double soma = 0.0;
		for(ItemPedido ip: itens) {
			soma = soma + ip.getSubTotal();
		}
		return soma;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("\nPedido Realizado com Sucesso!");
		builder.append("\n\nPedido número: #");
		builder.append(getIdPedido());
		builder.append("\nData Venda: ");
		builder.append(sdf.format(getDataVenda()));
		builder.append("\nCliente: ");
		builder.append(getCliente().getNomeCliente());
		builder.append("\nSituação do pagamento: ");
		builder.append(getPagamento().getSituacao().getdescricaoPagamento());
		builder.append("\n\nDetalhes:\n");
		for (ItemPedido ip: getItens()) {
			builder.append(ip.toString());
		}
		builder.append("\nValor total: ");
		builder.append(nf.format(getValorTotal()));
		builder.append("\n\nObrigado pela compra =) ! Volte Sempre! \n\n");
		return builder.toString();
	}

	
	
	
	
}
