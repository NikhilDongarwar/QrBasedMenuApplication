package com.example.dto;

import java.util.List;

import com.example.entity.CartEntry;


public class OrderFormDto {
	
   private String roomId;
	private double totalAmount;
    private String status;
    private String orderDate;
    private List<CartEntryDTO> cartEntries;
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
    public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
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
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	@Override
	public String toString() {
		return "OrderFormDto [roomId=" + roomId + ", totalAmount=" + totalAmount + ", status=" + status + ", orderDate="
				+ orderDate + ", cartEntries=" + cartEntries + "]";
	}
	
	
}