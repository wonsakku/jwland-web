package com.jwland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class JwlandWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwlandWebApplication.class, args);
	}

}
