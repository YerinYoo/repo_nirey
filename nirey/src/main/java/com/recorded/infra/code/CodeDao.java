package com.recorded.infra.code;

import java.util.List;

public interface CodeDao {

	public List<CodeDto> selectList(); 
	public CodeDto selectOne(CodeDto dto);
	
	public int insert(CodeDto dto);
	public int update(CodeDto dto);
	public int uelete(CodeDto dto);
	public int delete(CodeDto dto);
	public List<CodeDto> selectList(CodeVo vo);
	

    public List<CodeDto> selectListCachedCodeArrayList();
    
    //페이징 처리 리스트 
    public List<CodeDto> selectPagedCodeList(CodeVo vo);
    
    //개수 리턴
    public int getTotalCodeCount(CodeVo vo);
}
    
   
