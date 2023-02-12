package com.springboot.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.AllArgsConstructor;

@EnableJpaAuditing		// JPA Auditing 활성화
@SpringBootApplication
@AllArgsConstructor
public class WebserviceApplication {

	private static final Logger logger = LoggerFactory.getLogger(WebserviceApplication.class);
	
	public static final String APPLICATION_LOCATIONS = // "spring.config.additional-location="
			 "spring.config.location="
			 + "classpath:application.properties,"
	         + "classpath:application-test.yml,";
	 		 // + "file:C:///Users/dhfhf/Desktop/application-ext.properties";
	/*
	 * mvn spring-boot:run
	 * -Dspring.config.location="file:///Users/home/jdbc.properties" mvn
	 * spring-boot:run
	 * -Dspring.config.location="file:///D:/config/aliyun-oss-java/application.yml"
	 */
	
	
	public static void main(String[] args) {
		 // logger.info("TEST ACTIVE PROFILE TEST : {} ", System.getProperty("spring.profiles.active"));
//		 new SpringApplicationBuilder(WebserviceApplication.class) 
//		 		.profiles(APPLICATION_LOCATIONS)
//		 		.run(args);
//		 
//		 logger.info("TEST ACTIVE PROFILE TEST : {} ", System.getProperty("spring.profiles.active"));
		
		SpringApplication.run(WebserviceApplication.class, args);
	}

}
