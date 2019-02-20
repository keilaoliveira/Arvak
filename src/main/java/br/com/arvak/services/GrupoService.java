package br.com.arvak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arvak.domain.Grupo;
import br.com.arvak.repositories.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository repo;
	
	public Grupo buscar (Integer id) {
		
		Grupo obj = repo.findOne(id);
		return obj;
		
	}
}
