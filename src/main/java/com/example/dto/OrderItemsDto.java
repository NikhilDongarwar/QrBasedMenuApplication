package com.example.dto;

public class OrderItemsDto {
	
	String name;
	int quantity;
	double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderItemsDto [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	

}
