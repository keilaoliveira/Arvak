package br.com.arvak.dto;

import java.io.Serializable;

import br.com.arvak.domain.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idProduto;
	private String descricaoProduto;
	private Double preco;
	
	public ProdutoDTO() {		
	}

	public ProdutoDTO(Produto obj) {
		idProduto = obj.getIdProduto();
		descricaoProduto = obj.getDescricaoProduto();
		preco = obj.getPreco();
		
	}
	
	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
