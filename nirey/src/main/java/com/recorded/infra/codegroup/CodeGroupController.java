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
	
	@RequestMapping(value="account-details")
	public String accountDetails() throws Exception {
		return "usr/infra/v1/account-details";
	}
	
	@RequestMapping(value="address")
	public String address() throws Exception {
		return "usr/infra/v1/address";
	}
	
	@RequestMapping(value="cart")
	public String cart() throws Exception {
		return "usr/infra/v1/cart";
	}
	
	@RequestMapping(value="checkoutShop")
	public String checkoutShop() throws Exception {
		return "usr/infra/v1/checkout";
	}
	
	@RequestMapping(value="dashboard")
	public String dashboard() throws Exception {
		return "usr/infra/v1/dashboard";
	}
	
	@RequestMapping(value="recorded")
	public String demo3() throws Exception {
		return "usr/infra/v1/demo3";
	}
	
	@RequestMapping(value="product")
	public String demo3Product() throws Exception {
		return "usr/infra/v1/demo3-product";
	}
	
	@RequestMapping(value="shop")
	public String demo3Shop() throws Exception {
		return "usr/infra/v1/demo3-shop";
	}
	
	@RequestMapping(value="forgot-password")
	public String forgotPassword() throws Exception {
		return "usr/infra/v1/forgot-password";
	}
	
	@RequestMapping(value="login")
	public String login() throws Exception {
		return "usr/infra/v1/login";
	}
	
	@RequestMapping(value="order")
	public String orded() throws Exception {
		return "usr/infra/v1/order";
	}
	
	@RequestMapping(value="order-complete")
	public String orderComplete() throws Exception {
		return "usr/infra/v1/order-complete";
	}
	
	@RequestMapping(value="order-details")
	public String orderDetails() throws Exception {
		return "usr/infra/v1/order-details";
	}
	
	@RequestMapping(value="register")
	public String register() throws Exception {
		return "usr/infra/v1/register";
	}
	
	@RequestMapping(value="welcome")
	public String welcome() throws Exception {
		return "usr/infra/v1/welcome";
	}
	
	@RequestMapping(value="wishlist")
	public String wishlist() throws Exception {
		return "usr/infra/v1/wishlist";
	}
	
	//adm page
	
	@RequestMapping(value="account-settings")
	public String accountSettings() throws Exception {
		return "adm/infra/v1/account-settings";
	}
	
	@RequestMapping(value="calendar")
	public String calendar() throws Exception {
		return "adm/infra/v1/calendar";
	}
	
	@RequestMapping(value="checkout")
	public String checkout() throws Exception {
		return "adm/infra/v1/checkout";
	}
	
	@RequestMapping(value="customers")
	public String customers(Model model) throws Exception {
		
		model.addAttribute("list", service.selectList());
		return "adm/infra/v1/customers";
	}
	
	@RequestMapping(value="forgot_password")
	public String forgotPwd() throws Exception {
		return "adm/infra/v1/forgot_password";
	}
	
	@RequestMapping(value="/")
	public String index() throws Exception {
		return "adm/infra/v1/index";
	}
	@RequestMapping(value="loginAdm")
	public String loginAdm() throws Exception {
		return "adm/infra/v1/loginAdm";
	}
	
	@RequestMapping(value="orders")
	public String orders(Model model) throws Exception {
		
		model.addAttribute("list", service.selectList());
		return "adm/infra/v1/orders";
	}
	
	@RequestMapping(value = "/ordersView")
	public String ordersView(CodeGroupDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto)); 
		
		return "adm/infra/v1/ordersView"; 
	}
	
	@RequestMapping(value="products")
	public String products() throws Exception {
		return "adm/infra/v1/products";
	}
	
	@RequestMapping(value="reviews")
	public String reviews() throws Exception {
		return "adm/infra/v1/reviews";
	}
	
	@RequestMapping(value="signup")
	public String signup() throws Exception {
		return "adm/infra/v1/signup";
	}
	
	@RequestMapping(value="tables")
	public String tables() throws Exception {
		return "adm/infra/v1/tables";
	}
	
	@RequestMapping(value="view-cart")
	public String viewCart() throws Exception {
		return "adm/infra/v1/view-cart";
	}
	
	@RequestMapping (value="ordersForm")
	public String ordersForm(CodeGroupDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "adm/infra/v1/ordersForm";
	}
	
	
}