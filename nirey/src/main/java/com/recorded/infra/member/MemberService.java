package com.recorded.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//Service = 로직, DAO를 호출하여 조합시키는 곳
public class MemberService {
	
	@Autowired
	MemberDao dao; 

	public List<MemberDto> selectList() { return dao.selectList();}

	public MemberDto selectOne(MemberDto dto) {
		return dao.selectOne(dto);
	}

	public int insert(MemberDto dto) {
		return dao.insert(dto);
	}
	
	public int update(MemberDto dto ) {
		return dao.update(dto);
	}
	
	
	public int uelete(MemberDto dto) {
		return dao.uelete(dto);
	}
	
	
	public int delete(MemberDto dto) {
		return dao.delete(dto);
	}

    public List<MemberDto> selectList(MemberVo vo) { 
    	return dao.selectList(vo); 
    }
	

}
