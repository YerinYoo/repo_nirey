package com.recorded.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recorded.common.constants.Constants;
import com.recorded.common.util.UtilDateTime;

@Controller
public class CodeGroupController {

	@Autowired
	private CodeGroupService service;

	@RequestMapping(value = "/orders")
	public String orders(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception {
	    // 페이징 관련 정보 설정
	    vo.setParamsPaging(service.getTotalCodeGroupCount(vo));
	    
	    // 페이징 정보를 기반으로 리스트 조회
	    if (vo.getTotalRows() > 0) {
	        List<CodeGroupDto> list = service.selectList(vo);
	        model.addAttribute("list", list);
	    }
	    
	    return "adm/infra/v1/orders"; // 뷰 이름 반환
	}


	public void setSearch(CodeGroupVo vo) throws Exception {
		vo.setShDateStart(vo.getShDateStart() == null ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL) : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null ? UtilDateTime.nowString() : UtilDateTime.addNowTimeString(vo.getShDateEnd()));
	}

	@RequestMapping(value = "/codeGroupView")
	public String codeGroupView(CodeGroupDto dto, Model model) throws Exception {
		model.addAttribute("item", service.selectOne(dto));
		return "codeGroupView";
	}

	@RequestMapping(value = "/codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto) throws Exception {
		service.insert(dto);
		return "redirect:/orders";
	}

	@RequestMapping(value = "/codeGroupUpdt")
	public String codeGroupUpdt(CodeGroupDto dto) throws Exception {
		service.update(dto);
		return "redirect:/orders";
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
