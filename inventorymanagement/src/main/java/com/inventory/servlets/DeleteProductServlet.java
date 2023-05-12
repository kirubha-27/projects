package com.inventory.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventory.dto.User;
import com.inventory.repository.Repository;
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res) {
		int pid = Integer.parseInt("pid");
		
		Repository.getInstance().deleteProduct(pid);
		
	}
}
