package com.springboot.webservice.domain.posts;



import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


// 보통 ibatis/mybatis 등 에서 DAO 라고 불리는 DB Layer 층 임
// JpaRepository <Entity 클래스, PK 타입> 을 상속 시 기본적은 CRUD 메서드가 자동 생성이 됨 (특별히 @Repository 어노테이션 불 필요)
public interface PostsRepository  extends JpaRepository<Posts, Long>{
	
	
	// 아래 코드는 SpringDataJpa 에서 제공하는 기본 메서드만으로 해결이 가능하지만
	// @Query 예제는 SpringDataJpa 에서 제공 하지 않는 메서드는 아래처럼 쿼리로 작성도 가능
	// Tip) 규모가 있는 프로젝트에서의 데이터 조회는 FK 의 조인, 복잡한 조건등으로 인해 이런 Entity 클래스만으로 처리하기 어려워
	// 조회용 프레임 워크를 추가로 사용함 대표적인 예로 querydsl, jooq, MyBatis 등이 있음 (조회는 해당 프레임 워크를 사용하고 등롱/수정/삭제 등 은 
	// SpringDataJpa 를 통하여 진행
	@Query("SELECT p " +
			"FROM Posts p " +
			"ORDER BY p.id DESC")
	Stream <Posts> findAllDesc();
	
	
	
	
}
