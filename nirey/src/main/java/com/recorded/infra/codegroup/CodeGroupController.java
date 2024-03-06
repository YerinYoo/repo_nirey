package com.recorded.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CodeGroupController {
	
	@Autowired
	 CodeGroupService service;
	//CodeGroupService codeGroupService;

	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(Model model) throws Exception {       
		
		//List<CodeGroupDto> codeGroupDtos =service.selectList();
		
		//for (CodeGroupDto a : codeGroupDtos) {
			//System.out.println(a.getName());
		//}
		
		model.addAttribute("list", service.selectList()); //리턴 데이터 값 = list, 받아오자마자 바로 넘겨버림
																										//model = html에서 넘기려는 데이터가 model이라는 이름으로 존재한다는 뜻
		
		//model.addAttribute("list", codeGroupDtos); //의미 : list = codeGroupDtos
		//model 객체의 addAttribute 함수가 작업을 처리함
		
		return "codeGroupXdmList"; //
	}
	
	@RequestMapping(value = "/codeGroupView")
	public String codeGroupView(CodeGroupDto dto, Model model) throws Exception {

//		System.out.println("dto.getSeq() :" + dto.getSeq());
//		System.out.println("dto.getName() : " + dto.getName());
//		System.out.println("dto.getMemo() : "+ dto.getMemo());
//		System.out.println("dto.getRegDateTime() : " + dto.getRegDatetime());
//		System.out.println("dto.getModDateTime() : " + dto.getModDatetime());
		
		model.addAttribute("item", service.selectOne(dto)); //item = html에서 쓰일 이름
		
		return "codeGroupView"; 
		
	}
	
//	@RequestMapping(value="/codeGroupForm")
//	public String codeGroupForm(CodeGroupDto dto) throws Exception {
//		
//		System.out.println("dto.getSeq() : " + dto.getSeq());
//		
//		return "codeGroupForm";
//		
//	}
	
	//html에 데이터를 표시할 수 있도록
	@RequestMapping (value="/codeGroupForm")
	public String codeGroupForm(CodeGroupDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "codeGroupForm";
	}
	
	
	@RequestMapping(value="/codeGroupAdd")
	public String codeGroupAdd() throws Exception {
		
		return "codeGroupAdd";
		
	}
	
	@RequestMapping(value="/codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto) throws Exception {
		System.out.println(dto.getName());
		service.insert(dto);
		return "redirect:/codeGroupXdmList";
	}
	
	@RequestMapping(value="/codeGroupUpdt")
public String codeGroupUpdt(CodeGroupDto dto) throws Exception{
		
		service.update(dto);
		System.out.println(dto.toString());
//		return "codeGroupXdmListAdd";
//		return 1;
		return "redirect:/codeGroupXdmList"; //리스트로 돌아가는 기능은 실무에서 거의 사용 X
	}
	
	@RequestMapping(value="/codeGroupUpdtDel")
	public String codeGroupUpdtDel(CodeGroupDto dto) throws Exception {
		
		service.updtDel(dto);
		
		return "redirect:/codeGroupXdmList";
	}
	
	@RequestMapping(value="/codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto dto) throws Exception {
		
		service.delete(dto);
		
		return "redirect:/codeGroupXdmList";
	}
	

}
