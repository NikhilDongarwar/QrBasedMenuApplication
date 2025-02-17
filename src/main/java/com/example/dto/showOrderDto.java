package com.example.dto;

import java.util.List;

public class showOrderDto{
	
	public Long orderId;
	public String orderDate;
	public double totalAmount;
	
	public List<OrderItemsDto> orderitems;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public List<OrderItemsDto> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<OrderItemsDto> orderitems) {
		this.orderitems = orderitems;
	}

	@Override
	public String toString() {
		return "showOrderDto [orderId=" + orderId + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount
				+ ", orderitems=" + orderitems + "]";
	}
	
	
	
	
}