package com.springboot.webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.webservice.domain.posts.PostsRepository;
import com.springboot.webservice.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	
	private static Logger logger = LoggerFactory.getLogger(PostsService.class);
	
	private PostsRepository postsRepository;
	
	// Controller 에서 Dto.toEntity 를 통하여서 바로 전달하여도 되지만 굳이 Service 에서 DTO 를 받는 이유는
	// Controller 에서 Service 에 역할을 분리하기 위함
	// 비즈니스 & 트랜잭션 관리는 모두 Service 에서 관리 View 와 연동 되는 부분은 Controller 에서 담당 하도록 구현
	
	// Transaction - 일반적으로 DB 데이터를 등록/수정/삭제 하는 Service 메서드는 @Transactional 을 필수적으로 가져감
	// 이 어노테이션 은 메서드 내에서 Exception 이 발생 시 해당 메서드 내에서 이루어진 모든 DB 작업을 초기화 시켜줌
	
	// ex) save 메서드를 통하여 10개를 등록하여야 하지만 5번 쨰 에서 Exception 이 발생 시 앞에 저장된 4개를 전부 롤백 
	// 정확히 애기하면 이미 넣은걸 롤백이 아니라 모든 처리가 정상적으로 이루어졌을 떄만 DB 에 커밋을 함
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		
		logger.info("TRANSACTIONAL SAVE LONG POSTSSAVE RQUEST DTO ! : {} ", dto);
		
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	
	
	
}
