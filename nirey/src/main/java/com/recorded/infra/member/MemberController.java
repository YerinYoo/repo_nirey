package com.recorded.infra.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recorded.common.base.BaseController;


import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController extends BaseController {

    @Autowired
    MemberService service;

    // 로그인 페이지로 이동
    @RequestMapping(value = "/loginAdm")
    public String loginAdm(MemberDto dto) throws Exception {
        return "adm/infra/v1/loginAdm"; 
    }

    // 로그인 처리
    @PostMapping("/loginAdmPg")
    @ResponseBody
    public Map<String, Object> loginAdmPg(@ModelAttribute MemberDto dto, HttpSession httpSession) throws Exception {
        Map<String, Object> returnMap = new HashMap<>();

        // 입력된 아이디와 비밀번호를 서비스 레이어로 전달하여 인증 수행
        MemberDto authenticatedMember = service.authenticate(dto.getID(), dto.getPwd());

        // 인증된 회원이 존재하면 세션에 회원 정보 저장하고 성공 메시지 반환
        if (authenticatedMember != null) {
            httpSession.setAttribute("authenticatedMember", authenticatedMember);
            returnMap.put("rt", "success");
        } else {
            // 인증 실패 시 처리
            returnMap.put("rt", "fail");
        }

        return returnMap;
    }

    // 회원 가입 페이지로 이동
    @RequestMapping(value = "/signup")
    public String signup() throws Exception {
        return "adm/infra/v1/signup";
    }

    // 회원 가입 처리
    @PostMapping("/memberInsert")
    public String MemberInsert(MemberDto dto) throws Exception {
        String originalPwd = dto.getPwd(); // 사용자가 입력한 비밀번호 저장

        // 사용자가 입력한 비밀번호를 암호화하여 DTO 객체에 설정
        dto.setPwd(encodeBcrypt(dto.getPwd(), 9));

        // 데이터베이스에 삽입하기 전에 암호화된 비밀번호를 확인하고 출력
        System.out.println("Encrypted Password: " + dto.getPwd());

        // 사용자가 입력한 비밀번호와 암호화된 비밀번호를 비교하여 출력
        if (matchesBcrypt(originalPwd, dto.getPwd(), 10)) {
            System.out.println("Password Matches!");
        } else {
            System.out.println("Password Does Not Match!");
        }

        // 나머지 로직은 그대로 유지
        System.out.println(dto.toString());
        service.insert(dto);
        return "redirect:/Morders";
    }

    // 회원 탈퇴 처리
    @RequestMapping(value = "/MemberUelete")
    public String MemberUelete(MemberDto dto) throws Exception {
        service.uelete(dto);
        return "redirect:/Morders";
    }

    // 회원 삭제 처리
    @RequestMapping(value = "/MemberDelete")
    public String MemberDelete(MemberDto dto) throws Exception {
        service.delete(dto);
        return "redirect:/Morders";
    }

    // 회원 목록 조회
    @RequestMapping(value = "/Morders")
    public String Morders(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
        setSearch(vo);
        int rowcount = service.getTotalMemberCount(vo);
        model.addAttribute("listCount", rowcount);
        System.out.println(rowcount);
        model.addAttribute("list", service.selectPagedMemberList(vo));
        return "adm/infra/v1/Morders";
    }

    // 회원 상세 정보 조회
    @RequestMapping(value = "/MordersView")
    public String MordersView(MemberDto dto, Model model) throws Exception {
        model.addAttribute("item", service.selectOne(dto)); 
        return "adm/infra/v1/MordersView"; 
    }

    // 회원 정보 수정 페이지로 이동
    @RequestMapping(value = "/MordersForm")
    public String MordersForm(MemberDto dto, Model model) throws Exception {
        model.addAttribute("item", service.selectOne(dto)); 
        return "adm/infra/v1/MordersForm"; 
    }

    // 회원 추가 페이지로 이동
    @RequestMapping(value="/MordersAdd")
    public String MordersAdd() throws Exception {
        return "adm/infra/v1/MordersAdd";
    }

    // 검색 조건 설정 메서드
    public void setSearch(MemberVo vo) throws Exception {
        // 검색 조건 설정
    }
}
