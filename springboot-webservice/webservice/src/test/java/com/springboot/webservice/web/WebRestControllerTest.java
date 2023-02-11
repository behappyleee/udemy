package com.springboot.webservice.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
public class WebRestControllerTest {
	
	Logger logger = LoggerFactory.getLogger(WebRestControllerTest.class);
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void Profile_확인() {
		// Test 환경에서 Profile 이 Local 인 이유는 /src/test/resources 에 위치한 application.properties 파일 때문임
		// when
		String profile = this.restTemplate.getForObject("/profile", String.class);
		logger.info("Profile_확인  PROFILE : {} " , profile);
		
		// then 
		assertThat(profile).isEqualTo("local");
	}
	
	
	
	
	
}
