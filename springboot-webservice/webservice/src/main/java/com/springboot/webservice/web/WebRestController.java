package com.springboot.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
	
	// RestController 는 @ResponseBody 를 모든 메서드에 적용 시켜줌 
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	
	
	
	
	
}
