package br.com.arvak.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.arvak.domain.Cliente;
import br.com.arvak.domain.enums.TipoCliente;
import br.com.arvak.dto.ClienteNewDTO;
import br.com.arvak.repositories.ClienteRepository;
import br.com.arvak.resources.exception.FieldMessage;
import br.com.arvak.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getidTipoCliente()) && !BR.isValidCPF(objDto.getDocumentoCliente())) {
			list.add(new FieldMessage("documentoCliente", "Cpf inválido. Verifique!"));
		}
		
		if (objDto.getTipoCliente().equals(TipoCliente.PESSOAJURIDICA.getidTipoCliente()) && !BR.isValidCNPJ(objDto.getDocumentoCliente())) {
			list.add(new FieldMessage("documentoCliente", "Cnpj inválido. Verifique!"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "E-mail já existente!"));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
