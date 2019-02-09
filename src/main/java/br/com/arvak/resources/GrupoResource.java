package br.com.arvak.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/grupos")
public class GrupoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String testarFuncionamento() {		
		return "Rest respondeu com sucesso!";
	}

}
