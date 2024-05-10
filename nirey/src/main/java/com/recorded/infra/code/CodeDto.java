
package com.recorded.infra.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeDto {
	//데이터 관련 객체
	private String CodeGroupSeq;
	private String CodeGroupName;
	private Integer delNY;
	private String seq;
	private String name;
	private Date regDatetime;
	private Date modDatetime;
	
	//다중 셀렉한 값 배열로 저장 
	private String[] checkboxSeqArray  = null;
	
	 //데이터 관련 getter, setter
	public String[] getCheckboxSeqArray() {
		return checkboxSeqArray;
	}
	public void setCheckboxSeqArray(String[] checkboxSeqArray) {
		this.checkboxSeqArray = checkboxSeqArray;
	}
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
	@Override
	public String toString() {
		return "CodeDto [CodeGroupSeq=" + CodeGroupSeq + ", CodeGroupName=" + CodeGroupName + ", delNY=" + delNY
				+ ", seq=" + seq + ", name=" + name + ", regDatetime=" + regDatetime + ", modDatetime=" + modDatetime
				+ "]";
	}

//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();

	
	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	
	
}