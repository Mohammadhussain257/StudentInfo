package com.techsoft.studentinfo.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.techsoft.studentinfo.dto.Student;
import com.techsoft.studentinfo.service.StudentService;
import com.techsoft.studentinfo.service.StudentServiceImpl;

@WebServlet("/StudentController")
@MultipartConfig
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentServiceImpl();
	private static final String STUDENT_FORM = "studentForm.jsp";
	private static final String STUDENT_LIST = "studentDetails.jsp";
	private static final String IMAGEUPLOADPATH = "E:/SaveImage/";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("actions");
		String forward = "";
		if (action.equalsIgnoreCase("add_new")) {
			forward = STUDENT_FORM;
		} else if (action.equalsIgnoreCase("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("student", studentService.getStudentInfo(id));
			forward = STUDENT_FORM;
		} else if (action.equalsIgnoreCase("list_student")) {
			request.setAttribute("students", studentService.getAllStudentInfo());
			forward = STUDENT_LIST;
		} else if (action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			studentService.deleteStudentInfo(id);
			request.setAttribute("students", studentService.getAllStudentInfo());
			forward = STUDENT_LIST;

		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student();
		student.setStudentName(request.getParameter("sname"));
		student.setRoll(Integer.parseInt(request.getParameter("roll")));
		student.setCollegeName(request.getParameter("cname"));
		student.setEmail(request.getParameter("email"));
		student.setGender(request.getParameter("gender"));
		student.setDepartment(request.getParameter("departCombo"));

		// For date
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dob = dateFormat.parse(request.getParameter("dob"));
			student.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// For subject check box
		String subject = "";
		String[] subjects = request.getParameterValues("subject");
		for (String sub : subjects) {
			subject = subject + sub + "/";
		}
		student.setSubject(subject);

		String studentId = request.getParameter("id");

		// For image upload part
		Part part = request.getPart("photo");
		String fileName = getFileName(part);
		String imageUrl = "";
		if (!fileName.isEmpty()) {
			imageUrl = writeImageToFile(IMAGEUPLOADPATH + getFileName(part), part);
		} else {
			imageUrl = studentService.getImageUrl(Integer.parseInt(studentId));
		}

		student.setImageUrl(imageUrl);

		// For save of update

		if (studentId == null || studentId.isEmpty()) {
			studentService.saveStudentInfo(student);
		} else {
			student.setId(Integer.parseInt(studentId));
			studentService.updateStudentInfo(student);
		}

		RequestDispatcher rd = request.getRequestDispatcher("studentDetails.jsp");
		request.setAttribute("students", studentService.getAllStudentInfo());
		rd.forward(request, response);
	}

	public String writeImageToFile(String imageUrl, Part part) {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = part.getInputStream();
			out = new FileOutputStream(imageUrl);
			byte[] bytes = new byte[1024];
			int data;
			while ((data = in.read(bytes)) != -1) {
				out.write(bytes, 0, data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageUrl;
	}

	public String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return "";
	}
}
