package com.recorded.infra.product;

import java.util.List;

public interface ProductDao {

	public List<ProductDto> selectList(); 
	public ProductDto selectOne(ProductDto dto);
	
	public int insert(ProductDto dto);
	public int update(ProductDto dto);
	public int uelete(ProductDto dto);
	public int delete(ProductDto dto);
	
	public List<ProductDto> selectList(ProductVo vo);

    //페이징 처리 리스트 
    public List<ProductDto> selectPagedProductList(ProductVo vo);
    
    //개수 리턴
    public int getTotalProductCount(ProductVo vo);
}
