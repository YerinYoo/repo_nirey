package com.recorded.infra.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProductDto {


private Integer productSeq;
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
private String wishlistSeq;
private String revName;
private String memo;
private Integer reviewRateAvg;
private Integer ea;
private String wishlistColor;
private String wishlistSize;
private Integer Product_productSeq;
private String Member_memberSeq;



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
public String getWishlistSeq() {
	return wishlistSeq;
}
public void setWishlistSeq(String wishlistSeq) {
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
public Integer getProductSeq() {
	return productSeq;
}
public void setProductSeq(Integer productSeq) {
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
