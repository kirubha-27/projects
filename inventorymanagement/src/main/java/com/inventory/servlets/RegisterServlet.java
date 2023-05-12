package com.inventory.servlets;

import com.inventory.dto.*;
import com.inventory.repository.Repository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String pass = req.getParameter("pass");
		String storeName = req.getParameter("store");
		
		User user = new User(0,name,email,phone,pass,storeName);
		
		Repository.getInstance().addUser(user);
		
	}
}
