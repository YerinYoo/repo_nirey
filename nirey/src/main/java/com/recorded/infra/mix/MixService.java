package com.recorded.infra.mix;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MixService {

	@Autowired
	MixDao dao;
	
	public List<MixDto> orderList() {
		return dao.orderList();
	}
	
	public List<MixDto> memberInfo(){
		return dao.memberInfo();
	}
	
	public List<MixDto> memberAddr(){
		return dao.memberAddr();
	}
}
