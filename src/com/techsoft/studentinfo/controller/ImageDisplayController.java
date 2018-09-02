package com.techsoft.studentinfo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techsoft.studentinfo.service.StudentService;
import com.techsoft.studentinfo.service.StudentServiceImpl;
import com.techsoft.studentinfo.service.UserService;
import com.techsoft.studentinfo.service.UserServiceImpl;

@WebServlet("/ImageDisplayController")
public class ImageDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentServiceImpl();
	UserService userService=new UserServiceImpl();
	private final static int DEFAULT_BUFFER_SIZE = 1024;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("id");
		String filePath = "";
		if (studentId != null) {

			filePath = studentService.getImageUrl(Integer.parseInt(studentId));
		} else {
			int id = Integer.parseInt(request.getParameter("userId"));
			filePath = userService.getImageUrl(id);
		}

		File file = new File(filePath);
		String contentType = getServletContext().getMimeType(file.getName());
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(contentType);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		byte[] b = new byte[DEFAULT_BUFFER_SIZE];
		BufferedInputStream in = null;
		BufferedOutputStream out = null;

		try {
			in = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(response.getOutputStream());
			int length;
			while ((length = in.read(b)) > 0) {
				out.write(b, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
		}
	}
}
