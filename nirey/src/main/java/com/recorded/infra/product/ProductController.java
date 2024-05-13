package com.recorded.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.recorded.common.constants.Constants;
import com.recorded.common.util.UtilDateTime;
import com.recorded.infra.member.MemberDto;
import com.recorded.infra.member.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	@Autowired
	MemberService serviceM;

	@RequestMapping(value = "/ProductInsert")
	public String ProductInsert(ProductDto dto) throws Exception {

		System.out.println(dto.toString());

		System.out.println("-------------");
		System.out.println("dto.getUploadFiles().length: " + dto.getUploadFiles().length);
		System.out.println("-------------");
		System.out.println();
		MultipartFile[] uploadFiles = dto.getUploadFiles();
		
		 for (MultipartFile file : uploadFiles) {
			 
	         System.out.println("업로드된 파일 이름: " + file.getOriginalFilename());
	     }
		 
		//service.insert(dto);

		return "redirect:/ProductList";
		
	}

	@ResponseBody
	@RequestMapping(value = "/ReviewInsert")
	public String ReviewInsert(ProductDto dto) throws Exception {
		
		ProductDto productDto = new ProductDto();
		productDto.setDelNY(0);

		System.out.println(dto.toString());

		service.insertRev(dto);

		System.out.println("나 컨트롤러 불려왔다? 리뷰 데이터 넣는다?");
		return "redirect:/recorded/Shop/Product";
	}
	
	@ResponseBody
	@RequestMapping(value="/insertWishlist")
	public String insertWishlist(ProductDto dto, HttpSession httpSession) throws Exception {
	    // 세션에서 사용자의 시퀀스 값을 가져옴
	    String memberSeq = (String) httpSession.getAttribute("sessSeqUsr");

	    // 위시리스트에 추가할 때 사용자의 시퀀스 값 설정
	    dto.setMember_memberSeq(memberSeq);

	    // 나머지 필요한 로직 수행
	    dto.setDelNY(0); // 삭제 여부 설정
	    service.insertWishlist(dto); // 서비스 호출
	    
	    System.out.println("dto.getProduct_productSeq()" +dto.getProduct_productSeq());
	    System.out.println("위시리스트에 상품 추가됨: " + dto.toString());

	    return "redirect:/recorded/Shop/Product"; // 상품 페이지로 리다이렉트
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertOrders")
	public String insertOrders(ProductDto dto, HttpSession httpSession) throws Exception {

		
		service.insertOrders(dto);
		service.insertOrderedProd(dto);
		
		return "redirect:/recorded/OrderComplete";
	}



	@RequestMapping(value = "/ProductUpdate")
	public String ProductUpdate(ProductDto dto) throws Exception {

		System.out.println(dto.getProductName());

		service.update(dto);

		return "redirect:/ProductList";
	}

	@RequestMapping(value = "/ProductUelete")
	public String ProductUelete(ProductDto dto) throws Exception {
		String[] checkboxSeqArray = dto.getCheckboxSeqArray();
		for(String checkboxSeq : checkboxSeqArray) {
			dto.setProductSeq(checkboxSeq);
			service.uelete(dto);
		}
		

		return "redirect:/ProductList";
	}
	
	@RequestMapping(value="/deleteWishlist")
	public String ueleteW(ProductDto dto) throws Exception {
		
		service.ueleteW(dto);
		
		return "redirect:/MyPage/Cart";
	}

	@RequestMapping(value = "/ProductDelete")
	public String ProductDelete(ProductDto dto) throws Exception {

		service.delete(dto);

		return "redirect:/ProductList";
	}

	@RequestMapping(value = "/ProductList")
	public String Morders(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {
		
		setSearch(vo, null, null);
		int rowcount = service.getTotalProductCount(vo);
		model.addAttribute("listCount", rowcount);
		
		System.out.println(rowcount);
		
		model.addAttribute("list", service.selectList(vo));
		
//		 model.addAttribute("vo", vo);
		
		return "adm/infra/v1/Porders";
	}
	

	@RequestMapping(value = "/ProductView")
	public String PordersView(ProductDto dto, Model model) throws Exception {

		model.addAttribute("item", service.selectOne(dto));

		return "adm/infra/v1/PordersView";
	}

	@RequestMapping(value="/ProductEdit")
	public String ProductEdit(ProductDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "adm/infra/v1/PordersEdit";
	}

	@RequestMapping(value = "/AddProduct")
	public String PordersAdd() throws Exception {

		return "adm/infra/v1/PordersAdd";

	}

	public void setSearch(ProductVo vo, String string, String userSeq) throws Exception {

		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
				? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
				: UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(
				vo.getShDateEnd() == null ? UtilDateTime.nowString() : UtilDateTime.add59TimeString(vo.getShDateEnd()));
	}

	@RequestMapping(value = "/recorded")
	public String recorded(@ModelAttribute("vo") ProductVo vo, HttpSession session, Model model) throws Exception {
		// ProductVo 객체 생성
		ProductVo searchVo = new ProductVo();

		// 세션에서 사용자 아이디를 가져옵니다.
		String userSeq = (String) session.getAttribute("sessSeqUsr");

		// 검색 기능 관련 설정
		setSearch(searchVo, vo.getShValue(), userSeq);

		// 검색 조건에 맞는 상품 리스트 조회
		List<ProductDto> prodList = service.selectList(searchVo);
		model.addAttribute("prodList", prodList);

		return "usr/infra/v1/home";
	}

	/*
	 * @RequestMapping(value = "/recorded/Shop") public String
	 * recordedShop(@ModelAttribute("vo") ProductVo vo, ProductDto dto,
	 * 
	 * @RequestParam(name = "count", required = false, defaultValue = "20") Integer
	 * pageSize,
	 * 
	 * Model model) throws Exception {
	 * 
	 * // 검색 기능 관련 설정 setSearch(vo, vo.getShValue(), null); // 사용자 아이디를 null로 설정
	 * 
	 * // 페이징 기능 관련 설정 vo.setParamsPaging(service.getTotalProductCount(vo)); // 총 상품
	 * 수 설정 // 페이징 처리된 상품 리스트 조회 List<ProductDto> productListFiltered =
	 * service.selectPagedProductList(vo);
	 * 
	 * model.addAttribute("prodList", ); model.addAttribute("vo",vo); // 페이징을 위한 검색
	 * 조건을 모델에 추가
	 * 
	 * 
	 * // 전체 상품 리스트를 가져와서 모델에 추가 model.addAttribute("prodList", service.prodList());
	 * 
	 * // recordedShop 페이지로 이동 return "usr/infra/v1/shop"; }
	 */
	
	@RequestMapping(value = "/recorded/Shop")
	public String recordedShop(@ModelAttribute("vo") ProductVo vo, ProductDto dto,
	                           Model model) throws Exception {

		 // 검색 기능 관련 설정
	    setSearch(vo, vo.getShValue(), null); // 사용자 아이디를 null로 설정

	    
	    // 페이징 기능 관련 설정
	    vo.setParamsPaging(service.getTotalProductCount(vo)); // 총 상품 수 설정
	    // 페이징 처리된 상품 리스트 조회
	    List<ProductDto> productListFiltered = service.selectPagedProductList(vo);
	    
	    model.addAttribute("prodListFilt", productListFiltered);

	    // 전체 상품 리스트를 가져와서 모델에 추가
	    model.addAttribute("prodList", service.prodList());

	    // recordedShop 페이지로 이동
	    return "usr/infra/v1/shop";
	}
	
	@RequestMapping(value = "/recorded/Shop/New")
	public String filterngByNew(@ModelAttribute("vo") ProductVo vo, ProductDto dto,
	                           Model model) throws Exception {

	    // 검색 기능 관련 설정
	    setSearch(vo, vo.getShValue(), null); // 사용자 아이디를 null로 설정

	    
	    // 페이징 기능 관련 설정
	    vo.setParamsPaging(service.getTotalProductCount(vo)); // 총 상품 수 설정
	    // 페이징 처리된 상품 리스트 조회
	    List<ProductDto> productListFiltered = service.selectPagedProductList(vo);
	    
	    model.addAttribute("prodListFilt", productListFiltered);

	    // 신상품 리스트를 가져와서 모델에 추가
	    model.addAttribute("prodList", service.filteringByNew());

	    // recordedShop 페이지로 이동
	    return "usr/infra/v1/stockCDNew";
	}
	
	@RequestMapping(value = "/recorded/Shop/Best")
	public String filterngByBest(@ModelAttribute("vo") ProductVo vo, ProductDto dto,
	                           Model model) throws Exception {

	    // 검색 기능 관련 설정
	    setSearch(vo, vo.getShValue(), null); // 사용자 아이디를 null로 설정

	    
	    // 페이징 기능 관련 설정
	    vo.setParamsPaging(service.getTotalProductCount(vo)); // 총 상품 수 설정
	    // 페이징 처리된 상품 리스트 조회
	    List<ProductDto> productListFiltered = service.selectPagedProductList(vo);
	    
	    model.addAttribute("prodListFilt", productListFiltered);

	    // 신상품 리스트를 가져와서 모델에 추가
	    model.addAttribute("prodList", service.filteringByBest());

	    // recordedShop 페이지로 이동
	    return "usr/infra/v1/stockCDBest";
	}
	
	@RequestMapping(value = "/recorded/Shop/Restock")
	public String filterngByRestock(@ModelAttribute("vo") ProductVo vo, ProductDto dto,
	                           Model model) throws Exception {

	    // 검색 기능 관련 설정
	    setSearch(vo, vo.getShValue(), null); // 사용자 아이디를 null로 설정

	    
	    // 페이징 기능 관련 설정
	    vo.setParamsPaging(service.getTotalProductCount(vo)); // 총 상품 수 설정
	    // 페이징 처리된 상품 리스트 조회
	    List<ProductDto> productListFiltered = service.selectPagedProductList(vo);
	    
	    model.addAttribute("prodListFilt", productListFiltered);

	    // 신상품 리스트를 가져와서 모델에 추가
	    model.addAttribute("prodList", service.filteringByRestock());

	    // recordedShop 페이지로 이동
	    return "usr/infra/v1/stockCDRestock";
	}
	
	
	  @RequestMapping(value = "/recorded/Shop/Product") 
	  public String ProductView(ProductDto dto, Model model) throws Exception {
		  
		  model.addAttribute("product", service.selectProd(dto));
		  model.addAttribute("wishlist", service.wishlist());
		  model.addAttribute("prodColor", service.prodColor(dto));
		  model.addAttribute("prodSize", service.prodSize(dto));
		  model.addAttribute("prodReview", service.prodReview(dto));

	  return "usr/infra/v1/product"; 
	  }

	  
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchProducts(@RequestParam(name = "shValue", required = false) String shValue, Model model) {
		try {
			// 검색어를 가지고 있는 VO 객체 생성
			ProductVo vo = new ProductVo();

			if (shValue != null && !shValue.isEmpty()) {
				vo.setShValue(shValue);

				// 검색 메서드를 통해 검색 결과 조회
				List<ProductDto> searchResults = service.searchProducts(vo);

				// 페이지네이션 설정
				vo.setParamsPaging(searchResults.size());

				// 검색 결과가 있는지 확인하고 모델에 추가
				if (!searchResults.isEmpty()) {
					model.addAttribute("searchResults", searchResults);
					model.addAttribute("vo", vo); // 페이지네이션 정보를 모델에 추가
				} else {
					// 검색 결과가 없는 경우에도 전체 상품 목록을 가져와서 모델에 추가
					List<ProductDto> prodList = service.prodList();
					model.addAttribute("prodList", prodList);
					// 검색 결과가 없는 경우에도 모달을 표시하기 위한 속성 추가
					model.addAttribute("showModal", true);
					model.addAttribute("vo", vo); // 페이지네이션 정보를 모델에 추가
				}
			} else {
				// 검색어가 없는 경우에도 전체 상품 목록을 모델에 추가
				List<ProductDto> prodList = service.prodList();
				model.addAttribute("prodList", prodList);
				// 검색 결과가 없는 경우에도 모달을 표시하기 위한 속성 추가
				model.addAttribute("showModal", true);
				model.addAttribute("vo", vo); // 페이지네이션 정보를 모델에 추가
			}
		} catch (Exception e) {
			// 예외 처리
			e.printStackTrace();
			// 오류 페이지로 이동
			return "errorPage";
		}

		// 페이지로 이동
		return "usr/infra/v1/shop";
	}
	
	//위시리스트
	   @RequestMapping("/MyPage/Cart")
	    public String getWishlist(HttpSession session,ProductDto dto, Model model) throws Exception{
		   
		   // 세션에서 로그인한 회원 정보 가져오기
	        MemberDto authenticatedMember = (MemberDto) session.getAttribute("authenticatedMember");

	        // 세션에 로그인한 정보가 없으면 로그인 페이지로 리다이렉트
	        if (authenticatedMember == null) {
	            return "redirect:/recorded/Login";
	        }
	        // 위시리스트 정보 가져오기
	        List<ProductDto> wishlist = service.wishlist();

	        // 모델에 위시리스트 추가
	        model.addAttribute("wishlist", wishlist);
	        model.addAttribute("colorOption", service.colorOption(dto));
			model.addAttribute("sizeOption", service.sizeOption(dto));

	        // 위시리스트 페이지로 이동하는 뷰 이름 반환
	        return "usr/infra/v1/wishlist";
	    }
	  
}
// 사용자 페이지 관련 e