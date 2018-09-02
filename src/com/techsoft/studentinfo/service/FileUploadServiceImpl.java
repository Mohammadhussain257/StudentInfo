package com.techsoft.studentinfo.service;

import java.util.List;

import com.techsoft.studentinfo.dao.FileUploadDao;
import com.techsoft.studentinfo.dao.FileUploadDaoImpl;
import com.techsoft.studentinfo.dto.FileDTO;

public class FileUploadServiceImpl implements FileUploadService {
	FileUploadDao fileUploadDao = new FileUploadDaoImpl();

	@Override
	public void saveFileInfo(FileDTO fileDto) {

		fileUploadDao.saveFileInfo(fileDto);
	}

	@Override
	public List<FileDTO> listFile() {
		return fileUploadDao.listFile();
	}

	@Override
	public FileDTO getFileInfoById(int id) {
		return fileUploadDao.getFileInfoById(id);
	}

}
