package com.example.dto;

import java.util.List;

import com.example.entity.CartEntry;


public class OrderFormDto {
	
   
	private double totalAmount;
    private String status;
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String orderDate;
    public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	private List<CartEntryDTO> cartEntries;
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<CartEntryDTO> getCartEntries() {
		return cartEntries;
	}
	public void setCartEntries(List<CartEntryDTO> cartEntries) {
		this.cartEntries = cartEntries;
	}
	@Override
	public String toString() {
		return "OrderForm [totalAmount=" + totalAmount + ", status=" + status + ", orderDate="
				+ orderDate + ", cartEntries=" + cartEntries + "]";
	}
	
	
    // Getters and setters
}