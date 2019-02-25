package com.stackroute.quizify;

import com.stackroute.quizify.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@EnableEurekaClient
@SpringBootApplication

public class UserAuthenticationApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/v1/*");
		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationApplication.class, args);
	}

}

