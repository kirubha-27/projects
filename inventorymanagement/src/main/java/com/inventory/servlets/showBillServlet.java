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

import com.inventory.dto.Bill;
import com.inventory.dto.Product;
import com.inventory.repository.Repository;
@WebServlet("/showBillServlet")
public class showBillServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		HttpSession session = request.getSession();
//		int uid = (int)session.getAttribute("uid");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int uid = 1;
		
				
		//System.out.println(session);
		System.out.println(uid);
		System.out.println(startDate);
		System.out.println(endDate);
		List<Bill> bills = Repository.getInstance().getBillDetails(uid,startDate,endDate);
		
		JSONArray arr = new JSONArray();
		
		for(int i=0;i<bills.size();i++) {
			JSONObject obj = new JSONObject();
			obj.put("pid",bills.get(i).getProductId()+"");
			obj.put("name", bills.get(i).getProductName()+"");
			obj.put("aprice",bills.get(i).getActPrice()+"");
			obj.put("rprice",bills.get(i).getRetailPrice()+"");
			obj.put("gpercent",bills.get(i).getGstPercent()+"");
			obj.put("quantity", bills.get(i).getQuantity()+"");
			obj.put("billNumber", bills.get(i).getBillId()+"");
			obj.put("customerName",bills.get(i).getCustomerName()+"");
			obj.put("address", bills.get(i).getAddress()+"");
			obj.put("phoneNumber", bills.get(i).getPhoneNumber()+"");
			obj.put("date", bills.get(i).getDate()+"");
			
			System.out.println("hi");
			arr.add(obj);
		}
		//System.out.println();
		
		
		response.getWriter().print(arr);
	}
}
