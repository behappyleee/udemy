package com.springboot.webservice.web;

import static org.assertj.core.api.Assertions.assertThat;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WebControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	// linux gradle test 실패여서 한글 메서드명 -> 영어로 수정하여 test
	@Test
	// public void 메인페이지_로딩 () {
	public void mainPage_loading () {
		// 해당 테스트는 실제로 URL 호출 시 제대로 페이지가 호출되는 지에 대한 테스트
		// HTML 도 결국 규칙이 있는 문자열 이기에 TestRestTemplate 을 통하여 "/" 를 호출 하였을 시 main.hbs 에 포함 된 코드들이 있는지 확인이 필요
		// when
		String body = this.restTemplate.getForObject("/", String.class);
		
		// then
		assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
	}
	
	
}
