package com.recorded.infra.member;

import java.util.List;

public interface MemberDao {

	public List<MemberDto> selectList(); 
	public MemberDto selectOne(MemberDto dto);
	
	public int insert(MemberDto dto);
	public int update(MemberDto dto);
	public int uelete(MemberDto dto);
	public int delete(MemberDto dto);
	
	public List<MemberDto> selectList(MemberVo vo);

	
}
