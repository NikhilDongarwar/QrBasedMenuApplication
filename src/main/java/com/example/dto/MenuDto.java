package com.example.dto;

public class MenuDto {
	 private String name;

	    private String description;

	    private double price;

	    private String category; // e.g., Breakfast, Lunch, Dinner
         
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		@Override
		public String toString() {
			return "MenuDto [name=" + name + ", description=" + description + ", price=" + price + ", category="
					+ category + "]";
		}


}
