package com.recorded.infra.codegroup;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recorded.infra.code.CodeDao;
import com.recorded.infra.code.CodeDto;
import com.recorded.infra.code.CodeVo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
//Service = 로직, DAO를 호출하여 조합시키는 곳
public class CodeGroupService {
	
	@Autowired
	//CodeGroupDao codeGroupDao;
	//CodeGroupDao dao  = new CodeGroupDao();
	CodeGroupDao dao; //이미 만들어진 객체를 집어 넣음, 소프트웨어의 결합도가 높음 (=DI, 객체 주입)
 	
//	public List<CodeGroupDto> selectList() {
//		
//		List<CodeGroupDto> list = dao.selectList();
//
//		return list;
//	}
	//위의 구문과 같은 내용임, 아래 구문을 더 많이 사용함
	/* public List<CodeGroupDto> selectList() { return dao.selectList();} */
	
//	public CodeGroupDto selectOne(CodeGroupDto dto) {
//		CodeGroupDto codeGroupDto = dao.selectOne(dto);
//		
//		return codeGroupDto;
//	}
	
	//위 주석 3줄의 축약형
	public CodeGroupDto selectOne(CodeGroupDto dto) {
		return dao.selectOne(dto);
	}
	
//	public int insert(CodeGroupDto dto) { //insert 로직이기 때문에 insert가 메인이 됨
//		int a = dao.insert(dto); //리턴 타입 >> int
//		return a;
//	}
//	위 세 줄과 같은 내용 >> 축약
	public int insert(CodeGroupDto dto) {
		return dao.insert(dto);
	}
	
	public int update(CodeGroupDto dto ) {
		return dao.update(dto);
	}
	
	
	public int updtDel(CodeGroupDto dto) {
		return dao.updtDel(dto);
	}
	
	
	public int delete(CodeGroupDto dto) {
		return dao.delete(dto);
	}
	
    public List<CodeGroupDto> selectList(CodeGroupVo vo) { 
    	return dao.selectList(vo); 
    }

    public List<CodeGroupDto> selectListWithoutPaging() {
    	return dao.selectListWithoutPaging();
    }
    
    //페이지네이션 관련
    public List<CodeGroupDto> selectPagedCodeGroupList(CodeGroupVo vo) {
    	return dao.selectPagedCodeGroupList(vo);
    }
    
    //개수 리턴
    public int getTotalCodeGroupCount(CodeGroupVo vo) {
    	return dao.getTotalCodeGroupCount(vo);
    }

}
