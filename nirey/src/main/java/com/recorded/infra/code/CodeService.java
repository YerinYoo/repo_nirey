package com.recorded.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;


@Service
//Service = 로직, DAO를 호출하여 조합시키는 곳
public class CodeService {
	
	@Autowired
	//CodeDao CodeDao;
	//CodeDao dao  = new CodeDao();
	CodeDao dao; //이미 만들어진 객체를 집어 넣음, 소프트웨어의 결합도가 높음 (=DI, 객체 주입)
 	
//	public List<CodeDto> selectList() {
//		
//		List<CodeDto> list = dao.selectList();
//
//		return list;
//	}
	//위의 구문과 같은 내용임, 아래 구문을 더 많이 사용함
	public List<CodeDto> selectList() { return dao.selectList();}
	
//	public CodeDto selectOne(CodeDto dto) {
//		CodeDto CodeDto = dao.selectOne(dto);
//		
//		return CodeDto;
//	}
	
	//위 주석 3줄의 축약형
	public CodeDto selectOne(CodeDto dto) {
		return dao.selectOne(dto);
	}
	
//	public int insert(CodeDto dto) { //insert 로직이기 때문에 insert가 메인이 됨
//		int a = dao.insert(dto); //리턴 타입 >> int
//		return a;
//	}
//	위 세 줄과 같은 내용 >> 축약
	public int insert(CodeDto dto) {
		return dao.insert(dto);
	}
	
	public int update(CodeDto dto ) {
		return dao.update(dto);
	}
	
	
	public int uelete(CodeDto dto) {
		return dao.uelete(dto);
	}
	
	
	public int delete(CodeDto dto) {
		return dao.delete(dto);
	}

    public List<CodeDto> selectList(CodeVo vo) { 
    	return dao.selectList(vo); 
    }
    
    @PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) dao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear(); 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
    
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getSeq().equals(Integer.toString(code))) {
				rt = codeRow.getName();
			} else {
				// by pass
			}
		}
		return rt;
	}
	

}
