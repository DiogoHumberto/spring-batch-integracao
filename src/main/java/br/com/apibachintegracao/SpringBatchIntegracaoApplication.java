package br.com.apibachintegracao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * @author dbosco
 *
 */

@SpringBootApplication
@EnableScheduling
public class SpringBatchIntegracaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchIntegracaoApplication.class, args);
	}

}
