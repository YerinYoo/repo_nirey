package com.recorded.infra.product;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.recorded.common.util.UtilDateTime;
import com.recorded.infra.uploadFile.UploadFileDao;
import com.recorded.infra.uploadFile.UploadFileDto;

@Service
//Service = 로직, DAO를 호출하여 조합시키는 곳
public class ProductService {
	
	@Autowired
	ProductDao dao; 
	@Autowired
	UploadFileDao daoF;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	@Value("${cloud_aws_bucket}")
	private String bucket;
	//----------------------------------
	//Admin
	public List<ProductDto> selectList() { return dao.selectList();}
	
	public ProductDto selectOne(ProductDto dto) {
		return dao.selectOne(dto);
	}
	
//	public int insert(ProductDto dto) {
//	return dao.insert(dto);
//}
	
	//product Insert 시에 파일 함께 S3에 업로드 
    public int insert(ProductDto dtoP, UploadFileDto dto) throws Exception { 

    	dao.insert(dtoP);
		
    	int index=0;
    	
		for(MultipartFile multipartFiles : dtoP.getUploadFiles()) {
			
			if(!multipartFiles.isEmpty()) {
				
				String className = dto.getClass().getSimpleName().toString().toLowerCase();		
				String fileName = multipartFiles.getOriginalFilename();
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				String uuidFileName = UUID.randomUUID().toString() + "." + ext;
				String pathModule = className;
				String nowString = UtilDateTime.nowString();
//				String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
				Integer defaultNY = 0; //defaultNY 값을 찾지 못하는 에러로 인해 잠시 0으로 지정. 이후 수정 예정
//				Integer defaultNY;
//				
//				if(index == 0) {
//					defaultNY=0;
//				}
//				else {
//					defaultNY=1;
//				}
				System.out.println("defaultNY : " + dto.getDefaultNY());
				
		        ObjectMetadata metadata = new ObjectMetadata();
		        metadata.setContentLength(multipartFiles.getSize());
		        
		        amazonS3Client.putObject(bucket, uuidFileName, multipartFiles.getInputStream(), metadata);
				
		        String objectUrl = amazonS3Client.getUrl(bucket, uuidFileName).toString();
		        
				dto.setPath(objectUrl);
				dto.setOriginalName(fileName);
				dto.setUuidName(uuidFileName);
				dto.setExt(ext);
				dto.setSize(multipartFiles.getSize());
				
//				dto.setTableName(tableName);
				dto.setDefaultNY(defaultNY);
				dto.setSort(index);
				dto.setProductSeqF(dtoP.getProductSeq());
				
			    daoF.insertFile(dto, dtoP);
			}
		}
		return 0;
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
	
    //페이지네이션 관련
    public List<ProductDto> selectPagedProductList(ProductVo vo) {
    	return dao.selectPagedProductList(vo);
    }
    
    //개수 리턴
    public int getTotalProductCount(ProductVo vo) {
    	return dao.getTotalProductCount(vo);
    }
    

	//------------------------------------
	//User
	//제품 전체 리스트 호출 
	public List<ProductDto> prodList() { return dao.prodList();}
	
	//prodStockCD에 따른 필터링 
	public List<ProductDto> filteringByNew() { return dao.filteringByNew();}
	
	public List<ProductDto> filteringByBest() { return dao.filteringByBest();}
	
	public List<ProductDto> filteringByRestock() { return dao.filteringByRestock();}
	
	//categoryCD에 따른 필터링 
	public List<ProductDto> filteringByCategoryCD() { return dao.filteringByCategoryCD();}
	
	//제품 옵션에 대한 리스트 호출 
	public List<ProductDto>prodColor(ProductDto dto) {return dao.prodColor(dto);}
	
	public List<ProductDto>prodSize(ProductDto dto) {return dao.prodSize(dto);}
	
	public List<ProductDto> prodImgList(ProductDto dto) {return dao.prodImgList(dto);}
	
	//위시리스트 페이지에서 호출할 제품 옵션 
	public List<ProductDto> colorOption(ProductDto dto) {return dao.colorOption(dto);}
	
	public List<ProductDto> sizeOption(ProductDto dto) {return dao.sizeOption(dto);}
	
	//제품 리뷰 리스트 호출 
	public List<ProductDto> prodReview(ProductDto dto) {return dao.prodReview(dto);}


	//단일 제품 조회 
	public ProductDto selectProd(ProductDto dto) { return dao.selectProd(dto); }
	

	//리뷰 작성 메서드 
	public int insertRev(ProductDto dto) {
		return dao.insertRev(dto);
	}
	
	//단일 제품 페이지에서 위시리스트로 제품 넘기기 (옵션 포함)
	public int insertWishlist(ProductDto dto) {
		return dao.insertWishlist(dto);
	}
	
//	//주문 페이지를 통해 주문 리스트에 주문 내역 올리기 
//	public int insertOrders(ProductDto dto) {
//		return dao.insertOrders(dto);
//	}
//	
//	//주문 내역 중 제품 올리기 
//	public int insertOrderedProd (ProductDto dto) {
//		return dao.insertOrderedProd(dto);
//	}
	

	//위시리스트에서 제품 삭제하기 
	public int ueleteW(ProductDto dto) {
		return dao.ueleteW(dto);
	}

    public List<ProductDto> selectList(ProductVo vo) { 
    	return dao.selectList(vo); 
    }

    // 제품 검색 메서드
    public List<ProductDto> searchProducts(ProductVo vo) throws Exception {
        return dao.selectList(vo);
    }
    
    //위시리스트 목록 조회 
    public List<ProductDto> wishlist() { return dao.wishlist();}

	//위시리스트 일부 제품 선택
	public ProductDto selectWishlist(ProductDto dto) {
		return dao.selectWishlist(dto);
	}
	
	//카테고리 별 필터링 내용
	public List<ProductDto> outer() {return dao.outer();}
	public List<ProductDto> top() {return dao.top();}
	public List<ProductDto> bottom() {return dao.bottom();}
	public List<ProductDto> dress() {return dao.dress();}
	public List<ProductDto> bag() {return dao.bag();}
	public List<ProductDto> shoes() {return dao.shoes();}
	public List<ProductDto> acc() {return dao.acc();}
	public List<ProductDto> etc() {return dao.etc();}
}



