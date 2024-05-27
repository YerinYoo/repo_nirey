package com.recorded.infra.mix;

import java.util.List;


public interface MixDao {

	public List<MixDto> orderList(); 
	
	public MixDto selectOrder(MixDto dto);
	
	public List<MixDto> productOrdered();
	
	public List<MixDto> memberInfo();
	
	public List<MixDto> memberAddr();
	
	public Integer checkOut(MixDto dto);
	
}
