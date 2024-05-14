package com.recorded.infra.uploadFile;

import java.util.Date;

public class UploadFileDto {

	private String imgSeq;
	private Integer imgType;
	private Integer defaultNY;
	private Integer sort;
	private String path;
	private String originalName;
	private String uuidName;
	private String ext;
	private Long size;
	private Integer delNY;
	private String productSeqF;
	private Date regDateTime;
	private Date modDateTime;
	
	//getter, setter
	public String getImgSeq() {
		return imgSeq;
	}
	public void setImgSeq(String imgSeq) {
		this.imgSeq = imgSeq;
	}
	public Integer getImgType() {
		return imgType;
	}
	public void setImgType(Integer imgType) {
		this.imgType = imgType;
	}
	public Integer getDefaultNY() {
		return defaultNY;
	}
	public void setDefaultNY(Integer defaultNY) {
		this.defaultNY = defaultNY;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getUuidName() {
		return uuidName;
	}
	public void setUuidName(String uuidName) {
		this.uuidName = uuidName;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Integer getDelNY() {
		return delNY;
	}
	public void setDelNY(Integer delNY) {
		this.delNY = delNY;
	}
	public String getProductSeqF() {
		return productSeqF;
	}
	public void setProductSeqF(String productSeqF) {
		this.productSeqF = productSeqF;
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
	
	//toString()
	@Override
	public String toString() {
		return "UploadFileDto [imgSeq=" + imgSeq + ", imgType=" + imgType + ", defaultNY=" + defaultNY + ", sort="
				+ sort + ", path=" + path + ", originalName=" + originalName + ", uuidName="
				+ uuidName + ", ext=" + ext + ", size=" + size + ", delNY=" + delNY + ", productSeqF=" + productSeqF
				+ ", regDateTime=" + regDateTime + ", modDateTime=" + modDateTime + "]";
	}
	
}
