package com.springboot.webservice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private static Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@GetMapping("/")
	public String main() {
		logger.info("/ WEB CONTROLLER");
		
		return "main";
	}
	
}
