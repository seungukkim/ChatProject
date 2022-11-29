package com.study.domain.resttime;

public interface ResttimeMapper {
	
	/* List<String> restAsMbti */
	String getRestAsMbti (ResttimeRequest params);
	Integer randomNum (ResttimeRequest params);

}
