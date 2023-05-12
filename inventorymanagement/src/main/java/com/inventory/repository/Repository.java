package com.inventory.repository;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

import javax.servlet.annotation.WebServlet;

import com.inventory.dto.Bill;
import com.inventory.dto.Customer;
import com.inventory.dto.Product;
import com.inventory.dto.User;
import com.inventory.repository.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Repository {
	public static Repository repository;
	Connection con;
	Statement stmt = null;
	public static Repository getInstance(){
        if(repository==null){
            repository = new Repository();
           

        }
        return repository;
    }
	 private Repository(){
	        getConnection();
	 }
	 private void getConnection(){
		 try{
			 	Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_database","root","root");
	            stmt = con.createStatement();
	        }catch (SQLException | ClassNotFoundException e){
	            e.printStackTrace();
	        }
	    }
	 
	 
	//add product to the database
	 
	public int addProduct(Product product) {
		int stock = product.getStock();
		int instock = 0;
		if(stock>0) {
			instock =1;
		}
		try {
			//System.out.println("hi1");
			PreparedStatement ps = con.prepareStatement("insert into product (product_name,actual_price,retail_price,gst_percent,stock,user_id,in_stock) values (?,?,?,?,?,?,?);");
			ps.setString(1,product.getProductName());
			ps.setDouble(2, product.getActPrice());
			ps.setDouble(3, product.getRetailPrice());
			ps.setDouble(4, product.getGstPercent());
			ps.setInt(5, product.getStock());
			ps.setInt(6, product.getUserId());
			ps.setInt(7, instock);
			
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	// add user
	
	public void addUser(User user) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into user (user_name,email_id,phone_number,password,store_name) values (?,?,?,?,?);");
			ps.setString(1,user.getUserName());
			ps.setString(2, user.getEmailId());
			ps.setString(3, user.getPhoneNumber());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getStoreName());
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteProduct(int pid) {
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into product (in_stock) values (?);");
			ps.setInt(1,pid);
			
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void addCustomer(Customer customer) {
		try {
			java.sql.Date sqlDate = java.sql.Date.valueOf(customer.getDate());
			PreparedStatement ps = con.prepareStatement("insert into product (customer_name,address,phone_number,userId,date) values (?,?,?,?,?);");
			ps.setString(1,customer.getCustomerName());
			ps.setString(2, customer.getAddress());
			ps.setString(3, customer.getPhoneNumber());
			ps.setInt(4, customer.getUser_id());
			ps.setDate(5, sqlDate);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int getBillId() {
		try {
			PreparedStatement ps = con.prepareStatement("insert into product (select MAX(bill_number) from customer;");
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("bill_number");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<Product> getProductDetailsByProduct(int pid) {
		
		List<Product> products = new ArrayList<>();
			
			try {
				PreparedStatement ps=con.prepareStatement("select * from product where product_id=(?);");
				ps.setInt(1, pid);
				System.out.println(ps);
	            ResultSet rs=ps.executeQuery();  
	            
	            while(rs.next()) {
	            	int p_id = rs.getInt("product_id");
	            	String pname = rs.getString("product_name");
	            	double aprice = rs.getDouble("actual_price");
	            	double rprice = rs.getDouble("retail_price");
	            	float gpercent = rs.getFloat("gst_percent");
	            	int stock = rs.getInt("stock");
	            	int userid = rs.getInt("user_id");
	            	boolean inStock = rs.getBoolean("in_stock");
	            	
	            	products.add(new Product(p_id,pname,aprice,rprice,gpercent,stock,userid,inStock));
	            }
	            return products;
			}catch(SQLException e){
				e.printStackTrace();
			}
			return null;
		}
	public List<Product> getProductDetails(int uid) {
		
	List<Product> products = new ArrayList<>();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from product where user_id=(?) and in_stock=true;");
			ps.setInt(1, uid);
            ResultSet rs=ps.executeQuery();  
            
            while(rs.next()) {
            	int pid = rs.getInt("product_id");
            	String pname = rs.getString("product_name");
            	double aprice = rs.getDouble("actual_price");
            	double rprice = rs.getDouble("retail_price");
            	float gpercent = rs.getFloat("gst_percent");
            	int stock = rs.getInt("stock");
            	int userid = rs.getInt("user_id");
            	boolean inStock = rs.getBoolean("in_stock");
            	
            	products.add(new Product(pid,pname,aprice,rprice,gpercent,stock,userid,inStock));
            }
            return products;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	public List<Product> getProductDetails(String name) {
		List<Product> products = new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from product where product like %(?)% and in_stock=1 limit 5;");
			ps.setString(1, name);
            ResultSet rs=ps.executeQuery();  
            
            while(rs.next()) {
            	int pid = rs.getInt("p_id");
            	String pname = rs.getString("product_name");
            	double aprice = rs.getDouble("actual_price");
            	double rprice = rs.getDouble("retail_price");
            	float gpercent = rs.getFloat("gst_percent");
            	int stock = rs.getInt("stock");
            	int userid = rs.getInt("user_id");
            	boolean inStock = rs.getBoolean("in_stock");
            	
            	products.add(new Product(pid,pname,aprice,rprice,gpercent,stock,userid,inStock));
            }
            return products;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	public int updateRow(Product p) {
		try {
			PreparedStatement ps = con.prepareStatement("update product set product_name=(?),actual_price=(?),retail_price=(?),gst_percent=(?),stock=(?),user_id=(?),in_stock=(?) where product_id=(?);");
			ps.setString(1, p.getProductName());
			ps.setDouble(2, p.getActPrice());
			ps.setDouble(3,p.getRetailPrice());
			
			ps.setDouble(4, p.getGstPercent());
			ps.setInt(5, p.getStock());
			ps.setInt(6, p.getUserId());
			ps.setInt(8, p.getProductId());
			if(p.getStock()>0) {
				ps.setBoolean(7, true);
			}else {
				ps.setBoolean(7, false);
			}
			
			return ps.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	public List<Bill> getBillDetails(int uid, String startDate, String endDate) {
		List<Bill> bills = new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT c.customer_name, c.address, c.phone_number,p.product_id,p.product_name, p.actual_price, p.retail_price, p.gst_percent, b.quantity, b.bill_number, c.date FROM customer c JOIN bills b ON c.bill_number = b.bill_number JOIN product p ON p.product_id = b.product_id WHERE b.user_id = (?) AND c.date BETWEEN (?) AND (?);");
			ps.setInt(1, uid);
			ps.setString(2, String.valueOf(startDate));
			ps.setString(3, String.valueOf(endDate));
			
			System.out.println(ps.toString());
			
            ResultSet rs=ps.executeQuery();  
            
            
            
            while(rs.next()) {
            	int pid = rs.getInt("product_id");
            	String pname = rs.getString("product_name");
            	double aprice = rs.getDouble("actual_price");
            	double rprice = rs.getDouble("retail_price");
            	float gpercent = rs.getFloat("gst_percent");
            	
            	int quantity = rs.getInt("quantity");
            	
            	
            	int bid = rs.getInt("bill_number");
            	String customerName = rs.getString("customer_name");
            	String address = rs.getString("address");
            	String phone = rs.getString("phone_number");
            	LocalDate date = LocalDate.parse(String.valueOf(rs.getDate("date")));
            			
            	
            	bills.add(new Bill(bid,customerName,address,phone,date,quantity,pid,pname,aprice,rprice,gpercent));
            }
            return bills;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	public User getByEmail(String email, String pass) {
		
		User user = new User();
		try {
			PreparedStatement ps = con.prepareStatement("select user_id,user_name,email_id,phone_number,password,store_name from user where email_id = (?) and password = (?)");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){  
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				
				user.setEmailId(rs.getString(3));
				user.setPhoneNumber(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setStoreName(rs.getString(6));
                
            }  
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
