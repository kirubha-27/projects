package com.inventory.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inventory.dto.User;
import com.inventory.repository.Repository;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("psw");
		
		User user = Repository.getInstance().getByEmail(email,pass);
		
		if(email.equals(user.getEmailId())&&pass.equals(user.getPassword())){
			HttpSession session=request.getSession();  
			session.setAttribute("uid",user.getUserId());
			session.setAttribute("uname",user.getUserName());
			session.setAttribute("phoneNumber", user.getPhoneNumber());
			session.setAttribute("email",user.getEmailId());
			session.setAttribute("storeName",user.getStoreName());
			//request.getRequestDispatcher("navbar.jsp").include(request, response);
//			Cookie cookie = new Cookie("uid", String.valueOf(user.getUserId()));
//			response.addCookie(cookie);
//			System.out.println("success");
			response.sendRedirect("home.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
