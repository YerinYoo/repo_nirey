package com.recorded.infra.uploadFile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recorded.infra.product.ProductDto;

@Service
public class UploadFileService {

	@Autowired
	UploadFileDao dao;

	public List<UploadFileDto> selectUploadedFileList() {
		return dao.selectUploadedFileList();
	}
	
	public int insertFile(UploadFileDto dto, ProductDto dtoP) {
		return dao.insertFile(dto, dtoP);
	}
	
	public int updateFile (UploadFileDto dto) {
		return dao.updateFile(dto);
	}
	
	public int ueleteFile (UploadFileDto dto) {
		return dao.ueleteFile(dto);
	}
	
	public int deleteFile (UploadFileDto dto) {
		return dao.deleteFile(dto);
	}
}
