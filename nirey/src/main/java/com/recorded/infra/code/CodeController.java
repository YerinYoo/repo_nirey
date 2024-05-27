package com.recorded.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.recorded.common.constants.Constants;
import com.recorded.common.util.UtilDateTime;
import com.recorded.infra.codegroup.CodeGroupService;


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
		
		return "redirect:/CodeList";
	}
	
	@RequestMapping(value="/codeUpdate")
	public String codeUpdate(CodeDto dto) throws Exception {
		
		System.out.println(dto.getName());
		
		service.update(dto);
		
		return "redirect:/CodeList";
	}
	
	@RequestMapping(value="/codeUelete")
	public String codeUelete(CodeDto dto) throws Exception {
		
		service.uelete(dto);
		
		return "redirect:/CodeList";
	}
	
	@RequestMapping(value="/codeMultiUelete")
	public String codeMultiUelete(CodeDto dto) throws Exception {
		String[] checkboxSeqArray = dto.getCheckboxSeqArray();
		for(String checkboxSeq : checkboxSeqArray) {
			dto.setSeq(checkboxSeq);
			service.uelete(dto);
		}
			
	
		
		return "redirect:/CodeList";
	}
	
	@RequestMapping(value="/codeDelete")
	public String codeDelete(CodeDto dto) throws Exception {
		
		service.delete(dto);
		
		return "redirect:/CodeList";
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

	/*
	 * @RequestMapping(value = "/Corders") public String
	 * Corders(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
	 * 
	 * setSearch(vo); int rowcount = service.getTotalCodeCount(vo);
	 * model.addAttribute("listCount", rowcount);
	 * 
	 * System.out.println(rowcount);
	 * 
	 * model.addAttribute("list", service.selectList(vo));
	 * 
	 * // model.addAttribute("vo", vo);
	 * 
	 * return "adm/infra/v1/Corders"; }
	 */
	
	@RequestMapping(value = "/CodeList")
	public String Corders(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception{

		setSearch(vo);
		vo.setParamsPaging(service.getTotalCodeCount(vo));
		
		int rowcount = service.getTotalCodeCount(vo);
		model.addAttribute("listCount", rowcount);
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("lists", service.selectPagedCodeList(vo));
			List<CodeDto> list = service.selectList(vo);
			model.addAttribute("list", list);
		}

		return "adm/infra/v1/Corders"; 
  	}
	
	@RequestMapping(value = "/CodeView")
	public String CordersView(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto)); 
		
		return "adm/infra/v1/CordersView"; 
	}

	@RequestMapping(value="/AddCode")
	public String CordersAdd(CodeDto dto, Model model) throws Exception {
		//code add 페이지에서 codeGroup 셀렉트 박스로 값 받아오기
		model.addAttribute("listCodeGroup", codeGroupService.selectListWithoutPaging());
		
		return "adm/infra/v1/CordersAdd";
		
	}
	
	@RequestMapping(value="/EditCode")
	public String CordersEdit(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "adm/infra/v1/CordersEdit";
	}
	
	public void setSearch(CodeVo vo) throws Exception {
	
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.add59TimeString(vo.getShDateEnd()));		

	}
}
