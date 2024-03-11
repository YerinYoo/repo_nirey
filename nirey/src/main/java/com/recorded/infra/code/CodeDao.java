package com.recorded.infra.code;

import java.util.List;

import com.recorded.infra.codegroup.CodeGroupDto;
import com.recorded.infra.codegroup.CodeGroupVo;

public interface CodeDao {

	public List<CodeDto> selectList(); 
	public CodeDto selectOne(CodeDto dto);
	
	public int insert(CodeDto dto);
	public int update(CodeDto dto);
	public int uelete(CodeDto dto);
	public int delete(CodeDto dto);
	public List<CodeDto> selectList(CodeVo vo);

}
