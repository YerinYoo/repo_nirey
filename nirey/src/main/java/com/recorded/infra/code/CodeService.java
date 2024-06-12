package com.recorded.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {

    @Autowired
    private CodeDao dao;

    public CodeDto selectOne(CodeDto dto) {
        return dao.selectOne(dto);
    }

    public int insert(CodeDto dto) {
        return dao.insert(dto);
    }

    public int update(CodeDto dto ) {
        return dao.update(dto);
    }

    public int delete(CodeDto dto) {
        return dao.delete(dto);
    }
    
    public int uelete(CodeDto dto) {
        return dao.uelete(dto);
    }

    public List<CodeDto> selectList(CodeVo vo) {
        return dao.selectList(vo);
    }

    //공통 코드 캐시에 올려 사용하기 위한 서비스 쿼리 
    @PostConstruct
    public void selectListCachedCodeArrayList() throws Exception {
        List<CodeDto> codeListFromDb = dao.selectListCachedCodeArrayList();
        CodeDto.cachedCodeArrayList.clear(); 
        CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
        System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " cached !");
    }

    public static String selectOneCachedCode(int code) throws Exception {
        String rt = "";
        for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
            if (codeRow.getSeq().equals(Integer.toString(code))) {
                rt = codeRow.getName();
                break; // 일치하는 코드를 찾으면 반복문 종료
            }
        }
        return rt;
    }
    
    //페이지네이션 관련
    public List<CodeDto> selectPagedCodeList(CodeVo vo) {
    	return dao.selectPagedCodeList(vo);
    }
    
    //개수 리턴
    public int getTotalCodeCount(CodeVo vo) {
    	return dao.getTotalCodeCount(vo);
    }
    
}