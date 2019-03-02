package br.com.arvak.dto;

import java.io.Serializable;

import br.com.arvak.domain.Grupo;

public class GrupoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricaoGrupo;
	
	public GrupoDTO() {		
	}
	
	public GrupoDTO(Grupo obj) {
		id = obj.getId();
		descricaoGrupo = obj.getDescricaoGrupo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoGrupo() {
		return descricaoGrupo;
	}

	public void setDescricaoGrupo(String descricaoGrupo) {
		this.descricaoGrupo = descricaoGrupo;
	}
	
	

}
