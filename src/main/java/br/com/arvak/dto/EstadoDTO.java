package br.com.arvak.dto;

import java.io.Serializable;

import br.com.arvak.domain.Estado;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idEstado;
	private String descricaoEstado;

	public EstadoDTO() {
	}

	public EstadoDTO(Estado obj) {
		idEstado = obj.getIdEstado();
		descricaoEstado = obj.getDescricaoEstado();
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescricaoEstado() {
		return descricaoEstado;
	}

	public void setDescricaoEstado(String descricaoEstado) {
		this.descricaoEstado = descricaoEstado;
	}
}