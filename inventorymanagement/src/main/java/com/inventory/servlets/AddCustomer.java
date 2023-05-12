package com.inventory.servlets;

import java.io.IOException;
import java.time.LocalDate;

import com.inventory.dto.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inventory.dto.Product;
import com.inventory.repository.Repository;
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerName = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		System.out.println(customerName);
		
		
		HttpSession session  = request.getSession();
		int uid = (int) session.getAttribute("uid");
		
		LocalDate date = LocalDate.now();
		Customer customer = new Customer(0,customerName,address,phone,uid,date);
		
		int bill_id = 1;//Repository.getInstance().getBillId();
		
		session.setAttribute("bill_id", bill_id);
		session.setAttribute("customerName",customerName);
		session.setAttribute("address", address);
		session.setAttribute("phone",phone);
		session.setAttribute("date",date);
		System.out.println("hello");
		response.setContentType("text/html");  
		response.sendRedirect("./billing.jsp");  
//		RequestDispatcher rd=request.getRequestDispatcher("billing.jsp");
//		rd.forward(request, response);
		response.getWriter().close();
	}
}
