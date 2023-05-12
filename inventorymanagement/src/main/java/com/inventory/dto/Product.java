package com.inventory.dto;

public class Product {
	private int productId;
	private String productName;
	private double actPrice;
	private double retailPrice;
	private float gstPercent;
	private int stock;
	private int userId;
	private boolean inStock;
	
	

	public Product(int productId, String productName, double actPrice, double retailPrice, float gstPercent, int stock,
			int userId, boolean inStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.actPrice = actPrice;
		this.retailPrice = retailPrice;
		this.gstPercent = gstPercent;
		this.stock = stock;
		this.userId = userId;
		this.inStock = inStock;
	}

	public boolean getInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", actPrice=" + actPrice
				+ ", retailPrice=" + retailPrice + ", gstPercent=" + gstPercent + ", stock=" + stock + ", userId="
				+ userId + "]";
	}
	
}
