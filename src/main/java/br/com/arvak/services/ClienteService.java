package br.com.arvak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arvak.domain.Cliente;
import br.com.arvak.repositories.ClienteRepository;
import br.com.arvak.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar (Integer id) {
		
		Cliente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Cliente não encontrado!!! Id: " + id + "!! Objeto do tipo: " + Cliente.class.getName());
		}
		return obj;
		
	}
}
