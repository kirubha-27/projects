package com.inventory.dto;

import java.time.LocalDate;

public class Customer {
	private int billId;
	private String customerName;
	private String address;
	private String phoneNumber;
	private int user_id;
	private LocalDate date;
	
	
	
	
	public Customer(int billId, String customerName, String address, String phoneNumber, int user_id, LocalDate date) {
		super();
		this.billId = billId;
		this.customerName = customerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.user_id = user_id;
		this.date = date;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Customer [billId=" + billId + ", customerName=" + customerName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", user_id=" + user_id + ", date=" + date + "]";
	}
	
	
	
	
	
	
}
