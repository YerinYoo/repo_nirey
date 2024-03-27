package com.recorded.infra.codegroup;

import java.util.List;

public interface CodeGroupDao {

    public CodeGroupDto selectOne(CodeGroupDto dto);

    public int insert(CodeGroupDto dto);

    public int update(CodeGroupDto dto);

    public int updtDel(CodeGroupDto dto);

    public int delete(CodeGroupDto dto);

    public List<CodeGroupDto> selectList(CodeGroupVo vo);

    public List<CodeGroupDto> selectListWithoutPaging();

    public int getTotalCodeGroupCount(CodeGroupVo vo);
}
