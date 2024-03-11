package com.recorded.infra.codegroup;

public class CodeGroupVo {

	private Integer shDelNy = 0; /* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOptionDate = 2; /* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shDateStart;
	private String shDateEnd;
	private Integer shOption; /* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shValue;

	private String ifcgSeq;

	public Integer getShDelNy() {
		return shDelNy;
	}

	public Integer getShOptionDate() {
		return shOptionDate;
	}

	public String getShDateStart() {
		return shDateStart;
	}

	public String getShDateEnd() {
		return shDateEnd;
	}

	public Integer getShOption() {
		return shOption;
	}

	public String getShValue() {
		return shValue;
	}

	public String getIfcgSeq() {
		return ifcgSeq;
	}

	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}

	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
	}

	public void setShDateStart(String shDateStart) {
		this.shDateStart = shDateStart;
	}

	public void setShDateEnd(String shDateEnd) {
		this.shDateEnd = shDateEnd;
	}

	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}

	public void setShValue(String shValue) {
		this.shValue = shValue;
	}

	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}

	@Override
	public String toString() {
		return "CodeGroupVo [shDelNy=" + shDelNy + ", shOptionDate=" + shOptionDate + ", shDateStart=" + shDateStart
				+ ", shDateEnd=" + shDateEnd + ", shOption=" + shOption + ", shValue=" + shValue + ", ifcgSeq="
				+ ifcgSeq + "]";
	}

}
