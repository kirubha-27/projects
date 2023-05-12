package com.inventory.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddBillServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session  = request.getSession();
		int bill_id = (int)session.getAttribute("bill_id");
		String customerName = (String) session.getAttribute("customerName");
		String address = (String) session.getAttribute("address");
		String phone = (String) session.getAttribute("phone");
		String date = (String) session.getAttribute("date");
		
	}
}
