package com.techsoft.studentinfo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.techsoft.studentinfo.dto.FileDTO;
import com.techsoft.studentinfo.service.FileUploadService;
import com.techsoft.studentinfo.service.FileUploadServiceImpl;
import com.techsoft.studentinfo.util.WriteDataToFileUtil;

@WebServlet("/FileUploadController")
@MultipartConfig
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileUploadService fileUploadService=new FileUploadServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("actions");
		String forward="";
		if(action.equals("download")){
			request.setAttribute("fileList", fileUploadService.listFile());
			forward="download.jsp";
			
		}else if(action.equals("upload")){
			forward="fileUpload.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part part=request.getPart("filename");
		String fileName=WriteDataToFileUtil.getFileName(part);
		String description=request.getParameter("description");
		String fileUrl=WriteDataToFileUtil.writeToFile(part, WriteDataToFileUtil.FILE_PATH+fileName);
		FileDTO fileDto=new FileDTO();
		fileDto.setFileName(fileName);
		fileDto.setDescription(description);
		fileDto.setFilePath(fileUrl);
		fileUploadService.saveFileInfo(fileDto);
		RequestDispatcher rd=request.getRequestDispatcher("fileUpload.jsp");
		request.setAttribute("fileUploadMsg", "File Uploaded Successfully");
		rd.forward(request, response);
		
	}

}
