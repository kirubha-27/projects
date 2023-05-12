package com.inventory.dto;

import java.time.LocalDate;

public class Bill {
	private int billId;
	private String customerName;
	private String address;
	private String phoneNumber;
	private LocalDate date;
	private int quantity;
	private int productId;
	private String productName;
	private double actPrice;
	private double retailPrice;
	private float gstPercent;

	
	
	
	
	
	
	
	public Bill(int billId, String customerName, String address, String phoneNumber, LocalDate date, int quantity,
			int productId, String productName, double actPrice, double retailPrice, float gstPercent) {
		super();
		this.billId = billId;
		this.customerName = customerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.quantity = quantity;
		this.productId = productId;
		this.productName = productName;
		this.actPrice = actPrice;
		this.retailPrice = retailPrice;
		this.gstPercent = gstPercent;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getActPrice() {
		return actPrice;
	}
	public void setActPrice(double actPrice) {
		this.actPrice = actPrice;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public float getGstPercent() {
		return gstPercent;
	}
	public void setGstPercent(float gstPercent) {
		this.gstPercent = gstPercent;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	
}
