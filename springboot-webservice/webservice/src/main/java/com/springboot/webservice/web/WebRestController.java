package com.springboot.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
	
	// RestController �� @ResponseBody �� ��� �޼��忡 ���� ������ 
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	
	
	
	
	
}