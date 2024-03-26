package com.recorded.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = "/Corders")
	public String Corders(CodeVo vo, Model model) throws Exception {
	    System.out.println("===========================================");
	    System.out.println(vo.toString());
	    System.out.println("vo.getShDateStart() : " + vo.getShDateStart());
	    System.out.println("vo.getShDateEnd() : " + vo.getShDateEnd());

	    model.addAttribute("list", service.selectList(vo)); // 첫 번째 데이터 추가, "listData"라는 이름 사용
	    model.addAttribute("vo", vo);
	    
	    int rowCount = service.getTotalCodeCount(vo);
	    model.addAttribute("rowCount", rowCount);

	    System.out.println("Row count: " + rowCount);

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
	

}
