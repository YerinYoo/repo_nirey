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
	
	public MixDto selectOrder(MixDto dto) {
		return dao.selectOrder(dto);
	}
	
	public List<MixDto> productOrdered() {
		return dao.productOrdered();
	}
	
	public List<MixDto> memberInfo(){
		return dao.memberInfo();
	}
	
	public Integer checkOut(MixDto dto) {
		return dao.checkOut(dto);
	}
	
}
