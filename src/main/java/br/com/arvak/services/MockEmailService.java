package br.com.arvak.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulação de e-mail ");
		LOG.info(msg.toString());
		LOG.info("O email foi enviado com sucesso!");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulação de e-mail Html");
		LOG.info(msg.toString());
		LOG.info("O email foi enviado com sucesso!");
	}

}
