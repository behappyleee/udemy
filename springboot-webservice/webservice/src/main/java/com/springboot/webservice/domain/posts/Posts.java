package com.springboot.webservice.domain.posts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@NoArgsConstructor(access =AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts {
	
	// Posts 클래스는 실제 DB의 테이블과 매칭될 클래스, 보통 Entity 클래스라고 함
	// JPA 를 사용할 시 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는 이 Entity 클래스의 수정을 통하여 작업을 함
	
	// JPA 에서 제공하는 어노테이션들이 몇개 있음
	// @Entity -> 테이블과 링크될 클래스, 언더스코어 네이밍으로 이름을 매칭 ex) SalesManager.java -> sales_manager table
	
	// @Id -> 해당 테이블의 PK 필드를 나타냄
	// @GeneratedValue -> PK 의 생성규칙을 나타냄, 기본값은 AUTO, MySQL 의 auth_increment 와 같이 자동 증가하는 정수형
	// @Column -> 테이블의 컬럼을 나타낼 시 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
	//			  사용하는 이유는 기본 값 이외에 추가로 변경이 필요한 옵션이 있을 경우 사용
	//			  문자열의 경우 VARCHAR(255) 가 기본값인데 사이즈를 500으로 늘리고 싶거나 (ex:title) 타입을 TEXT 로 변경하고 싶을 시 (ex: content) 등의 경우에 사용 
	
	
	// @NoArgsConstructor (기본 생성자 자동 추가)
	// -> access = AccessLevel.PROTECTED 기본 생성자의 접근 권한을 PROTECTED 로 제한
	// -> 생성자로 protected Posts() {} 와 같은 효과
	// -> Entity 클래스를 프로젝트 코드상에서 기본 생성자로 생성하는 것은 막되, JPA 에서 Entity 클래스를 생성 하는 것은 허용하기 위해 추가
	
	// @Getter 
	// -> 클래스 내 모든 필드 Getter 메서드를 생성

	// @Builder 
	// -> 해당 클래스의 빌더패턴 클래스를 생성
	// -> 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
	
	// Lombok 의 어노테이션 들은 코드 변경량을 최소화 시켜주기에 사용을 권장
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition ="TEXT", nullable = false)
	private String content;
	
	private String author;
	
	// Builder 어노테이션은 Builder 패턴을 사용할 수 있게 해줌
	// Builder 패턴의 장점은 생성자 생성 시 어느 위치에 어느 파라미터가 잘 들어갈 수 있는지 확인을 해줌
	
	@Builder
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	
}
