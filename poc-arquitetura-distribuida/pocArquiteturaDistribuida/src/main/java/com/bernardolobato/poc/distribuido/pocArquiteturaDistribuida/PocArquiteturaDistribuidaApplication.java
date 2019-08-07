package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PocArquiteturaDistribuidaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocArquiteturaDistribuidaApplication.class, args);
	}

}
