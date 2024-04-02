package com.recorded.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        
        return "adm/infra/v1/orders"; // 수정된 부분: 뷰 이름 반환
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

	// 코드 그룹 추가를 처리하는 메서드 수정
	@RequestMapping(value = "/codeGroupInsert")
	public String codeGroupInsert(@RequestParam(name = "name", required = false) String name) throws Exception {
	    // name 파라미터를 사용하여 원하는 작업을 수행
	    // 예: CodeGroupDto 객체를 생성하여 name 값을 설정하고 서비스에 전달
	    CodeGroupDto dto = new CodeGroupDto();
	    dto.setName(name);
	    dto.setDelNY(0); // delNY 필드에 대한 값을 설정
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
