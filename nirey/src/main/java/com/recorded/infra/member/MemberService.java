package com.recorded.infra.member;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberDao dao;
    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<MemberDto> selectList() { 
        return dao.selectList();
    }

    public MemberDto selectOne(MemberDto dto) {
        return dao.selectOne(dto);
    }

    public int insert(MemberDto dto) {
        dto.setPwd(passwordEncoder.encode(dto.getPwd()));
        return dao.insert(dto);
    }
    
    public int update(MemberDto dto ) {
        return dao.update(dto);
    }
    
    public int updateUser(MemberDto dto) {
    	return dao.updateUser(dto);
    }
    
    public int uelete(MemberDto dto) {
    	return dao.uelete(dto);
    }
    
    public int delete(MemberDto dto) {
        return dao.delete(dto);
    }

    public List<MemberDto> selectList(MemberVo vo) { 
        return dao.selectList(vo); 
    }
    
    public List<MemberDto> selectPagedMemberList(MemberVo vo) {
        return dao.selectPagedMemberList(vo);
    }
    
    public int getTotalMemberCount(MemberVo vo) {
        return dao.getTotalMemberCount(vo);
    }
    
	    public MemberDto authenticate(String ID, String pwd) {
	        MemberDto member = dao.selectOneById(ID);
	
	        if (member != null && passwordEncoder.matches(pwd, member.getPwd())) {
	            return member;
	        } else {
	            return null;
	        }
	        
	    }

	    public MemberDto selectOneById(String id) {
	        MemberDto dto = new MemberDto();
	        dto.setID(id);
	        return dao.selectOne(dto);
	    }


}
