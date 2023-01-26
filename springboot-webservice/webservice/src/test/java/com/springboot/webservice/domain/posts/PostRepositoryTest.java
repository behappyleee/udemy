package com.springboot.webservice.domain.posts;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostRepositoryTest {
	
		@Autowired
		PostsRepository postRepository;
		
		@After(value="AFTER CLEANUP METHOD")
		public void cleanUp() {
			postRepository.deleteAll();
		}
		
		@Test
		public void 게시글저장_불러오기() {
			// given - (테스트 기반 환경을 구축하는 단계, 여기선 @Builder 의 사용법도 같이 확인)
			postRepository.save(
			
					// TODO 여기서 Builder 패턴이 적용이 안됨 확인하여 보기 .....
					);
			
			// when - 테스트 하고자 하는 행위 선언, 여기선 Posts 가 DB 에 insert 되는 것을 확인하기 위함
			
			
			
				
			// then - 테스트 결과 검증, 실제로 DB 에 insert 되었는 지 확인하기 위해 조회 후 입력된 값 확인
			
			
		}
		
	
}
