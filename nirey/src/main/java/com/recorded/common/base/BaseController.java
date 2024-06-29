package com.recorded.common.base;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// BaseController 클래스 정의
public class BaseController {

	// planeText를 받아서 지정된 강도(strength)로 bcrypt 해싱한 결과를 반환하는 메서드
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

	// planeText와 해싱된 hashValue가 일치하는지 여부를 지정된 강도(strength)로 검사하여 반환하는 메서드
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
}
