package com.recorded.infra.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recorded.common.base.BaseController;
import com.recorded.common.constants.Constants;
import com.recorded.infra.mail.MailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController extends BaseController {

    @Autowired
    MemberService service;
    @Autowired
    MailService mailService;
    
    //Admin Controller S
    
    // 로그인 페이지로 이동
    @RequestMapping(value = "/loginAdm")
    public String loginAdm(MemberDto dto) throws Exception {
    	
        return "adm/infra/v1/loginAdm"; 
    }

    // 로그인 처리
    @ResponseBody
    @RequestMapping(value = "loginAdmPg")
    public Map<String, Object> loginAdmPg(MemberDto dto, HttpSession httpSession) throws Exception {
        Map<String, Object> returnMap = new HashMap<>();

        // 입력된 아이디와 비밀번호를 서비스 레이어로 전달하여 인증 수행
        MemberDto authenticatedMember = service.authenticate(dto.getID(), dto.getPwd());

        // 인증된 회원이 존재하면 세션에 회원 정보 저장하고 성공 메시지 반환
        if (authenticatedMember != null) {
            // 로그인 성공 시 세션에 회원 정보 저장
            httpSession.setAttribute("authenticatedMember", authenticatedMember);
            httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60초 * 30분 = 30분
            httpSession.setAttribute("sessSeqXdm", authenticatedMember.getMemberSeq());
            httpSession.setAttribute("sessIdXdm", authenticatedMember.getID());
            httpSession.setAttribute("sessNameXdm", authenticatedMember.getName());
            
			System.out.println("---------------------");
			System.out.println("httpSession.getAttribute(\"sessNameXdm\"): " + httpSession.getAttribute("sessNameXdm"));
			System.out.println("---------------------");

            returnMap.put("rt", "success");
        } else {
            // 인증 실패 시 처리
            returnMap.put("rt", "fail");
        }

        return returnMap;
    }
    
    //로그아웃 - 연결 페이지 헤더의 session 부분 초기화됨
    @ResponseBody
    @RequestMapping(value="/logoutAdm")
    public Map<String, Object> logoutAdm(HttpSession httpSession) throws Exception{
    	Map<String, Object> returnMap=new HashMap<String, Object>();
    	httpSession.invalidate();
    	returnMap.put("rt", "success");
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

        // 입력 값이 없으면 0으로 설정
        if (dto.getDormantNY() == null) {
            dto.setDormantNY(0);
        }
        if (dto.getQuitNY() == null) {
            dto.setQuitNY(0);
        }

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
        
        return "redirect:/loginAdm";
    }

 // 회원 정보 수정 처리
 @PostMapping("/MemberUpdate")
 public String MemberUpdate(@ModelAttribute MemberDto dto) throws Exception {
     service.update(dto); // 서비스 계층으로 수정된 값 전달
     return "redirect:/MemberList"; // 수정된 정보가 표시된 상세 페이지로 이동
 }

 @ResponseBody
 @RequestMapping("/updateUser")
 public String updateUser(@ModelAttribute MemberDto dto, HttpSession session) throws Exception {
     service.updateUser(dto);
     System.out.println("업데이트 완료!!");
     
     // 세션에서 로그인한 회원 정보 가져오기
     MemberDto authenticatedMember = (MemberDto) session.getAttribute("authenticatedMember");

     // 세션에 로그인한 정보가 없으면 리다이렉트하지 않고 에러 처리 또는 다른 방식으로 처리
     if (authenticatedMember == null) {
         return "error"; 
     }

     // 리다이렉트 전에 세션에 저장된 회원 정보를 다시 모델에 추가
     session.setAttribute("authenticatedMember", authenticatedMember);

     return "redirect:/MyPage/AccountSettings"; //리턴 경로 에러? 왜인지 확인하기 
 }


    // 회원 탈퇴 처리
 	@RequestMapping(value="/MemberUelete")
 	public String MemberUelete(MemberDto dto) throws Exception {
 		 service.uelete(dto);
 		 return "redirect:/MemberList";
 	}
 
    @RequestMapping(value = "/MemberMultiUelete")
    public String MemberMultiUelete(MemberDto dto) throws Exception {
    	String[] checkboxSeqArray = dto.getCheckboxSeqArray();
		for(String checkboxSeq : checkboxSeqArray) {
			dto.setMemberSeq(checkboxSeq);
			service.uelete(dto);
		}
		
        return "redirect:/MemberList";
    }

    // 회원 삭제 처리
    @RequestMapping(value = "/MemberDelete")
    public String MemberDelete(MemberDto dto) throws Exception {
        service.delete(dto);
        return "redirect:/MemberList";
    }

    // 회원 목록 조회
    @RequestMapping(value = "/MemberList")
    public String Morders(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
        setSearch(vo);
        int rowcount = service.getTotalMemberCount(vo);
        model.addAttribute("listCount", rowcount);
        System.out.println(rowcount);
        model.addAttribute("list", service.selectPagedMemberList(vo));
        return "adm/infra/v1/Morders";
    }

	@RequestMapping(value = "/MemberView")
	public String MordersView(MemberDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto)); 
		
		return "adm/infra/v1/MordersView"; 
	}

    // 회원 추가 페이지로 이동
    @RequestMapping(value="/AddMember")
    public String MordersAdd() throws Exception {
        return "adm/infra/v1/MordersAdd";
    }

    // 검색 조건 설정 메서드
    public void setSearch(MemberVo vo) throws Exception {
        // 검색 조건 설정
    }
    
    @RequestMapping(value="/EditMember")
    public String EditMember(MemberDto dto, Model model) throws Exception {
    	
    	model.addAttribute("item", service.selectOne(dto));
    	
    	return "adm/infra/v1/MordersEdit";
    }
    
    //adm page index
    @RequestMapping(value = "/index")
	public String ordersAdd(MemberDto dto) throws Exception {
		return "adm/infra/v1/index";
	}
    
    //-----------------------------------------------------------Admin Controller E
    //-----------------------------------------------------------eCommerce Controller S
    
    //  회원 로그인 페이지
    @RequestMapping(value = "/recorded/Login")
    public String loginUsr(MemberDto dto) throws Exception {
    	
        return "usr/infra/v1/loginUsr"; 
    }

    // 로그인 처리
    @ResponseBody
    @RequestMapping(value = "loginUsrPg")
    public Map<String, Object> loginUsrPg(MemberDto dto, HttpSession httpSession) throws Exception {
        Map<String, Object> returnMap = new HashMap<>();

        // 입력된 아이디와 비밀번호를 서비스 레이어로 전달하여 인증 수행
        MemberDto authenticatedMember = service.authenticate(dto.getID(), dto.getPwd());

        // 인증된 회원이 존재하면 세션에 회원 정보 저장하고 성공 메시지 반환
        if (authenticatedMember != null) {
            // 로그인 성공 시 세션에 회원 정보 저장
            httpSession.setAttribute("authenticatedMember", authenticatedMember);
            httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60초 * 30분 = 30분
            httpSession.setAttribute("sessSeqUsr", authenticatedMember.getMemberSeq());
            httpSession.setAttribute("sessIdUsr", authenticatedMember.getID());
            httpSession.setAttribute("sessPwdUsr", authenticatedMember.getPwd());
            httpSession.setAttribute("sessNameUsr", authenticatedMember.getName());
            httpSession.setAttribute("sessEmailUsr", authenticatedMember.getEmail());
            httpSession.setAttribute("sessGenderUsr", authenticatedMember.getGenderCD());
            httpSession.setAttribute("sessMobileNumUsr", authenticatedMember.getMobileNum());
            httpSession.setAttribute("sessBirthDayUsr", authenticatedMember.getBirthday());
            httpSession.setAttribute("sessAddrDetailUsr", authenticatedMember.getAddrDetail());
            httpSession.setAttribute("sessAddrUsr", authenticatedMember.getAddr());
            httpSession.setAttribute("sessZipcodeUsr", authenticatedMember.getZipcode());
            httpSession.setAttribute("sessRecipientUsr", authenticatedMember.getRecipient());
            httpSession.setAttribute("sessPhoneNumUsr", authenticatedMember.getPhoneNum());
            httpSession.setAttribute("sessShippingMsgUsr", authenticatedMember.getShippingMsg());
         
			System.out.println("---------------------");
			System.out.println("httpSession.getAttribute(\"sessNameUsr\"): " + httpSession.getAttribute("sessIdUsr"));
			System.out.println("httpSession.getAttribute(\"sessSeqUsr\"): " + httpSession.getAttribute("sessSeqUsr"));
			System.out.println("---------------------");

            returnMap.put("rt", "success");
            System.out.println("로그인 성공");
        } else {
            // 인증 실패 시 처리
            returnMap.put("rt", "fail");
            System.out.println("로그인 실패");
        }

        return returnMap;
    }
    
    //로그아웃 - 연결 페이지 헤더의 session 부분 초기화됨
    @ResponseBody
    @RequestMapping(value="/logoutUsr")
    public Map<String, Object> logoutUsr(HttpSession httpSession) throws Exception{
    	Map<String, Object> returnMap=new HashMap<String, Object>();
    	httpSession.invalidate();
    	returnMap.put("rt", "success");
    	returnMap.put("redirectUrl", "/recorded");
    	return returnMap;
    }

    @GetMapping(value="/MyPage/AccountSettings")
    public String myAccount(HttpSession session, Model model) {
        // 세션에서 로그인한 회원 정보 가져오기
        MemberDto authenticatedMember = (MemberDto) session.getAttribute("authenticatedMember");

        // 세션에 로그인한 정보가 없으면 로그인 페이지로 리다이렉트
        if (authenticatedMember == null) {
            return "redirect:/recorded/Login";
        }

        // 모델에 세션에 저장된 회원 정보 추가
        model.addAttribute("account", authenticatedMember);

        // 회원 정보 수정 페이지로 이동하는 뷰 이름 반환
        return "usr/infra/v1/account-details";
    }
    
    // 회원 정보 수정 처리
    @PostMapping("/UserUpdate")
    public String UserUpdate(@ModelAttribute MemberDto dto) throws Exception {
        service.updateUser(dto); // 서비스 계층으로 수정된 값 전달
        return "redirect:/MyPage/MyAccount"; // 수정된 정보가 표시된 상세 페이지로 이동
    }


    //회원가입 페이지
	@RequestMapping(value="/recorded/JoinIn")
	public String JoinIn(MemberDto dto, Model model) throws Exception {		
		return "usr/infra/v1/register";
		
	}
	
	 // 회원 가입 처리
    @PostMapping("/register")
    public String register(MemberDto dto) throws Exception {
        String originalPwd = dto.getPwd(); // 사용자가 입력한 비밀번호 저장

        // 사용자가 입력한 비밀번호를 암호화하여 DTO 객체에 설정
        dto.setPwd(encodeBcrypt(dto.getPwd(), 9));

        // 입력 값이 없으면 0으로 설정
        if (dto.getDormantNY() == null) {
            dto.setDormantNY(0);
        }
        if (dto.getQuitNY() == null) {
            dto.setQuitNY(0);
        }

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
        
        mailService.sendMailSimple(dto);
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				mailService.sendMailSimple(dto);
			}
		});
		
		thread.start();
        
		
        return "redirect:/recorded/Welcome";
    }


    //-----------------------------------------------------------eCommerce Controller E
    
}
