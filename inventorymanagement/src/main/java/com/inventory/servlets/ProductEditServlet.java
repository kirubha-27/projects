package com.inventory.servlets;

import com.inventory.dto.*;
import com.inventory.repository.Repository;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
@WebServlet("/ProductEditServlet")
public class ProductEditServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("productId"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("reprice"));
		System.out.println(request.getParameter("actPrice"));
		System.out.println(request.getParameter("percent"));
		System.out.println(request.getParameter("stock"));
		int pid = Integer.parseInt(request.getParameter("productId"));
		String name = request.getParameter("name");
		double rprice = Double.parseDouble(request.getParameter("reprice"));
		double aprice = Double.parseDouble(request.getParameter("actPrice"));
		
		float gpercent = Float.parseFloat(request.getParameter("percent"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		boolean inStock = Boolean.parseBoolean(request.getParameter("inStock"));
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("uid");
		
		
		Product product = new Product(pid,name,rprice,aprice,gpercent,stock,userId,inStock);
		
		int result = Repository.getInstance().updateRow(product);
		
		if(result>0) {
			List<Product> products = Repository.getInstance().getProductDetails(userId);
			JSONArray arr = new JSONArray();
			
			for(int i=0;i<products.size();i++) {
				JSONObject obj = new JSONObject();
				obj.put("pid",products.get(i).getProductId());
				obj.put("name", products.get(i).getProductName());
				obj.put("aprice",products.get(i).getActPrice());
				obj.put("rprice",products.get(i).getRetailPrice());
				obj.put("gpercent",products.get(i).getGstPercent());
				obj.put("stock",products.get(i).getStock());
				obj.put("userid",products.get(i).getUserId());
				
				arr.add(obj);
			}
			
			response.getWriter().print(arr);
		}
		else
			response.getWriter().print("failure");
		
	}
}
