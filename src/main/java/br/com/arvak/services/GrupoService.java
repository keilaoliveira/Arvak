package br.com.arvak.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.arvak.domain.Grupo;
import br.com.arvak.repositories.GrupoRepository;
import br.com.arvak.services.exceptions.DataIntegrityException;
import br.com.arvak.services.exceptions.ObjectNotFoundException;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository repo;

	public Grupo find(Integer id) {

		Grupo obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Grupo não encontrado!!! Id: " + id + "!! Objeto do tipo: " + Grupo.class.getName());
		}
		return obj;

	}

	public Grupo insert(Grupo obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Grupo update(Grupo obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		}
		catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir um grupo que possui produtos vinculados!");
		}
	}
	
	public List<Grupo> findAll(){
		return repo.findAll();
	}

}
