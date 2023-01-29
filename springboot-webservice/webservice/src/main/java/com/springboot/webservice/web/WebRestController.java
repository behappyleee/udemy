package com.springboot.webservice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webservice.domain.posts.PostsRepository;
import com.springboot.webservice.dto.posts.PostsSaveRequestDto;
import com.springboot.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private static Logger logger = LoggerFactory.getLogger(WebRestController.class);
	
	// postRepository 생성자 필드에 @Autowired 어노테이션이 없음
	// SpringFramework 에서 bean 을 주입 받는 방법은 총 3가지임 (@Autowired, setter, 생성자)
	
	// 이중 가장 권하는 방식은 생성자로 주입받는 방식임 @Autowired 는 비권장방식
	// 즉 생성자로 Bean 객체를 받도록 하면 @Autowired 와 같은 효과를 볼 수 있음 
	
	// AllArgsConstructor 로 의존성 주입을 받음
	private PostsRepository postRepository;
	
	private PostsService postsService;
	
	// RestController �� @ResponseBody �� ��� �޼��忡 ���� ������ 
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		logger.info("POSTS SAVE DATA !!! : {} " , dto);
		// Service 에서 Service 를 만들었으므로 service 에 save 로 교체
		// postRepository.save(dto.toEntity());
		postsService.save(dto);
	}
	
	
	
}
