package com.techsoft.studentinfo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techsoft.studentinfo.service.UserService;
import com.techsoft.studentinfo.service.UserServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("uname")) {
				request.setAttribute("username", cookie.getValue());
			}
		}
		request.setAttribute("logoutFailMsg", "Your are successfully logged out!!!");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String rememberme = request.getParameter("remember-me");

		UserService userService = new UserServiceImpl();
		int userId=userService.checkUser(username, password);
		if (userId> 0) {
			if (rememberme != null) {
				Cookie cookie = new Cookie("uname", username);
				cookie.setMaxAge(24 * 60 * 60);
				response.addCookie(cookie);
			}
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userId", userId);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("loginFailMsg", "Wrong username or password!!!");
			rd.include(request, response);
		}

	}

}
