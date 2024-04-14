package com.recorded.infra.mix;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recorded.infra.member.MemberDto;
import com.recorded.infra.product.ProductDto;
import com.recorded.infra.product.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MixController {

	@Autowired
	MixService service;
	@Autowired
	ProductService serviceP;
    
    //사용자 화면 > My Page > Orders 컨트롤러
    @RequestMapping(value="/MyPage/Orders")
    public String MyOrders(Model model) throws Exception {
    	model.addAttribute("orderList", service.orderList());
    	return "usr/infra/v1/order";
    }
    
    //orders > Orders Detail 컨트롤러
    @RequestMapping(value="/MyPage/OrderDetails")
    public String MyOrdersDetail(Model model) throws Exception {
    	model.addAttribute("orderList", service.orderList());
    	return "usr/infra/v1/order-details";
    }
    
	  @RequestMapping(value="/MyPage/CheckOut")
	  public String checkOut(ProductDto dto, Model model, HttpSession session) throws Exception {
		  
		  List<ProductDto> wishlist = serviceP.wishlist();
		  
	        // 세션에서 로그인한 회원 정보 가져오기
	        MemberDto authenticatedMember = (MemberDto) session.getAttribute("authenticatedMember");

	        // 세션에 로그인한 정보가 없으면 로그인 페이지로 리다이렉트
	        if (authenticatedMember == null) {
	            return "redirect:/recorded/Login";
	        }

	        // 모델에 세션에 저장된 회원 정보 추가
	       model.addAttribute("account", authenticatedMember);
	        
		  model.addAttribute("checkOut", service.checkOut());
		  model.addAttribute("wishlist",serviceP.wishlist());
		  
		  
		  return "usr/infra/v1/checkout";
	  }
	 
	   @RequestMapping(value="/recorded/OrderComplete")
	   public String orderComplate(Model model)throws Exception {
		   
		   model.addAttribute("checkOut", service.checkOut());
		   
		   return "usr/infra/v1/order-complete";
	   }
    
    
}
