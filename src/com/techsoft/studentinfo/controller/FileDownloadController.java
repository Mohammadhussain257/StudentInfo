package com.techsoft.studentinfo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techsoft.studentinfo.dto.FileDTO;
import com.techsoft.studentinfo.service.FileUploadService;
import com.techsoft.studentinfo.service.FileUploadServiceImpl;

@WebServlet("/FileDownloadController")
public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileUploadService fileUploadService = new FileUploadServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fileId = request.getParameter("fileName");
		FileDTO fileDTO = fileUploadService.getFileInfoById(Integer.parseInt(fileId));

		// reads input file from an absolute path
		String filePath = fileDTO.getFilePath();
		File downloadFile = new File(fileDTO.getFileName());
		FileInputStream inStream = new FileInputStream(downloadFile);

		// obtains ServletContext
		ServletContext context = getServletContext();

		// gets MIME type of the file
		String mimeType = context.getMimeType(filePath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}

		// modifies response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// forces download
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// obtains response's output stream
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while ((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inStream.close();
		outStream.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
