package com.study.domain.resttime;

import org.springframework.stereotype.Service;

import com.study.domain.register.RegisterMapper;
import com.study.domain.register.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResttimeService {
	private final ResttimeMapper resttimeMapper;
	
			// 유저의 MBTI 확인
			public String findUserMbti(final ResttimeRequest params) {
				return resttimeMapper.findUserMbti(params);
			}
}
