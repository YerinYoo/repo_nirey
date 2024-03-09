
package com.recorded.infra.code;

import java.util.Date;

public class CodeDto {
	
	private String CodeGroupSeq;
	private String CodeGroupName;
	private Integer delNY;
	private String seq;
	private String name;
	private String memo;
	private Date regDatetime;
	private Date modDatetime;
	
	public String getCodeGroupSeq() {
		return CodeGroupSeq;
	}
	public void setCodeGroupSeq(String codeGroupSeq) {
		CodeGroupSeq = codeGroupSeq;
	}
	public String getCodeGroupName() {
		return CodeGroupName;
	}
	public void setCodeGroupName(String codeGroupName) {
		CodeGroupName = codeGroupName;
	}
	public Integer getDelNY() {
		return delNY;
	}
	public void setDelNY(Integer delNY) {
		this.delNY = delNY;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getModDatetime() {
		return modDatetime;
	}
	public void setModDatetime(Date modDatetime) {
		this.modDatetime = modDatetime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getRegDatetime() {
		return regDatetime;
	}
	public void setRegDatetime(Date regDatetime) {
		this.regDatetime = regDatetime;
	}
	@Override //toString
	public String toString() {
		return "CodeDto [CodeGroupSeq=" + CodeGroupSeq + ", CodeGroupName=" + CodeGroupName + ", delNY=" + delNY
				+ ", seq=" + seq + ", name=" + name + ", memo=" + memo + ", regDatetime=" + regDatetime
				+ ", modDatetime=" + modDatetime + "]";
	}

	
	
}