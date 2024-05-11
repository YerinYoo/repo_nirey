package com.recorded.infra.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class ProductDto {


private String productSeq;
private Integer delNY;
private String ProductName;
private Integer OrgPrice;
private Integer DiscountedPrice;
private Integer prodStockCD;
private Integer category1CD;
private Integer category2CD;
private Date regDateTime;
private Date modDateTime;
private String color;
private String size;
private String DetailDescription;
private String detailSize;
private String fabric;
private Integer reviewRate;
private String ReviewContent;
private String Member_seq;
private String Product_seq;
private String memberSeq;
private String name;
private Date revRegDateTime;
private Integer totalReviewCount;
private String colorSeq;
private String sizeSeq;
private Integer wishlistSeq;
private String revName;
private String memo;
private Integer reviewRateAvg;
private Integer ea;
private String wishlistColor;
private String wishlistSize;
private Integer Product_productSeq;
private String Member_memberSeq;

//다중 셀렉 배열
private String[] checkboxSeqArray  = null;

//이미지 테이블 관련 칼럼 - delNY, regDateTime, modDateTime는 이미 존재하여 따로 정의하지 X
private String imgSeq;
private String type;
private Integer defaultNY;
private String imgPath;
private String originalName;
private String ext;
private Integer fileSize;
private MultipartFile uploadFile; //단일 사진 업로드 시에 사용 
private MultipartFile[] uploadFiles; //여러 장 업로드 시에 배열 사용 



public Integer getFileSize() {
	return fileSize;
}
public void setFileSize(Integer fileSize) {
	this.fileSize = fileSize;
}
public MultipartFile getUploadFile() {
	return uploadFile;
}
public void setUploadFile(MultipartFile uploadFile) {
	this.uploadFile = uploadFile;
}
public MultipartFile[] getUploadFiles() {
	return uploadFiles;
}
public void setUploadFiles(MultipartFile[] uploadFiles) {
	this.uploadFiles = uploadFiles;
}
public String getImgSeq() {
	return imgSeq;
}
public void setImgSeq(String imgSeq) {
	this.imgSeq = imgSeq;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Integer getDefaultNY() {
	return defaultNY;
}
public void setDefaultNY(Integer defaultNY) {
	this.defaultNY = defaultNY;
}
public String getImgPath() {
	return imgPath;
}
public void setImgPath(String imgPath) {
	this.imgPath = imgPath;
}
public String getOriginalName() {
	return originalName;
}
public void setOriginalName(String originalName) {
	this.originalName = originalName;
}
public String getExt() {
	return ext;
}
public void setExt(String ext) {
	this.ext = ext;
}
public String[] getCheckboxSeqArray() {
	return checkboxSeqArray;
}
public void setCheckboxSeqArray(String[] checkboxSeqArray) {
	this.checkboxSeqArray = checkboxSeqArray;
}
public String getMember_memberSeq() {
	return Member_memberSeq;
}
public void setMember_memberSeq(String member_memberSeq) {
	Member_memberSeq = member_memberSeq;
}
public Integer getProduct_productSeq() {
	return Product_productSeq;
}
public void setProduct_productSeq(Integer product_productSeq) {
	Product_productSeq = product_productSeq;
}
public String getWishlistColor() {
	return wishlistColor;
}
public void setWishlistColor(String wishlistColor) {
	this.wishlistColor = wishlistColor;
}
public String getWishlistSize() {
	return wishlistSize;
}
public void setWishlistSize(String wishlistSize) {
	this.wishlistSize = wishlistSize;
}
public Integer getEa() {
	return ea;
}
public void setEa(Integer ea) {
	this.ea = ea;
}
public Integer getReviewRateAvg() {
	return reviewRateAvg;
}
public void setReviewRateAvg(Integer reviewRateAvg) {
	this.reviewRateAvg = reviewRateAvg;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}
public String getRevName() {
	return revName;
}
public void setRevName(String revName) {
	this.revName = revName;
}
public Integer getWishlistSeq() {
	return wishlistSeq;
}
public void setWishlistSeq(Integer wishlistSeq) {
	this.wishlistSeq = wishlistSeq;
}
public String getColorSeq() {
	return colorSeq;
}
public void setColorSeq(String colorSeq) {
	this.colorSeq = colorSeq;
}
public String getSizeSeq() {
	return sizeSeq;
}
public void setSizeSeq(String sizeSeq) {
	this.sizeSeq = sizeSeq;
}
public String getProductSeq() {
	return productSeq;
}
public void setProductSeq(String productSeq) {
	this.productSeq = productSeq;
}
public Integer getDelNY() {
	return delNY;
}

public void setDelNY(Integer delNY) {
	this.delNY = delNY;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public Integer getOrgPrice() {
	return OrgPrice;
}
public void setOrgPrice(Integer orgPrice) {
	OrgPrice = orgPrice;
}
public Integer getDiscountedPrice() {
	return DiscountedPrice;
}
public void setDiscountedPrice(Integer discountedPrice) {
	DiscountedPrice = discountedPrice;
}
public Integer getProdStockCD() {
	return prodStockCD;
}
public void setProdStockCD(Integer prodStockCD) {
	this.prodStockCD = prodStockCD;
}
public Integer getCategory1CD() {
	return category1CD;
}
public void setCategory1CD(Integer category1cd) {
	category1CD = category1cd;
}
public Integer getCategory2CD() {
	return category2CD;
}
public void setCategory2CD(Integer category2cd) {
	category2CD = category2cd;
}
public Date getRegDateTime() {
	return regDateTime;
}
public void setRegDateTime(Date regDateTime) {
	this.regDateTime = regDateTime;
}
public Date getModDateTime() {
	return modDateTime;
}
public void setModDateTime(Date modDateTime) {
	this.modDateTime = modDateTime;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public String getDetailDescription() {
	return DetailDescription;
}
public void setDetailDescription(String detailDescription) {
	DetailDescription = detailDescription;
}
public String getDetailSize() {
	return detailSize;
}
public void setDetailSize(String detailSize) {
	this.detailSize = detailSize;
}
public String getFabric() {
	return fabric;
}
public void setFabric(String fabric) {
	this.fabric = fabric;
}
public Integer getReviewRate() {
	return reviewRate;
}
public void setReviewRate(Integer reviewRate) {
	this.reviewRate = reviewRate;
}
public String getReviewContent() {
	return ReviewContent;
}
public void setReviewContent(String reviewContent) {
	ReviewContent = reviewContent;
}
public String getMember_seq() {
	return Member_seq;
}
public void setMember_seq(String member_seq) {
	Member_seq = member_seq;
}
public String getProduct_seq() {
	return Product_seq;
}
public void setProduct_seq(String product_seq) {
	Product_seq = product_seq;
}
public String getMemberSeq() {
	return memberSeq;
}
public void setMemberSeq(String memberSeq) {
	this.memberSeq = memberSeq;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getRevRegDateTime() {
	return revRegDateTime;
}
public void setRevRegDateTime(Date revRegDateTime) {
	this.revRegDateTime = revRegDateTime;
}
public Integer getTotalReviewCount() {
	return totalReviewCount;
}
public void setTotalReviewCount(Integer totalReviewCount) {
	this.totalReviewCount = totalReviewCount;
}
@Override
public String toString() {
	return "ProductDto [productSeq=" + productSeq + ", delNY=" + delNY + ", ProductName=" + ProductName + ", OrgPrice="
			+ OrgPrice + ", DiscountedPrice=" + DiscountedPrice 	+ ", prodStockCD=" + prodStockCD + ", category1CD=" + category1CD + ", category2CD=" + category2CD
			+ ", regDateTime=" + regDateTime + ", modDateTime=" + modDateTime + ", color=" + color + ", size=" + size
			+ ", DetailDescription=" + DetailDescription + ", detailSize=" + detailSize + ", fabric=" + fabric
			+ ", reviewRate=" + reviewRate + ", ReviewContent=" + ReviewContent + ", Member_seq=" + Member_seq
			+ ", Product_seq=" + Product_seq + ", memberSeq=" + memberSeq + ", name=" + name + ", revRegDateTime="
			+ revRegDateTime + "]";
}





//for cache
public static List<ProductDto> cachedProductArrayList = new ArrayList<ProductDto>();

public static List<ProductDto> getCachedCodeArrayList() {
	return cachedProductArrayList;
}
public static void setCachedProductArrayList(List<ProductDto> cachedProductArrayList) {
	ProductDto.cachedProductArrayList = cachedProductArrayList;
}


}
