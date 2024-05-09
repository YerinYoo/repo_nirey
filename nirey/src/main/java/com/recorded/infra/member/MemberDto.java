package com.recorded.infra.member;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDto {
	
	private String memberSeq;
	private Integer quitNY;
	private Integer dormantNY;
	private String ID;
	private String pwd;
	private Integer genderCD;
	private String name;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String MobileNum;
	private Date joinDate;
	private Date modDateTime;
	private String addrDetail;
	private String addr;
	private String zipcode;
	private String recipient;
	private String phoneNum;
	private String ShippingMsg;

//네이버 로그인 api 사용 시 추가 필요 객체
	private String id;
	private String nickname;
	private String profileImage;
	
	
	


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
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
		return ShippingMsg;
	}
	public void setShippingMsg(String shippingMsg) {
		ShippingMsg = shippingMsg;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}

	public Integer getQuitNY() {
		return quitNY;
	}
	public void setQuitNY(Integer quitNY) {
		this.quitNY = quitNY;
	}
	public Integer getDormantNY() {
		return dormantNY;
	}
	public void setDormantNY(Integer dormantNY) {
		this.dormantNY = dormantNY;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getGenderCD() {
		return genderCD;
	}
	public void setGenderCD(Integer genderCD) {
		this.genderCD = genderCD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthday = dateFormat.parse(birthday);
        } catch (ParseException e) {
            System.err.println("Failed to parse birthday: " + birthday);
            e.printStackTrace();
        }
    }

	public String getMobileNum() {
		return MobileNum;
	}
	public void setMobileNum(String mobileNum) {
		MobileNum = mobileNum;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(Date modDateTime) {
		this.modDateTime = modDateTime;
	}


	@Override
	public String toString() {
		return "MemberDto [memberSeq=" + memberSeq + ", quitNY=" + quitNY + ", dormantNY=" + dormantNY + ", ID=" + ID
				+ ", pwd=" + pwd + ", genderCD=" + genderCD + ", name=" + name + ", email=" + email + ", birthday="
				+ birthday + ", MobileNum=" + MobileNum + ", joinDate=" + joinDate + ", modDateTime=" + modDateTime
				+ "]";
	}

	
	
	

}
