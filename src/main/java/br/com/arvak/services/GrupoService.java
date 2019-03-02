package br.com.arvak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arvak.domain.Grupo;
import br.com.arvak.repositories.GrupoRepository;
import br.com.arvak.services.exceptions.ObjectNotFoundException;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository repo;
	
	public Grupo buscar (Integer id) {
		
		Grupo obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Grupo não encontrado!!! Id: " + id + "!! Objeto do tipo: " + Grupo.class.getName());
		}
		return obj;
		
	}
	
	public Grupo insert(Grupo obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
}
