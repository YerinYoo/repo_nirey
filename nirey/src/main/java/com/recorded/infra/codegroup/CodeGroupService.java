package com.recorded.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeGroupService {
    
    private final CodeGroupDao dao;

    @Autowired
    public CodeGroupService(CodeGroupDao dao) {
        this.dao = dao;
    }
    
    public CodeGroupDto selectOne(CodeGroupDto dto) {
        return dao.selectOne(dto);
    }
    
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
    
    public int getTotalCodeGroupCount(CodeGroupVo vo) {
        return dao.getTotalCodeGroupCount(vo);
    }
}
