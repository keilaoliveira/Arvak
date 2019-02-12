package br.com.arvak.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.arvak.domain.Grupo;

@RestController
@RequestMapping(value="/grupos")
public class GrupoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Grupo> listaGrupo() {	
		
		Grupo gp1 = new Grupo(1, "Eletrônicos");
		Grupo gp2 = new Grupo(2, "Alimentos");
		
		List<Grupo> listarGrupo = new ArrayList<>();
		listarGrupo.add(gp1);
		listarGrupo.add(gp2);
		
		
		return listarGrupo;
	}

}
