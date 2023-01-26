package com.springboot.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


// 보통 ibatis/mybatis 등 에서 DAO 라고 불리는 DB Layer 층 임
// JpaRepository <Entity 클래스, PK 타입> 을 상속 시 기본적은 CRUD 메서드가 자동 생성이 됨 (특별히 @Repository 어노테이션 불 필요)
public interface PostsRepository  extends JpaRepository<Posts, Long>{
	
	
	
}
