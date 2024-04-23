package com.recorded.infra.etc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recorded.infra.member.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class EtcController { 

	//포트폴리오 페이지 연결 컨트롤러
    @RequestMapping(value = "/Nirey")
    public String pfIndex() throws Exception {
        return "etc/pfIndex"; 
    }
    
	//사용자 화면 > My Page > Dashboard컨트롤러
    @GetMapping(value="/MyPage/Dashboard")
    public String dashboard(HttpSession session, Model model) {
        // 세션에서 로그인한 회원 정보 가져오기
        MemberDto authenticatedMember = (MemberDto) session.getAttribute("authenticatedMember");

        // 세션에 로그인한 정보가 없으면 로그인 페이지로 리다이렉트
        if (authenticatedMember == null) {
            return "redirect:/recorded/Login";
        }

        // 회원 정보 수정 페이지로 이동하는 뷰 이름 반환
        return "usr/infra/v1/dashboard";
    }
    
   @RequestMapping(value="/recorded/Welcome")
   public String welcome() throws Exception {
	   return "usr/infra/v1/welcome";
   }
   

    
}
