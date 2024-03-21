package com.recorded.infra.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recorded.common.constants.Constants;
import com.recorded.common.util.UtilDateTime;
import com.recorded.infra.codegroup.CodeGroupVo;

@Controller
public class MemberController {
	
	@Autowired
	 MemberService service;
	
	@RequestMapping(value="/MemberInsert")
	public String MemberInsert(MemberDto dto) throws Exception {
		
		System.out.println(dto.toString());
		
		service.insert(dto);
		
		return "redirect:/Morders";
	}
	
	@RequestMapping(value="/MemberUpdate")
	public String MemberUpdate(MemberDto dto) throws Exception {
		
		System.out.println(dto.getName());
		
		service.update(dto);
		
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
	public String Morders(@ModelAttribute("vo") MemberVo vo, Model model ) throws Exception {
		setSearch(vo);

		System.out.println("===========================================");
		System.out.println(vo.toString());
		System.out.println("vo.getShDateStart() : " + vo.getShDateStart());
		System.out.println("vo.getShDateEnd() : " + vo.getShDateEnd());

		model.addAttribute("list", service.selectList(vo));
		model.addAttribute("vo", vo);

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
