package br.com.bra.cofreinteligente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CofreinteligenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CofreinteligenteApplication.class, args);
	}

}
