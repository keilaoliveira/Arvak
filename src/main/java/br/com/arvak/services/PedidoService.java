package br.com.arvak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arvak.domain.Pedido;
import br.com.arvak.repositories.PedidoRepository;
import br.com.arvak.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido find (Integer id) {
		
		Pedido obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Pedido não encontrado!!! Id: " + id + "!! Objeto do tipo: " + Pedido.class.getName());
		}
		return obj;
		
	}
}
