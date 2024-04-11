package com.recorded.infra.mix;

import java.util.List;

public interface MixDao {

	public List<MixDto> orderList(); 
	
	public List<MixDto> memberInfo();
	
	public List<MixDto> memberAddr();
	
}
