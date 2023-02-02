package com.springboot.webservice.dto.posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.springboot.webservice.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {
	private Long id;
	private String title;
	private String author;
	private String modifiedDate;
	
	// Tip) Entity 가 toDto 와 같은 메서드로 dto 를 반환하면 되지 않나 ... ?
	// 해당 의문은 그렇게 하면 절대 안됨, DTO 는 Entity 를 사용하여도 되지만 Entity 는 DTO 에 대하여 전혀 모르게 코드를 구성하여야함
	// Entity 는 말 그대로 가장 core 한 클래스인 반면 DTO 는 View 혹인 외부 요청에 관련 있는 클래스임
	// 프로젝트 규모가 커질수록 분리해야 할 떄도 Entity 가 DTO 를 의존하고 있으면 분리하기가 굉장히 어려워 DTO 가 Entity 에 의존하도록 코드를
	// 작성하여야 함
	
	public PostsMainResponseDto(Posts entity) {
		id = entity.getId();
		title = entity.getTitle();
		author = entity.getAuthor();
		modifiedDate = toStringDateTime(entity.getModifiedDate());	// View 영역 에서는 LocalDateTime 타입을 모르기에 인식할 수 있도록 문자열로 변환
	}
	
	/**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
	
	/**
     * Java 7 버전
     */
    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
        if(localDateTime == null){
            return "";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
	
	
}
