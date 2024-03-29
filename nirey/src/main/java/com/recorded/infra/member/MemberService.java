package com.recorded.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // BCryptPasswordEncoder import 추가
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberDao dao;
    
    // Spring Security의 BCryptPasswordEncoder를 사용하여 비밀번호를 암호화합니다.
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<MemberDto> selectList() { 
        return dao.selectList();
    }

    public MemberDto selectOne(MemberDto dto) {
        return dao.selectOne(dto);
    }

    public int insert(MemberDto dto) {
        // 비밀번호를 BCryptPasswordEncoder를 사용하여 암호화합니다.
        dto.setPwd(passwordEncoder.encode(dto.getPwd()));
        return dao.insert(dto);
    }
    
    public int update(MemberDto dto ) {
        return dao.update(dto);
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

        // 회원 정보가 존재하고, 입력된 비밀번호와 암호화된 비밀번호가 일치하는지 확인합니다.
        if (member != null && passwordEncoder.matches(pwd, member.getPwd())) {
            return member;
        } else {
            return null;
        }
    }
}
