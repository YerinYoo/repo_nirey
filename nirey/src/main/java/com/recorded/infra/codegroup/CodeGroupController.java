package com.recorded.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recorded.common.constants.Constants;
import com.recorded.common.util.UtilDateTime;
import com.recorded.infra.member.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class CodeGroupController {

	@Autowired
	private CodeGroupService service; //CodeGroupService를 service라는 이름으로 종속 받을 것
    
	//어드민 페이지 관련 컨트롤러 
	
    @RequestMapping(value = "/CodeGroupList")
    //코드 그룹 Vo와 모델 값을 가지고 orders라는 페이지 호출
    public String orders(@ModelAttribute("vo") CodeGroupVo vo, Model model, HttpSession session) throws Exception {
    	
    	// 세션에서 로그인한 회원 정보 가져오기
        MemberDto authenticatedMember = (MemberDto) session.getAttribute("authenticatedMember");

        // 세션에 로그인한 정보가 없으면 로그인 페이지로 리다이렉트
        if (authenticatedMember == null) {
            return "redirect:/loginAdm";
        }
        
		int rowcount = service.getTotalCodeGroupCount(vo);
		model.addAttribute("listCount", rowcount);
		
        // 페이징 관련 정보 설정
        vo.setParamsPaging(service.getTotalCodeGroupCount(vo)); //service에 getTotal 어쩌구로 정의된 객체 사용 >>CodeGroupVo를 이용해 코드 그룹의 총 개수 구하는 메서드 호출
        
        // 페이징 정보를 기반으로 리스트 조회
        if (vo.getTotalRows() > 0) { //VO내에 정의된 getTotalRows의 값이 0보다 크면
            List<CodeGroupDto> list = service.selectList(vo); //selectList : 전체 코드그룹 값을 반환하는 매퍼, 페이징 정보를 이용해 코드 그룹의 리스트를 가져오는 메서드 호출
            model.addAttribute("list", list); //list라는 이름으로 모델로 저장
        }
        
        return "adm/infra/v1/orders"; 
    }

    //검색 메서드 컨트롤러 - ShDateStart, shDateEnd Null 체크 및 null이 아닐 경우 시간 설정
	public void setSearch(CodeGroupVo vo) throws Exception { //VO 내용 참조
		vo.setShDateStart(vo.getShDateStart() == null ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL) : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null ? UtilDateTime.nowString() : UtilDateTime.addNowTimeString(vo.getShDateEnd()));
	}
	
	//AJAX로 페이징
	@RequestMapping(value = "/CodeGroupAJAXList")
	public String codeGroupXdmAjaxList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
		
		setSearch(vo);
		
		return "adm/infra/v1/CodeGroupList";
	}
	
	
	@RequestMapping(value = "/CodeGroupAJAXLita")
	public String codeGroupXdmAjaxLita(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
		
		setSearch(vo);
		vo.setParamsPaging(service.getTotalCodeGroupCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		return "adm/infra/v1/CodegroupLita";
	}
	
//
//	@RequestMapping(value = "/codeGroupView")
//	public String codeGroupView(CodeGroupDto dto, Model model) throws Exception {
//		//selectOne에 해당하는 DTO 내용을 모델에 추가하고, item이라는 이름으로 해당 내용 호출 
//		model.addAttribute("item", service.selectOne(dto)); //selectOne : 전체 값이 아닌 데이터베이스 상의 값과 조회하려는 값이 일치 할 때 해당하는 데이터만 호출하는 매퍼 참조.
//		return "codeGroupView";
//	}
	
	@RequestMapping(value="/CodeGroupEdit")
	public String codeGroupEdit(CodeGroupDto dto, Model model, HttpSession session) throws Exception {
		
		// 세션에서 로그인한 회원 정보 가져오기
        MemberDto authenticatedMember = (MemberDto) session.getAttribute("authenticatedMember");

        // 세션에 로그인한 정보가 없으면 로그인 페이지로 리다이렉트
        if (authenticatedMember == null) {
            return "redirect:/loginAdm";
        }
        
		model.addAttribute("item", service.selectOne(dto));
		
		return "adm/infra/v1/OrdersEdit";
	}

	@RequestMapping(value="/codeGroupInsert")
	//코드그룹 Dto 내용 참조함
	public String codeGroupInsert(CodeGroupDto dto) throws Exception {
		//Dto 파일에 정의 된 toString 내용 출력
		System.out.println(dto.toString());
		//서비스 파일에 insert라는 이름으로 정의된 함수 호출
		service.insert(dto);
		//함수 내용 실행한 후 컨트롤러 주소로 URL 요청
		return "redirect:/CodeGroupList";
	}

	@RequestMapping(value = "/codeGroupUpdt")
	public String codeGroupUpdt(CodeGroupDto dto) throws Exception {
		//서비스 파일에 update라는 이름으로 정의된 함수 호출 (Dto 내용 싣고옴)
		service.update(dto);
		//함수 내용 실행한 후 컨트롤러 주소로 URL 요청
		return "redirect:/CodeGroupList";
	}

	@RequestMapping (value="/codeGroupUpdtDel")
	public String codeGroupUpdtDel(CodeGroupDto dto) throws Exception {
		service.updtDel(dto);
		return "redirect:/CodeGroupList";
	}
	
	@RequestMapping(value = "/codeGroupMultiUpdtDel")
	public String codeGroupMultiUpdtDel(CodeGroupDto dto) throws Exception {
		String[] checkboxSeqArray = dto.getCheckboxSeqArray();
		for(String checkboxSeq : checkboxSeqArray) {
			dto.setSeq(checkboxSeq);
			//서비스 파일에 updtDel이라는 이름으로 정의된 함수 호출
			service.updtDel(dto);
		}
		//함수 내용 실행한 후 컨트롤러 주소로 URL 요청
		return "redirect:/CodeGroupList";
	}

	@RequestMapping(value = "/codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto dto) throws Exception {
		//서비스 파일에  delete라는 이름으로 정의된 함수 호출
		service.delete(dto);
		return "redirect:/CodeGroupList";
	}

	@RequestMapping(value = "/CodeGroupView")
	//코드 그룹 Dto, 모델 내용 받아옴
	public String ordersView(CodeGroupDto dto, Model model, HttpSession session) throws Exception {
		
		// 세션에서 로그인한 회원 정보 가져오기
        MemberDto authenticatedMember = (MemberDto) session.getAttribute("authenticatedMember");

        // 세션에 로그인한 정보가 없으면 로그인 페이지로 리다이렉트
        if (authenticatedMember == null) {
            return "redirect:/loginAdm";
        }
        
		//해당하는 Dto 내용 모델에 추가하고, item이름으로 호출할 수 있도록
		model.addAttribute("item", service.selectOne(dto));
		//반환하는 페이지 주소
		return "adm/infra/v1/ordersView";
	}

	@RequestMapping(value = "/ordersForm")
	public String ordersForm(CodeGroupDto dto, Model model, HttpSession session) throws Exception {
		
		// 세션에서 로그인한 회원 정보 가져오기
        MemberDto authenticatedMember = (MemberDto) session.getAttribute("authenticatedMember");

        // 세션에 로그인한 정보가 없으면 로그인 페이지로 리다이렉트
        if (authenticatedMember == null) {
            return "redirect:/loginAdm";
        }
        
		model.addAttribute("item", service.selectOne(dto));
		return "adm/infra/v1/ordersForm";
	}
	
	//코드그룹 데이터 추가 페이지 호출
	@RequestMapping(value = "/AddCodeGroup")
	public String ordersAdd(CodeGroupDto dto, HttpSession session) throws Exception {
		
		// 세션에서 로그인한 회원 정보 가져오기
        MemberDto authenticatedMember = (MemberDto) session.getAttribute("authenticatedMember");

        // 세션에 로그인한 정보가 없으면 로그인 페이지로 리다이렉트
        if (authenticatedMember == null) {
            return "redirect:/loginAdm";
        }
        
		//Dto를 이용해서 데이터 추가할 것 - Dto 호출
		return "adm/infra/v1/ordersAdd";
	}

}
