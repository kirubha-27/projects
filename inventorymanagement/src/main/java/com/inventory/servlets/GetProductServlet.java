package com.inventory.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.inventory.dto.Product;
import com.inventory.repository.Repository;

@WebServlet("/getProductServlet")
public class GetProductServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
//		System.out.println("from servlet");
//		if(type.equals("byNameProduct")) {
//			String name = req.getParameter("name");
//			
//			List<Product> products = Repository.getInstance().getProductDetails(name);
//			
//			JSONArray arr = new JSONArray();
//			
//			for(int i=0;i<products.size();i++) {
//				JSONObject obj = new JSONObject();
//				obj.put("pid",products.get(i).getProductId());
//				obj.put("name", products.get(i).getProductName());
//				obj.put("aprice",products.get(i).getActPrice());
//				obj.put("rprice",products.get(i).getRetailPrice());
//				obj.put("gpercent",products.get(i).getGstPercent());
//				obj.put("stock",products.get(i).getStock());
//				obj.put("userid",products.get(i).getUserId());
//				
//				arr.add(obj);
//			}
//			res.getWriter().print(arr);
//		}else if(type.equals("byName")) {
//			String name = req.getParameter("name");
//			
//			List<Product> products = Repository.getInstance().getProductDetails(name);
//			
//			JSONArray arr = new JSONArray();
//			
//			for(int i=0;i<products.size();i++) {
//				JSONObject obj = new JSONObject();
//				obj.put("pid",products.get(i).getProductId());
//				obj.put("name", products.get(i).getProductName());
//				obj.put("aprice",products.get(i).getActPrice());
//				obj.put("rprice",products.get(i).getRetailPrice());
//				obj.put("gpercent",products.get(i).getGstPercent());
//				obj.put("stock",products.get(i).getStock());
//				obj.put("userid",products.get(i).getUserId());
//				
//				arr.add(obj);
//			}
//			res.getWriter().print(arr);
//		}else 
//		if(type.equals("byId")) {
		HttpSession session = req.getSession();
		int uid = (int)session.getAttribute("uid");
			System.out.println("hello");
			List<Product> products = Repository.getInstance().getProductDetails(uid);
			
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
			System.out.println("suer");
			
		
			res.getWriter().print(arr);
		}
			
//	}
}
