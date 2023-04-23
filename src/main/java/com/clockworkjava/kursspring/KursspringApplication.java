package com.clockworkjava.kursspring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:KnightRepo.properties")
public class KursspringApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(KursspringApplication.class, args);
	}
}
