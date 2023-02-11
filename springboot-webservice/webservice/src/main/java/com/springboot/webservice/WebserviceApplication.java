package com.springboot.webservice;

import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing		// JPA Auditing 활성화
@SpringBootApplication
public class WebserviceApplication {

	 public static final String APPLICATION_LOCATIONS = "spring.config.location="
	            + "classpath:application.properties,"
	            + "/home/app/config/webservice/prod-application.yml";
	
	 public static void main(String[] args) {
		 new SpringApplicationBuilder(WebserviceApplication.class) 
		 		.profiles(APPLICATION_LOCATIONS)
		 		.run(args);
		// SpringApplication.run(WebserviceApplication.class, args);
	}

}
