package com.recorded.infra.mix;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recorded.infra.product.ProductDto;

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
	
	public List<MixDto> checkOut(){
		
		return dao.checkOut();
	}

	
}
