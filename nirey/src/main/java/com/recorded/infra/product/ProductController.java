package com.recorded.infra.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.recorded.common.constants.Constants;
import com.recorded.common.util.UtilDateTime;
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

		service.insert(dto);

		return "redirect:/Porders";
	}

	@RequestMapping(value = "/ProductUpdate")
	public String ProductUpdate(ProductDto dto) throws Exception {

		System.out.println(dto.getProductName());

		service.update(dto);

		return "redirect:/Porders";
	}

	@RequestMapping(value = "/ProductUelete")
	public String ProductUelete(ProductDto dto) throws Exception {

		service.uelete(dto);

		return "redirect:/Porders";
	}

	@RequestMapping(value = "/ProductDelete")
	public String ProductDelete(ProductDto dto) throws Exception {

		service.delete(dto);

		return "redirect:/Porders";
	}

	@RequestMapping(value = "/Porders")
	public String Morders(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {

		setSearch(vo);
		int rowcount = service.getTotalProductCount(vo);
		model.addAttribute("listCount", rowcount);

		System.out.println(rowcount);

		model.addAttribute("list", service.selectList(vo));

//		 model.addAttribute("vo", vo);

		return "adm/infra/v1/Porders";
	}

	@RequestMapping(value = "/PordersView")
	public String PordersView(ProductDto dto, Model model) throws Exception {

		model.addAttribute("item", service.selectOne(dto));

		return "adm/infra/v1/PordersView";
	}

	@RequestMapping(value = "/PordersForm")
	public String PordersForm(ProductDto dto, Model model) throws Exception {

		model.addAttribute("item", service.selectOne(dto));

		return "adm/infra/v1/PordersForm";
	}

	@RequestMapping(value = "/PordersAdd")
	public String PordersAdd() throws Exception {

		return "adm/infra/v1/PordersAdd";

	}

	public void setSearch(ProductVo vo, String string, String userSeq) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/* 이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다. */
		/* 해서 BaseVo.java 에서 기본값을 주어서 처리 */
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());

		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
				? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
				: UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(
				vo.getShDateEnd() == null ? UtilDateTime.nowString() : UtilDateTime.add59TimeString(vo.getShDateEnd()));
	}

//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));

	// 사용자 페이지 관련 s

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
	 * @RequestMapping(value = "/recordedShop") public String
	 * recordedShop(@ModelAttribute("vo") ProductVo vo, Model model) throws
	 * Exception { // ProductVo 객체 생성 ProductVo searchVo = new ProductVo();
	 * 
	 * // 검색 기능 관련 설정 setSearch(searchVo, vo.getShValue(), null); // 사용자 아이디를 null로
	 * 설정
	 * 
	 * // 검색 값이 없을 경우 모든 상품 조회 List<ProductDto> productListFiltered; if
	 * (vo.getShValue() == null || vo.getShValue().isEmpty()) { productListFiltered
	 * = service.prodList(); } else { // 검색 조건에 맞는 상품 리스트 조회 productListFiltered =
	 * service.selectList(searchVo); }
	 * 
	 * model.addAttribute("prodList", productListFiltered);
	 * 
	 * // recordedShop 페이지로 이동 return "usr/infra/v1/shop"; }
	 * 
	 * 
	 * 
	 * @RequestMapping(value = "/recordedShop") public String
	 * recordedShop(@ModelAttribute("vo") ProductVo vo, Model model) throws
	 * Exception { // ProductVo 객체 생성 ProductVo searchVo = new ProductVo();
	 * 
	 * // 검색 기능 관련 설정 setSearch(searchVo, vo.getShValue(), null); // 사용자 아이디를 null로
	 * 설정
	 * 
	 * // 페이징 기능 관련 설정
	 * searchVo.setParamsPaging(service.getTotalProductCount(searchVo)); // 총 상품 수
	 * 설정
	 * 
	 * // 페이징 처리된 상품 리스트 조회 List<ProductDto> productListFiltered =
	 * service.selectPagedProductList(searchVo);
	 * 
	 * model.addAttribute("prodList", productListFiltered); model.addAttribute("vo",
	 * searchVo); // 페이징을 위한 검색 조건을 모델에 추가
	 * 
	 * // recordedShop 페이지로 이동 return "usr/infra/v1/shop"; }
	 */
	

	@RequestMapping(value = "/recorded/Shop")
	public String recordedShop(@ModelAttribute("vo") ProductVo vo, ProductDto dto,
	        @RequestParam(name = "count", required = false, defaultValue = "20") Integer pageSize, 
	        @RequestParam(name = "category1", required = false) Integer category1,
	        @RequestParam(name = "category2", required = false) Integer category2,
	        @RequestParam(name = "prodStockCD", required = false) Integer prodStockCD,
	        Model model) throws Exception {

	    // 검색 기능 관련 설정
	    setSearch(vo, vo.getShValue(), null); // 사용자 아이디를 null로 설정
	    
		 // 페이징 기능 관련 설정
		 vo.setParamsPaging(service.getTotalProductCount(vo)); // 총 상품 수 설정
		  
		  // 페이징 처리된 상품 리스트 조회 List<ProductDto> productListFiltered =
		  service.selectPagedProductList(vo);
			/*
			 * model.addAttribute("prodList", ); model.addAttribute("vo",vo); // 페이징을 위한 검색
			 * 조건을 모델에 추가
			 */

	    // 카테고리 값이 요청 파라미터로 전달되었을 경우 DTO에 설정
	    if (category1 != null) {
	        dto.setCategory1CD(category1);
	    }
	    if (category2 != null) {
	        dto.setCategory2CD(category2);
	    }
	    if (prodStockCD != null) {
	        dto.setProdStockCD(prodStockCD);
	    }

	    // 검색 기능 관련 설정
	    ProductDto searchDto = new ProductDto();
	    searchDto.setCategory1CD(dto.getCategory1CD()); // 카테고리1 설정
	    searchDto.setCategory2CD(dto.getCategory2CD()); // 카테고리2 설정
	    searchDto.setProdStockCD(dto.getProdStockCD()); // 재고 상태 설정

	    // 카테고리가 전달되면 검색 조건에 추가
	    if (dto.getCategory1CD() != null) {
	        searchDto.setCategory1CD(dto.getCategory1CD());
	    }
	    if (dto.getCategory2CD() != null) {
	        searchDto.setCategory2CD(dto.getCategory2CD());
	    }
	    if (dto.getProdStockCD() != null) {
	        searchDto.setProdStockCD(dto.getProdStockCD());
	    }

	    // 전체 상품 리스트를 가져와서 모델에 추가
	    model.addAttribute("prodList", service.prodList());
	    
	    // recordedShop 페이지로 이동
	    return "usr/infra/v1/shop";
	}





	/*
	 * // 검색 기능 컨트롤러
	 * 
	 * @RequestMapping(value = "/search", method = RequestMethod.GET) public String
	 * searchProducts(@RequestParam(name = "shValue", required = false) String
	 * shValue, Model model) { try { // 검색어를 가지고 있는 VO 객체 생성 ProductVo vo = new
	 * ProductVo();
	 * 
	 * if (shValue != null && !shValue.isEmpty()) { vo.setShValue(shValue);
	 * 
	 * // 검색 메서드를 통해 검색 결과 조회 List<ProductDto> searchResults =
	 * service.searchProducts(vo);
	 * 
	 * // 검색 결과가 있는지 확인하고 모델에 추가 if (!searchResults.isEmpty()) {
	 * model.addAttribute("searchResults", searchResults); } else { // 검색 결과가 없는
	 * 경우에는 전체 상품 목록을 가져와서 모델에 추가 List<ProductDto> prodList = service.prodList();
	 * model.addAttribute("prodList", prodList); // 검색 결과가 없는 경우에도 모달을 표시하기 위한 속성 추가
	 * model.addAttribute("showModal", true); } } else { // 검색어가 없는 경우에는 전체 상품 목록을
	 * 가져와서 모델에 추가 List<ProductDto> prodList = service.prodList();
	 * model.addAttribute("prodList", prodList); // 검색 결과가 없는 경우에도 모달을 표시하기 위한 속성 추가
	 * model.addAttribute("showModal", true); }
	 * 
	 * // 검색 결과 페이지로 이동 return "usr/infra/v1/shop"; } catch (Exception e) { // 에러 처리
	 * return "errorPage"; } }
	 */
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


	//카테고리, stockCD에 따른 제품 호출
	@RequestMapping("/filterProducts")
	public ResponseEntity<List<ProductDto>> filterProducts(@RequestParam(required = false, name = "category1CD") Integer category1CD,
	                                                       @RequestParam(required = false, name = "category2CD") Integer category2CD,
	                                                       @RequestParam(required = false, name = "prodStockCD") Integer prodStockCD, Model model) {
	    // 요청 파라미터를 DTO에 설정
	    ProductDto dto = new ProductDto();
	    dto.setCategory1CD(category1CD);
	    dto.setCategory2CD(category2CD);
	    dto.setProdStockCD(prodStockCD);

	    // 필터링된 결과 반환
	    List<ProductDto> filteredProducts = service.getProductListByCategoryAndStock(dto);
	    model.addAttribute("filteredProducts", filteredProducts);
	    return ResponseEntity.ok(filteredProducts);
	}
}
	

// 사용자 페이지 관련 e
