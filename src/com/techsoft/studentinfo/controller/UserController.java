package com.techsoft.studentinfo.controller;

import java.io.IOException;
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

import com.techsoft.studentinfo.dto.User;
import com.techsoft.studentinfo.service.UserService;
import com.techsoft.studentinfo.service.UserServiceImpl;
import com.techsoft.studentinfo.util.EmailUtil;
import com.techsoft.studentinfo.util.WriteDataToFileUtil;

@WebServlet("/UserController")
@MultipartConfig
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	private static final String USER_LIST = "userDetails.jsp";
	private static final String USER_FORM = "userForm.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("actions");
		String forward = "";
		if (action.equalsIgnoreCase("add_new")) {
			forward = USER_FORM;
		} else if (action.equalsIgnoreCase("edit")) {
			int id = Integer.parseInt(request.getParameter("userId"));
			request.setAttribute("user", userService.getUserById(id));
			forward = USER_FORM;
		} else if (action.equalsIgnoreCase("User_list")) {
			request.setAttribute("users", userService.getAllUserInfo());
			forward = USER_LIST;
		} else if (action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("userId"));
			userService.deleteUserInfo(id);
			request.setAttribute("users", userService.getAllUserInfo());
			forward = USER_LIST;

		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setFirstName(request.getParameter("fname"));
		user.setLastName(request.getParameter("lname"));
		user.setGender(request.getParameter("gender"));
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
			user.setDob(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("uname"));
		user.setPassword(request.getParameter("pass"));

		String userId = request.getParameter("userid");
		// for image upload part
		Part part = request.getPart("image");
		String fileName = WriteDataToFileUtil.getFileName(part);
		String image_url = "";
		if (!fileName.isEmpty()) {
			image_url = WriteDataToFileUtil.writeToFile(part, WriteDataToFileUtil.FILE_PATH + fileName);
		} else {
			image_url = userService.getImageUrl(Integer.parseInt(userId));
		}
		user.setImageUrl(image_url);
		if (userId == null || userId.isEmpty()) {

			userService.saveUserInfo(user);
			EmailUtil.sendEmail(user.getEmail());
		} else {
			user.setUserId(Integer.parseInt(userId));
			userService.updateUserInfo(user);
		}
		RequestDispatcher rd = request.getRequestDispatcher(USER_LIST);
		request.setAttribute("users", userService.getAllUserInfo());
		rd.forward(request, response);
	}
}
