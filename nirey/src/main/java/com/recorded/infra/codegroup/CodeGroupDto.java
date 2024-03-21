package com.recorded.infra.codegroup;

import java.util.Date;

public class CodeGroupDto {

	private String seq;
	private String name;
	private Integer delNY;
	private Date  regDatetime;
	private Date modDatetime;
	private  Integer cdSeqCount;
	//private Integer cgSeqCount;
		
	//getter, setter
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
	public Integer getDelNY() {
		return delNY;
	}
	public void setDelNY(Integer delNY) {
		this.delNY = delNY;
	}
	public Date getRegDatetime() {
		return regDatetime;
	}
	public void setRegDatetime(Date regDatetime) {
		this.regDatetime = regDatetime;
	}
	public Date getModDatetime() {
		return modDatetime;
	}
	public void setModDatetime(Date modDatetime) {
		this.modDatetime = modDatetime;
	}
	public Integer getCdSeqCount() {
		return cdSeqCount;
	}
	public void setCdSeqCount(Integer cdSeqCount) {
		this.cdSeqCount = cdSeqCount;
	}
	//public Integer getCgSeqCount() {
	//	return cgSeqCount;
	//}
	//public void setCgSeqCount(Integer cgSeqCount) {
	//	this.cgSeqCount = cgSeqCount;
	//}
	@Override
	public String toString() {
		return "CodeGroupDto [seq=" + seq + ", name=" + name + ", memo=" + ", delNY=" + delNY + ", regDatetime="
				+ regDatetime + ", modDatetime=" + modDatetime + ", cdSeqCount=" + cdSeqCount + ", cgSeqCount="
				+ "]";
	}
	
	
	
	

	

	
	
	
	
}
