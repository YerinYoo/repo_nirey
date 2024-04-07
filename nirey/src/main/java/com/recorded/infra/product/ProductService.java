package com.recorded.infra.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//Service = 로직, DAO를 호출하여 조합시키는 곳
public class ProductService {
	
	@Autowired
	ProductDao dao; 
	
	public List<ProductDto> selectList() { return dao.selectList();}
	
	
	public List<ProductDto> prodList() { return dao.prodList();}

	public ProductDto selectOne(ProductDto dto) {
		return dao.selectOne(dto);
	}

	public int insert(ProductDto dto) {
		return dao.insert(dto);
	}
	
	public int update(ProductDto dto ) {
		return dao.update(dto);
	}
	
	
	public int uelete(ProductDto dto) {
		return dao.uelete(dto);
	}
	
	
	public int delete(ProductDto dto) {
		return dao.delete(dto);
	}

    public List<ProductDto> selectList(ProductVo vo) { 
    	return dao.selectList(vo); 
    }

    //페이지네이션 관련
    public List<ProductDto> selectPagedProductList(ProductVo vo) {
    	return dao.selectPagedProductList(vo);
    }
    
    //개수 리턴
    public int getTotalProductCount(ProductVo vo) {
    	return dao.getTotalProductCount(vo);
    }
    
    // 제품 검색 메서드
    public List<ProductDto> searchProducts(ProductVo vo) throws Exception {
        return dao.selectList(vo);
    }
    
    // 카테고리 및 재고 상태에 따른 상품 목록 필터링
    public List<ProductDto> getProductListByCategoryAndStock(ProductVo vo) {
        return dao.selectList(vo);
    }

    // 필터링된 상품 목록 가져오기
    public List<ProductDto> getProductListByCategoryAndStock(ProductDto dto) {
        return dao.getProductListByCategoryAndStock(dto);
    }

}
