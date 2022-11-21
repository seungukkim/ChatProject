package com.study.domain.resttime;

import org.springframework.stereotype.Service;

import com.study.domain.register.RegisterMapper;
import com.study.domain.register.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResttimeService {
	private final ResttimeMapper resttimeMapper;
	
			//아이디 중복 검사용
			public int idconfig(final RegisterRequest params) {
				return resttimeMapper.mbtiCheck(params);
			}
}
