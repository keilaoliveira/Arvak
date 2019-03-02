package br.com.arvak.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.arvak.domain.Grupo;

public class GrupoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Esse campo é de preenchimento obrigatório!")
	@Length(min=3, max=60, message="O campo deve ter entre 3 e 60 caracteres")
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
