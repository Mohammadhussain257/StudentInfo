package com.techsoft.studentinfo.service;

import java.util.List;

import com.techsoft.studentinfo.dto.FileDTO;

public interface FileUploadService {

	public void saveFileInfo(FileDTO fileDto);

	public List<FileDTO> listFile();

	public FileDTO getFileInfoById(int id);
}
