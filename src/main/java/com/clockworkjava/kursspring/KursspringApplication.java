package com.clockworkjava.kursspring;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@PropertySource("classpath:KnightRepo.properties")
@EnableScheduling
@EntityScan("com.clockworkjava.kursspring.domain")
public class KursspringApplication{


	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(KursspringApplication.class, args);
	}


}
