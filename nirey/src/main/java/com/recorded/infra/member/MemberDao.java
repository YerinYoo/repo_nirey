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

    //페이징 처리 리스트 
    public List<MemberDto> selectPagedMemberList(MemberVo vo);
    
    //개수 리턴
    public int getTotalMemberCount(MemberVo vo);
    
    // ID를 사용하여 회원 정보를 가져오는 메소드
    public MemberDto selectOneById(String ID);

    // 입력된 ID와 비밀번호가 일치하는지 확인하는 메소드
    public boolean checkPassword(String ID, String password);
    
}
