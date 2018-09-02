package com.techsoft.studentinfo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techsoft.studentinfo.dto.User;
import com.techsoft.studentinfo.service.UserService;
import com.techsoft.studentinfo.service.UserServiceImpl;
import com.techsoft.studentinfo.util.EmailUtil;
import com.techsoft.studentinfo.util.ProjectUtil;

@WebServlet("/ForgotPassword")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService=new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email=request.getParameter("email");
		User user=userService.checkEmail(email);
		if(user.getEmail()==null || user.getEmail().isEmpty()){

			RequestDispatcher rd = request.getRequestDispatcher("forgotPassword.jsp");
			request.setAttribute("EmailNotFound", "Your Email not found");
			rd.include(request, response);
			
			
		}else{
			String newPassword=ProjectUtil.newPassword();
			user.setPassword(newPassword);
			userService.updateUserInfo(user);
			EmailUtil.sendEmail(email, newPassword);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		
	}

}
