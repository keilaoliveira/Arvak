package br.com.arvak.dto;

import java.io.Serializable;

import br.com.arvak.domain.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idCidade;
	private String descricaoCidade;
	
	public CidadeDTO() {
	}
	
	public CidadeDTO(Cidade obj) {
		idCidade = obj.getIdCidade();
		descricaoCidade = obj.getDescricaoCidade();
	}
	
	public Integer getIdCidade() {
		return idCidade;
	}
	
	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}
	
	public String getDescricaoCidade() {
		return descricaoCidade;
	}
	
	public void setDescricaoCidade(String descricaoCidade) {
		this.descricaoCidade = descricaoCidade;
	}
	
}
