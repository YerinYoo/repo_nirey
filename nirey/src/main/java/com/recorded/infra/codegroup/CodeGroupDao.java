package com.recorded.infra.codegroup;

import java.util.List;

public interface CodeGroupDao { //쿼리 실행 역할 (selectList, selectOne, delete, update)

	public List<CodeGroupDto> selectList(); // 관례적으로 목록을 가져오는 함수 이름은 selectList를 주로 씀
	public CodeGroupDto selectOne(CodeGroupDto dto); // 데이터 하나만 리턴할 때에는 List가 아닌 Dto로가져옴
	
	//Mapper 쿼리 구동시키는 함수가 CodeGroup Dto selectOne (CodeGroupDto dto);
	//리턴 타입이 CodeGroupDto
	//selectOne을 통해 함수를 호출함

	public int  insert(CodeGroupDto dto); //Mapper에 새로 만들어진 insert 태그 내부문과 Dao에 입력된 값이 일치해야 해당 값이 저장 위치를 찾아감
	public int update(CodeGroupDto dto);
	public int updtDel(CodeGroupDto dto);
	public int delete(CodeGroupDto dto);
	
}
