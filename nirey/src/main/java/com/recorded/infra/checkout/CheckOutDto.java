package com.recorded.infra.checkout;

import java.util.Date;

public class CheckOutDto {
	
	//orders column
	private Integer orderSeq;
	private Integer memberSeq;
	private Integer productOrderedSeqF;
	private Integer orderStatus;
	private Integer RefundNY;
	private Date OrderDate;
	private Integer CardNo;
	private Integer CVV;
	private Integer CardDate;
	private Integer paymentCD;
	private Integer cardCompCD;
	private String CardOwner;
	
	//productOrdered column
	private Integer productSeqF;
	private Integer ordersSeqF;
	private Integer ea;
	private Integer OrgPrice;
	private Integer DiscountedPrice;
	private String size;
	private String color;
	
	//getter, setter
	public Integer getOrderSeq() {
		return orderSeq;
	}
	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}
	public Integer getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(Integer memberSeq) {
		this.memberSeq = memberSeq;
	}
	public Integer getProductOrderedSeqF() {
		return productOrderedSeqF;
	}
	public void setProductOrderedSeqF(Integer productOrderedSeqF) {
		this.productOrderedSeqF = productOrderedSeqF;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getRefundNY() {
		return RefundNY;
	}
	public void setRefundNY(Integer refundNY) {
		RefundNY = refundNY;
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
	public Integer getCardDate() {
		return CardDate;
	}
	public void setCardDate(Integer cardDate) {
		CardDate = cardDate;
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
	public String getCardOwner() {
		return CardOwner;
	}
	public void setCardOwner(String cardOwner) {
		CardOwner = cardOwner;
	}
	public Integer getProductSeqF() {
		return productSeqF;
	}
	public void setProductSeqF(Integer productSeqF) {
		this.productSeqF = productSeqF;
	}
	public Integer getOrdersSeqF() {
		return ordersSeqF;
	}
	public void setOrdersSeqF(Integer ordersSeqF) {
		this.ordersSeqF = ordersSeqF;
	}
	public Integer getEa() {
		return ea;
	}
	public void setEa(Integer ea) {
		this.ea = ea;
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	//toString()
	@Override
	public String toString() {
		return "CheckOutDto [orderSeq=" + orderSeq + ", memberSeq=" + memberSeq + ", productOrderedSeqF="
				+ productOrderedSeqF + ", orderStatus=" + orderStatus + ", RefundNY=" + RefundNY + ", OrderDate="
				+ OrderDate + ", CardNo=" + CardNo + ", CVV=" + CVV + ", CardDate=" + CardDate + ", paymentCD="
				+ paymentCD + ", cardCompCD=" + cardCompCD + ", CardOwner=" + CardOwner + ", productSeqF=" + productSeqF
				+ ", ordersSeqF=" + ordersSeqF + ", ea=" + ea + ", OrgPrice=" + OrgPrice + ", DiscountedPrice="
				+ DiscountedPrice + ", size=" + size + ", color=" + color + "]";
	}
	
	
	
}
