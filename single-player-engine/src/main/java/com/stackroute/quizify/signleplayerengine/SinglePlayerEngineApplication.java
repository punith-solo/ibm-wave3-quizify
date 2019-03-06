package com.stackroute.quizify.signleplayerengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.stackroute.quizify")
public class SinglePlayerEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinglePlayerEngineApplication.class, args);
	}

}
