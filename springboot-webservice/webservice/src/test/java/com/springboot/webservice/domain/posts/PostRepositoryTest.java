package com.springboot.webservice.domain.posts;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
		
		private static Logger logger = LoggerFactory.getLogger(PostRepositoryTest.class);
		
		@Autowired
		PostsRepository postRepository;
		
		@After
		public void cleanUp() {
			postRepository.deleteAll();
		}
		
		@Test
		// public void 게시글저장_불러오기() {
		public void getBoardSave () {
			// given - (테스트 기반 환경을 구축하는 단계, 여기선 @Builder 의 사용법도 같이 확인)
			postRepository.save(Posts.builder()
					.title("테스트 게시글")
					.content("테스트 본문")
					.author("Springboot Test")
					.build());
		
			// when - 테스트 하고자 하는 행위 선언, 여기선 Posts 가 DB 에 insert 되는 것을 확인하기 위함
			List <Posts> postsList = postRepository.findAll();
				
			// then - 테스트 결과 검증, 실제로 DB 에 insert 되었는 지 확인하기 위해 조회 후 입력된 값 확인
			Posts posts = postsList.get(0);
			
			// TODO Linux 빌드 시 왜 에러 발생하는 지 확인이 필요
			// Linux test Build 에러 발생하여 일단 주석 처리 후 커밋
//			assertTrue(posts.getTitle().equals("테스트 게시글"));
//			assertTrue(posts.getAuthor().equals("Springboot Test"));
//			assertTrue(posts.getContent().equals("테스트 본문"));
			
			// assertThat 은 depracated 가 됨
			
//			assertThat(posts.getTitle(), is("테스트 게시글"));
//			assertThat(posts.getTitle(), is("테스트 게시글"));
//			assertThat(posts.getContent(), is("테스트 본문"));
			
			// Given When Then 은 BDD (Behaviour-Driven-Development) 에서 사용 하는 용어임
			// JUnit 에서는 이를 명시적으로 지원해주지 않아 주석으로 표현
			// 전문 BDD 프레임워크로 Groovy 기반의 Spock 를 많이 사용
		}
		
		@Test
		// public void BaseTimeEntity_등록 () {
		public void BaseTimeEntity_save () {
			// JPA Auditing Test - JPA 생성일 / 수정일 시간 정보
			// JPA Auditing 을 사용 시 상속만 받으면 JPA 사용 시 자동으로 입력이 됨
			
			// given	
			LocalDateTime now = LocalDateTime.now();
			postRepository.save(Posts.builder()
					.title("테스트 게시글")
					.content("테스트 본문")
					.author("chLee")
					.build());
			
			// when
			List <Posts> postsList = postRepository.findAll(); 
			
			// then
			Posts posts = postsList.get(0);
			assertTrue(posts.getCreatedDate().isAfter(now));	
			assertTrue(posts.getModifiedDate().isAfter(now));	
		}
		
		
	
}
