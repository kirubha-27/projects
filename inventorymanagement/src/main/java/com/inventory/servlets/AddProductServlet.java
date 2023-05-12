package com.inventory.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inventory.dto.Product;
import com.inventory.repository.Repository;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add serblet called");
		String productName = (String) request.getParameter("name");
		double actualPrice = Double.parseDouble(request.getParameter("aprice"));
		double retailPrice = Double.parseDouble(request.getParameter("rprice"));
		float gstPercent = Float.parseFloat(request.getParameter("percent"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		boolean inStock = Boolean.parseBoolean(request.getParameter("inStock"));
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		
		
		Product product = new Product(0,productName,actualPrice,retailPrice,gstPercent,stock,uid,inStock);
		
		int result = Repository.getInstance().addProduct(product);
		if(result>0)
			response.getWriter().print("success");
		else 
			response.getWriter().print("failure");
		
	}
}
