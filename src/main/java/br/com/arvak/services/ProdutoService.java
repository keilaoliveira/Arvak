package br.com.arvak.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.arvak.domain.Grupo;
import br.com.arvak.domain.Produto;
import br.com.arvak.repositories.GrupoRepository;
import br.com.arvak.repositories.ProdutoRepository;
import br.com.arvak.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	public Produto find (Integer id) {
		
		Produto obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Produto não encontrado!!! Id: " + id + "!! Objeto do tipo: " + Produto.class.getName());
		}
		return obj;
		
	}	
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Grupo> grupos = grupoRepository.findAll(ids);
		return repo.findDistinctBydescricaoProdutoContainingAndGruposIn(nome, grupos, pageRequest);
	}
	
}
