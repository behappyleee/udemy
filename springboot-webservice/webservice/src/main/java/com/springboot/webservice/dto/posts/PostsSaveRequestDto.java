package com.springboot.webservice.dto.posts;

import com.springboot.webservice.domain.posts.Posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
	
	// Controller 에서 @RequestBody 로 외부에서 데이터를 받는 경우에는 기본 생성자 + set 메서드를 통하여서만 값을 설정
	// 그래서 이때에만 setter 를 허용
	
	// 여기서 Entity 클래스와 거의 유사한 형태임에도 DTO 클래스를 추가로 생성, 절대로 테이블과 맵핑되는 
	// Entity 클래스를 Reuqest / Response 클래스로 사용을 하면 안됨
	// Entity 클래스는 가장 Core 한 클래스임 
	
	// 수많은 서비스 클래스나 비즈니스 로직들이 Entity 클래스를 기준으로 동작함
	
	// Entity 클래스가 변경되면 여러 클래스에 영향 을 끼치게 되는 반면 Request 와 Response 용 DTO 는 view 를 위한
	// 클래스라 정말 자주 변경이 필요
	
	// View Layer 와 DB Layer 를 철저하게 역할 분리를 하는게 좋음
	// 실제로 Controller 에서 결과 값으로 여러 테이블을 조인해서 줘야할 경우가 빈번하여 Entity 클래스 만으로는 표현이 어려움
	// 꼭 반드시 Entity 클래스와 Controller 에서 쓸 DTO 는 분리하여 사용하는게 좋음
	
	// 보통 Entity 에서는 해당 데이터의 생성시간과 수정시간을 포함시킴
	// 언제 만들어졌는지 언제 수정 되었는 지 차후 유지보수에 있어 굉장히 중요한 데이터임
	// 그렇다 보니 매번 DB 에 INSERT 하기 전 UPDATE 하기 전에 날짜 데이터를 등록 / 수정 하는 코드가 여기저기 들어가 있게 됨
	
	private String title;
	private String content;
	private String author;

	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
	
	
	
	
}
