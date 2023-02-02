package com.springboot.webservice.web;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.webservice.dto.posts.PostsMainResponseDto;
import com.springboot.webservice.service.PostsService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller
public class WebController {

	private static Logger logger = LoggerFactory.getLogger(WebController.class);
	
	private PostsService postsService;
	
	@GetMapping("/")
	public String main(Model model) {
		logger.info("/ WEB CONTROLLER");
		// 글 저장 목록 데이터
		List<PostsMainResponseDto> postsList = postsService.findAllDesc();
		model.addAttribute("posts", postsList);
		return "main";
	}
	
	
	
	
}
