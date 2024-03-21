package com.recorded.infra.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	 CodeService service;

	@RequestMapping(value = "/CodeXdmList")
	public String codeXdmList(Model model) throws Exception {       
		model.addAttribute("list", service.selectList()); 
		System.out.println(model.toString());

		return "CodeXdmList"; 
	}
	
	@RequestMapping(value = "/codeView")
	public String codeView(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		
		
		return "codeView"; 
		
	}
	
	@RequestMapping (value="/CodeForm")
	public String codeGroupForm(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "CodeForm";
	}
	
	@RequestMapping(value="/codeAdd")
	public String codeAdd() throws Exception {
		
		return "codeAdd";
		
	}
	
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

		model.addAttribute("list", service.selectList(vo));
		model.addAttribute("vo", vo);

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
	public String CordersAdd() throws Exception {
		
		return "adm/infra/v1/CordersAdd";
		
	}
	
	
	
	

}
