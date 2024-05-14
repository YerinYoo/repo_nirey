package com.recorded.infra.uploadFile;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.recorded.infra.product.ProductDto;

@Repository
public interface UploadFileDao {

	public List<UploadFileDto> selectUploadedFileList();
	
	public int insertFile(UploadFileDto dto);
	
	public int updateFile(UploadFileDto dto);
	
	public int ueleteFile(UploadFileDto dto);
	
	public int deleteFile(UploadFileDto dto);
}
