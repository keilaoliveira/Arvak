package br.com.arvak.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.arvak.domain.Grupo;
import br.com.arvak.services.GrupoService;

@RestController
@RequestMapping(value="/grupos")
public class GrupoResource {
	
	@Autowired
	private GrupoService service;
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<Grupo> find(@PathVariable Integer id) {	
		Grupo obj = service.find(id);
		return ResponseEntity.ok().body(obj);			
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Grupo obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Grupo obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}
