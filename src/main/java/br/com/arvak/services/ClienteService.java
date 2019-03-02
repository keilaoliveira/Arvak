package br.com.arvak.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.arvak.domain.Cliente;
import br.com.arvak.dto.ClienteDTO;
import br.com.arvak.repositories.ClienteRepository;
import br.com.arvak.services.exceptions.DataIntegrityException;
import br.com.arvak.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find (Integer id) {
		
		Cliente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Cliente não encontrado!!! Id: " + id + "!! Objeto do tipo: " + Cliente.class.getName());
		}
		return obj;
		
	}	

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getIdCliente());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		}
		catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir um cliente que possui pedidos vinculados!");
		}
	}
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getIdCliente(), objDto.getNomeCliente(), objDto.getEmail(), null, null);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNomeCliente(obj.getNomeCliente());
		newObj.setEmail(obj.getEmail());
	}

}
