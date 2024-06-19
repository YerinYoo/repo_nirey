package com.recorded.infra.product;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

	public List<ProductDto> selectList(); 
	
	public List<ProductDto> prodList(); 

	public List<ProductDto>filteringByNew();
	
	public List<ProductDto>filteringByBest();
	
	public List<ProductDto>filteringByRestock();
	
	public List<ProductDto> filteringByCategoryCD();
	
	public List<ProductDto> prodColor(ProductDto dto);
	
	public List<ProductDto> prodSize(ProductDto dto);
	
	public List<ProductDto> sizeOption (ProductDto dto);
	
	public List<ProductDto> colorOption(ProductDto dto);
	
	public List<ProductDto> prodImgList(ProductDto dto);
	
	public List<ProductDto> prodReview(ProductDto dto);
	
	public ProductDto selectOne(ProductDto dto);
	
	public ProductDto selectProd(ProductDto dto); 
	 
	public ProductDto selectWishlist(ProductDto dto);
	
	public int insert(ProductDto dto);
	public int insertRev(ProductDto dto);
	public int insertWishlist(ProductDto dto);

	public int update(ProductDto dto);
	public int uelete(ProductDto dto);
	public int delete(ProductDto dto);
	public int ueleteW(ProductDto dto);
	
	public List<ProductDto> selectList(ProductVo vo);

    //페이징 처리 리스트 
    public List<ProductDto> selectPagedProductList(ProductVo vo);
    
    //개수 리턴
    public int getTotalProductCount(ProductVo vo);

    //위시리스트
    public List<ProductDto> wishlist();
    
    //카테고리 별 필터링
    public List<ProductDto> outer();
    public List<ProductDto> top();
    public List<ProductDto> bottom();
    public List<ProductDto> dress();
    public List<ProductDto> bag();
    public List<ProductDto> shoes();
    public List<ProductDto> acc();
    public List<ProductDto> etc();
}