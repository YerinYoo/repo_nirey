package com.recorded.infra.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProductDto {


private String productSeq;
private Integer delNY;
private String ProductName;
private Integer OrgPrice;
private Integer DiscountedPrice;
private String ProductDescription;
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
public String getProductDescription() {
	return ProductDescription;
}
public void setProductDescription(String productDescription) {
	ProductDescription = productDescription;
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


@Override
public String toString() {
	return "ProductDto [productSeq=" + productSeq + ", delNY=" + delNY + ", ProductName=" + ProductName + ", OrgPrice="
			+ OrgPrice + ", DiscountedPrice=" + DiscountedPrice + ", ProductDescription=" + ProductDescription
			+ ", prodStockCD=" + prodStockCD + ", category1CD=" + category1CD + ", category2CD=" + category2CD
			+ ", regDateTime=" + regDateTime + ", modDateTime=" + modDateTime + ", color=" + color + ", size=" + size
			+ ", DetailDescription=" + DetailDescription + ", detailSize=" + detailSize + ", fabric=" + fabric + "]";
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
