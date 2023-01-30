package com.springboot.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.webservice.domain.posts.Posts;
import com.springboot.webservice.domain.posts.PostsRepository;
import com.springboot.webservice.dto.posts.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanUp() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void Dto_데이터가_posts_테이블에_저장() {
		// 해당 테스트 코드는 DTO 클래스가 service.save 메서드에 전달이 되면 DB 에 잘 저장 되었는 지 검사하는 것
		// given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.author("chlee")
				.content("테스트")
				.title("테스트 타이틀")
				.build();
		
		// when
		postsService.save(dto);
		
		// then
		Posts posts = postsRepository.findAll().get(0);
		
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}
	
	
	
	
	
}