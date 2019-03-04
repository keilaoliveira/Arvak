package br.com.arvak.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.arvak.domain.Cliente;
import br.com.arvak.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idCliente;
	
	@NotEmpty(message="Esse campo é de preenchimento obrigatório!")
	@Length(min=5, max=100, message="O campo deve ter entre 5 e 100 caracteres")
	private String nomeCliente;
	
	@NotEmpty(message="Esse campo é de preenchimento obrigatório!")
	@Email(message="E-mail inválido. Verifique!")
	private String email;
	
	public ClienteDTO() {		
	}
	
	public ClienteDTO(Cliente obj) {
		idCliente = obj.getIdCliente();
		nomeCliente = obj.getNomeCliente();
		email = obj.getEmail();
		
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
