package com.recorded.infra.mix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recorded.infra.product.ProductDto;

@Controller
public class MixController {

	@Autowired
	MixService service;
	
    
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
    
    //사용자 화면 > My Page > Address 컨트롤러
    @RequestMapping(value="MyPage/Address")
    public String MyAddress(Model model) throws Exception{
    	model.addAttribute("memberAddr", service.memberAddr());
    	return "usr/infra/v1/address";
    }
    
	  @RequestMapping(value="/MyPage/CheckOut")
	  public String checkOut(ProductDto dto, Model model) throws Exception {
		  
		  model.addAttribute("memberAddr", service.memberAddr());
		  model.addAttribute("checkOut", service.checkOut());
		  
		  return "usr/infra/v1/checkout";
	  }
	 
	   @RequestMapping(value="/recorded/OrderComplete")
	   public String orderComplate(Model model)throws Exception {
		   
		   model.addAttribute("checkOut", service.checkOut());
		   
		   return "usr/infra/v1/order-complete";
	   }
    
    
}
