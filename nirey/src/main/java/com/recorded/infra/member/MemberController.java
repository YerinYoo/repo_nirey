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
import com.recorded.common.constants.Constants;
import com.recorded.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController extends BaseController{
	
	@Autowired
	 MemberService service;
	
	@RequestMapping(value = "/loginAdm")
	public String loginAdm(MemberDto dto) throws Exception {
		
		/* service.selectOne(dto); */

		return "adm/infra/v1/loginAdm"; 
	}


	@PostMapping("/loginAdmPg")
	@ResponseBody
	public Map<String, Object> loginAdmPg(@ModelAttribute MemberDto dto, HttpSession httpSession) throws Exception {
	    Map<String, Object> returnMap = new HashMap<>();

	    // 입력된 아이디와 비밀번호를 서비스 레이어로 전달하여 인증 수행
	    MemberDto authenticatedMember = service.authenticate(dto.getID(), dto.getPwd());
	    System.out.println(authenticatedMember.getID());

	    // 인증된 회원이 존재하고, 입력된 비밀번호가 암호화된 비밀번호와 일치하는지 확인
	    if (authenticatedMember != null && matchesBcrypt(dto.getPwd(), authenticatedMember.getPwd(), 10)) {
	        // 로그인 성공 시 세션에 회원 정보 저장
	        httpSession.setAttribute("authenticatedMember", authenticatedMember);
	        returnMap.put("rt", "success");
	    } else {
	        // 인증 실패 시 처리
	        returnMap.put("rt", "fail");
	    }

	    return returnMap;
	}


    //관리자 회원가입
	@RequestMapping(value="/signup")
	public String signup() throws Exception {
		
		return "adm/infra/v1/signup";
		
	}

	
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

	
	
	@RequestMapping(value="/MemberUelete")
	public String MemberUelete(MemberDto dto) throws Exception {
		
		service.uelete(dto);
		
		return "redirect:/Morders";
	}
	
	@RequestMapping(value="/MemberDelete")
	public String MemberDelete(MemberDto dto) throws Exception {
		
		service.delete(dto);
		
		return "redirect:/Morders";
	}
	
	@RequestMapping(value = "/Morders")
	public String Morders(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
		
		setSearch(vo);
		int rowcount = service.getTotalMemberCount(vo);
		model.addAttribute("listCount", rowcount);
		
		System.out.println(rowcount);
		
		model.addAttribute("list", service.selectList(vo));
		
//		 model.addAttribute("vo", vo);
		
		return "adm/infra/v1/Morders";
	}
	
	@RequestMapping(value = "/MordersView")
	public String MordersView(MemberDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto)); 
		
		return "adm/infra/v1/MordersView"; 
	}
	
	@RequestMapping(value = "/MordersForm")
	public String MordersForm(MemberDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto)); 
		
		return "adm/infra/v1/MordersForm"; 
	}
	
	@RequestMapping(value="/MordersAdd")
	public String MordersAdd() throws Exception {
		
		return "adm/infra/v1/MordersAdd";
		
	}
	
	public void setSearch(MemberVo vo) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/*이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다.*/
		/*해서 BaseVo.java 에서 기본값을 주어서 처리*/
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.add59TimeString(vo.getShDateEnd()));		
		
//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		
}

	
	
	
	

}
