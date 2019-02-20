package br.com.arvak.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.arvak.domain.Grupo;
import br.com.arvak.services.GrupoService;

@RestController
@RequestMapping(value="/grupos")
public class GrupoResource {
	
	@Autowired
	private GrupoService service;
	
	@RequestMapping(value="{id}" , method=RequestMethod.GET)
	public ResponseEntity<?> buscaGrupo(@PathVariable Integer id) {	
		Grupo obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);			
	}

}
