package br.com.arvak;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArvakApplication implements CommandLineRunner {
	/*
	@Autowired
	private S3Service s3Service;
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(ArvakApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {			
		//s3Service.uploadFile("D:\\temp\\fotos\\notebookDell.png");
	}

	
}

