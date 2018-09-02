package com.techsoft.studentinfo.dao;

import java.util.List;
import com.techsoft.studentinfo.dto.FileDTO;

public interface FileUploadDao {
	public void saveFileInfo(FileDTO fileDto);

	public List<FileDTO> listFile();

	public FileDTO getFileInfoById(int id);
}
