package br.com.arvak.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.arvak.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
