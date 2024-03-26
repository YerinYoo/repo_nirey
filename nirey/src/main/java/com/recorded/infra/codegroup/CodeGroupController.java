package com.recorded.infra.codegroup;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recorded.common.constants.Constants;
import com.recorded.common.util.UtilDateTime;
import com.recorded.infra.code.CodeVo;



@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService service;
	// CodeGroupService codeGroupService;

	
	/*
	 * @RequestMapping(value = "/orders") public String orders(CodeGroupVo vo, Model
	 * model) throws Exception {
	 * 
	 * System.out.println("===========================================");
	 * System.out.println(vo.toString());
	 * System.out.println("vo.getShDateStart() : " + vo.getShDateStart());
	 * System.out.println("vo.getShDateEnd() : " + vo.getShDateEnd());
	 * 
	 * model.addAttribute("list", service.selectList(vo)); model.addAttribute("vo",
	 * vo);
	 * 
	 * return "adm/infra/v1/orders"; }
	 */
	
	@RequestMapping(value = "/orders")
	public String orders(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception {
		
		setSearch(vo);
		int rowcount = service.getTotalCodeGroupCount(vo);
		model.addAttribute("listCount", rowcount);
		
		System.out.println(rowcount);
		
		model.addAttribute("list", service.selectList(vo));
		
//		 model.addAttribute("vo", vo);
		
		return "adm/infra/v1/orders";
	}
	public void setSearch(CodeGroupVo vo) throws Exception {
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
		    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));		

		
	
		
//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		
	}

//	@RequestMapping(value="orders")
//	public String orders(Model model) throws Exception {
//		
//		model.addAttribute("list", service.selectList());
//		
//		return "adm/infra/v1/orders";
//	}

	@RequestMapping(value = "/codeGroupView")
	public String codeGroupView(CodeGroupDto dto, Model model) throws Exception {

//		System.out.println("dto.getSeq() :" + dto.getSeq());
//		System.out.println("dto.getName() : " + dto.getName());
//		System.out.println("dto.getMemo() : "+ dto.getMemo());
//		System.out.println("dto.getRegDateTime() : " + dto.getRegDatetime());
//		System.out.println("dto.getModDateTime() : " + dto.getModDatetime());

		model.addAttribute("item", service.selectOne(dto)); // item = html에서 쓰일 이름

		return "codeGroupView";

	}


	@RequestMapping(value = "/codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto) throws Exception {
		System.out.println(dto.getName());
		service.insert(dto);
		return "redirect:/orders";
	}

	@RequestMapping(value = "/codeGroupUpdt")
	public String codeGroupUpdt(CodeGroupDto dto) throws Exception {

		service.update(dto);
		System.out.println(dto.toString());
//		return "codeGroupXdmListAdd";
//		return 1;
		return "redirect:/orders"; // 리스트로 돌아가는 기능은 실무에서 거의 사용 X
	}

	@RequestMapping(value = "/codeGroupUpdtDel")
	public String codeGroupUpdtDel(CodeGroupDto dto) throws Exception {

		service.updtDel(dto);

		return "redirect:/orders";
	}

	@RequestMapping(value = "/codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto dto) throws Exception {

		service.delete(dto);

		return "redirect:/orders";
	}

	@RequestMapping(value = "/ordersView")
	public String ordersView(CodeGroupDto dto, Model model) throws Exception {

		model.addAttribute("item", service.selectOne(dto));

		return "adm/infra/v1/ordersView";
	}

	@RequestMapping(value = "/ordersForm")
	public String ordersForm(CodeGroupDto dto, Model model) throws Exception {

		model.addAttribute("item", service.selectOne(dto));

		return "adm/infra/v1/ordersForm";
	}

	@RequestMapping(value = "/ordersAdd")
	public String ordersAdd(CodeGroupDto dto) throws Exception {

		return "adm/infra/v1/ordersAdd";

	}

}