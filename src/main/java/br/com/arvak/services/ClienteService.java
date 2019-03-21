package br.com.arvak.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.arvak.domain.Cidade;
import br.com.arvak.domain.Cliente;
import br.com.arvak.domain.Endereco;
import br.com.arvak.domain.enums.Perfil;
import br.com.arvak.domain.enums.TipoCliente;
import br.com.arvak.dto.ClienteDTO;
import br.com.arvak.dto.ClienteNewDTO;
import br.com.arvak.repositories.ClienteRepository;
import br.com.arvak.repositories.EnderecoRepository;
import br.com.arvak.security.UserSS;
import br.com.arvak.services.exceptions.AuthorizationException;
import br.com.arvak.services.exceptions.DataIntegrityException;
import br.com.arvak.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private S3Service s3Service;
	
	public Cliente find (Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("O acesso a esse perfil não é permitido!");
		}
		
		Cliente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Cliente não encontrado!!! Id: " + id + "!! Objeto do tipo: " + Cliente.class.getName());
		}
		return obj;
		
	}	
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setIdCliente(null);
		obj = repo.save(obj);
		enderecoRepository.save(obj.getEnderecos());
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
		return new Cliente(objDto.getIdCliente(), objDto.getNomeCliente(), objDto.getEmail(), null, null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNomeCliente(), objDto.getEmail(), objDto.getDocumentoCliente(), TipoCliente.toEnum(objDto.getTipoCliente()), pe.encode(objDto.getSenha()));
		Cidade cid = new Cidade(objDto.getCidadeId(),null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() !=null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() !=null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNomeCliente(obj.getNomeCliente());
		newObj.setEmail(obj.getEmail());
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile) {
		return s3Service.uploadFile(multipartFile);
	}

}
