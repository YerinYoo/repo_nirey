package com.recorded.infra.mix;

import java.util.Date;

public class MixDto {

	//orders column
	private String orderSeq;
	private String orderStatus;
	private Integer RefundNY;
	private Date OrderDate;
	private Integer CardNo;
	private Integer CVV;
	private Date CardDate;
	private String CardOwner;
	private Integer paymentCD;
	private Integer cardCompCD;
	private Integer totalPrice;
	private Integer totalOrgPrice;
	private Integer totalDiscountedPrice;
	
	//member column
	private String ID;
	private String name;
	
	//product column
	private String ProductName;
	private String productSeq;
	
	//productOrdered column
	private String productSeqF;
	private Integer ea;
	private Integer OrgPrice;
	private Integer DiscountedPrice;
	private String color;
	private String size;
	private Integer ordersSeqF;

	//address column
	private String addr;
	private String addrDetail;
	private String shippingMsg;
	private String zipcode;
	private String recipient;
	private String phoneNum;
	private String colorOption;
	private String sizeOption;
	private String defaultNY;

	//prodImg column
	private String path;
	
	//getter, setter
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

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalOrgPrice() {
		return totalOrgPrice;
	}

	public void setTotalOrgPrice(Integer totalOrgPrice) {
		this.totalOrgPrice = totalOrgPrice;
	}

	public Integer getTotalDiscountedPrice() {
		return totalDiscountedPrice;
	}

	public void setTotalDiscountedPrice(Integer totalDiscountedPrice) {
		this.totalDiscountedPrice = totalDiscountedPrice;
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

	public String getProductSeq() {
		return productSeq;
	}

	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}

	public String getProductSeqF() {
		return productSeqF;
	}

	public void setProductSeqF(String productSeqF) {
		this.productSeqF = productSeqF;
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

	public Integer getOrdersSeqF() {
		return ordersSeqF;
	}

	public void setOrdersSeqF(Integer ordersSeqF) {
		this.ordersSeqF = ordersSeqF;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getShippingMsg() {
		return shippingMsg;
	}

	public void setShippingMsg(String shippingMsg) {
		this.shippingMsg = shippingMsg;
	}

	//toString()
	@Override
	public String toString() {
		return "MixDto [orderSeq=" + orderSeq + ", orderStatus=" + orderStatus + ", RefundNY=" + RefundNY
				+ ", OrderDate=" + OrderDate + ", CardNo=" + CardNo + ", CVV=" + CVV + ", CardDate=" + CardDate
				+ ", CardOwner=" + CardOwner + ", paymentCD=" + paymentCD + ", cardCompCD=" + cardCompCD
				+ ", totalPrice=" + totalPrice + ", totalOrgPrice=" + totalOrgPrice + ", totalDiscountedPrice="
				+ totalDiscountedPrice + ", ID=" + ID + ", name=" + name + ", ProductName=" + ProductName
				+ ", productSeq=" + productSeq + ", productSeqF=" + productSeqF + ", ea=" + ea + ", OrgPrice="
				+ OrgPrice + ", DiscountedPrice=" + DiscountedPrice + ", color=" + color + ", size=" + size
				+ ", ordersSeqF=" + ordersSeqF + ", addr=" + addr + ", addrDetail=" + addrDetail + ", zipcode="
				+ zipcode + ", recipient=" + recipient + ", phoneNum=" + phoneNum + ", colorOption=" + colorOption
				+ ", sizeOption=" + sizeOption + ", defaultNY=" + defaultNY + ", path=" + path + "]";
	}
	
	
}
