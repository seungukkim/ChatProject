package com.study.domain.resttime;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResttimeMapper {
	
	
	/**
     * 유저의 MBTI 체크
     * @param params - 회원 정보
     */
	String userMbti(ResttimeRequest params);
	
}
