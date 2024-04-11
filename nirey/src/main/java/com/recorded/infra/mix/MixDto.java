package com.recorded.infra.mix;

import java.util.Date;

public class MixDto {

	private String orderSeq;
	private String orderStatus;
	private Integer RefundNY;
	private Integer TotalOrgPrice;
	private Integer TotalDiscPrice;
	private Integer TotalPrice;
	private Date OrderDate;
	private Integer CardNo;
	private Integer CVV;
	private Date CardDate;
	private String CardOwner;
	private Integer orderTrackingNo;
	private Integer paymentCD;
	private Integer cardCompCD;
	private String ID;
	private String name;
	private String ProductName;
	private Integer DiscountedPrice;
	private String color;
	private String size;
	private Integer addrTypeCD;
	private String addr;
	private String addrDetail;
	private String zipcode;
	private String recipient;
	private String phoneNum;
	private String shippingMsg;
	private String colorOption;
	private String sizeOption;
	private String defaultNY;
	
	public String getOrderSeq() {
		return orderSeq;
	}
	public void setOrderSeq(String orderSeq) {
		this.orderSeq = orderSeq;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getRefundNY() {
		return RefundNY;
	}
	public void setRefundNY(Integer refundNY) {
		RefundNY = refundNY;
	}
	public Integer getTotalOrgPrice() {
		return TotalOrgPrice;
	}
	public void setTotalOrgPrice(Integer totalOrgPrice) {
		TotalOrgPrice = totalOrgPrice;
	}
	public Integer getTotalDiscPrice() {
		return TotalDiscPrice;
	}
	public void setTotalDiscPrice(Integer totalDiscPrice) {
		TotalDiscPrice = totalDiscPrice;
	}
	public Integer getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		TotalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public Integer getCardNo() {
		return CardNo;
	}
	public void setCardNo(Integer cardNo) {
		CardNo = cardNo;
	}
	public Integer getCVV() {
		return CVV;
	}
	public void setCVV(Integer cVV) {
		CVV = cVV;
	}
	public Date getCardDate() {
		return CardDate;
	}
	public void setCardDate(Date cardDate) {
		CardDate = cardDate;
	}
	public String getCardOwner() {
		return CardOwner;
	}
	public void setCardOwner(String cardOwner) {
		CardOwner = cardOwner;
	}
	public Integer getOrderTrackingNo() {
		return orderTrackingNo;
	}
	public void setOrderTrackingNo(Integer orderTrackingNo) {
		this.orderTrackingNo = orderTrackingNo;
	}
	public Integer getPaymentCD() {
		return paymentCD;
	}
	public void setPaymentCD(Integer paymentCD) {
		this.paymentCD = paymentCD;
	}
	public Integer getCardCompCD() {
		return cardCompCD;
	}
	public void setCardCompCD(Integer cardCompCD) {
		this.cardCompCD = cardCompCD;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Integer getDiscountedPrice() {
		return DiscountedPrice;
	}
	public void setDiscountedPrice(Integer discountedPrice) {
		DiscountedPrice = discountedPrice;
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
	public Integer getAddrTypeCD() {
		return addrTypeCD;
	}
	public void setAddrTypeCD(Integer addrTypeCD) {
		this.addrTypeCD = addrTypeCD;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getShippingMsg() {
		return shippingMsg;
	}
	public void setShippingMsg(String shippingMsg) {
		this.shippingMsg = shippingMsg;
	}
	public String getColorOption() {
		return colorOption;
	}
	public void setColorOption(String colorOption) {
		this.colorOption = colorOption;
	}
	public String getSizeOption() {
		return sizeOption;
	}
	public void setSizeOption(String sizeOption) {
		this.sizeOption = sizeOption;
	}
	public String getDefaultNY() {
		return defaultNY;
	}
	public void setDefaultNY(String defaultNY) {
		this.defaultNY = defaultNY;
	}
	@Override
	public String toString() {
		return "MixDto [orderSeq=" + orderSeq + ", orderStatus=" + orderStatus + ", RefundNY=" + RefundNY
				+ ", TotalOrgPrice=" + TotalOrgPrice + ", TotalDiscPrice=" + TotalDiscPrice + ", TotalPrice="
				+ TotalPrice + ", OrderDate=" + OrderDate + ", CardNo=" + CardNo + ", CVV=" + CVV + ", CardDate="
				+ CardDate + ", CardOwner=" + CardOwner + ", orderTrackingNo=" + orderTrackingNo + ", paymentCD="
				+ paymentCD + ", cardCompCD=" + cardCompCD + ", ID=" + ID + ", name=" + name + ", ProductName="
				+ ProductName + ", DiscountedPrice=" + DiscountedPrice + ", color=" + color + ", size=" + size
				+ ", addrTypeCD=" + addrTypeCD + ", addr=" + addr + ", addrDetail=" + addrDetail + ", zipcode="
				+ zipcode + ", recipient=" + recipient + ", phoneNum=" + phoneNum + ", shippingMsg=" + shippingMsg
				+ ", colorOption=" + colorOption + ", sizeOption=" + sizeOption + "]";
	}
	
	
	
	




}
