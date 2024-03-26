package com.recorded.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recorded.common.constants.Constants;
import com.recorded.common.util.UtilDateTime;
import com.recorded.infra.codegroup.CodeGroupService;
import com.recorded.infra.product.ProductVo;

@Controller
public class CodeController {
	
	@Autowired
	 CodeService service;
	
	@Autowired
	CodeGroupService codeGroupService;

	@RequestMapping(value="/codeInsert")
	public String codeInsert(CodeDto dto) throws Exception {
		
		System.out.println(dto.toString());
		
		service.insert(dto);
		
		return "redirect:/Corders";
	}
	
	@RequestMapping(value="/codeUpdate")
	public String codeUpdate(CodeDto dto) throws Exception {
		
		System.out.println(dto.getName());
		
		service.update(dto);
		
		return "redirect:/Corders";
	}
	
	
	@RequestMapping(value="/codeUelete")
	public String codeUelete(CodeDto dto) throws Exception {
		
		service.uelete(dto);
		
		return "redirect:/Corders";
	}
	
	@RequestMapping(value="/codeDelete")
	public String codeDelete(CodeDto dto) throws Exception {
		
		service.delete(dto);
		
		return "redirect:/Corders";
	}
	
	/*
	 * @RequestMapping(value = "/Corders") public String Corders(CodeVo vo, Model
	 * model) throws Exception {
	 * System.out.println("===========================================");
	 * System.out.println(vo.toString());
	 * System.out.println("vo.getShDateStart() : " + vo.getShDateStart());
	 * System.out.println("vo.getShDateEnd() : " + vo.getShDateEnd());
	 * 
	 * model.addAttribute("list", service.selectList(vo)); // 첫 번째 데이터 추가,
	 * "listData"라는 이름 사용 model.addAttribute("vo", vo);
	 * 
	 * int rowCount = service.getTotalCodeCount(vo); model.addAttribute("rowCount",
	 * rowCount);
	 * 
	 * System.out.println("Row count: " + rowCount);
	 * 
	 * return "adm/infra/v1/Corders"; }
	 */

	@RequestMapping(value = "/Corders")
	public String Corders(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		setSearch(vo);
		int rowcount = service.getTotalCodeCount(vo);
		model.addAttribute("listCount", rowcount);
		
		System.out.println(rowcount);
		
		model.addAttribute("list", service.selectList(vo));
		
//		 model.addAttribute("vo", vo);
		
		return "adm/infra/v1/Corders";
	}
	
	@RequestMapping(value = "/CordersView")
	public String CordersView(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto)); 
		
		return "adm/infra/v1/CordersView"; 
	}
	
	@RequestMapping(value = "/CordersForm")
	public String CordersForm(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto)); 
		
		return "adm/infra/v1/CordersForm"; 
	}
	
	@RequestMapping(value="/CordersAdd")
	public String CordersAdd(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("listCodeGroup", codeGroupService.selectListWithoutPaging());
		
		return "adm/infra/v1/CordersAdd";
		
	}
	
	public void setSearch(CodeVo vo) throws Exception {
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
