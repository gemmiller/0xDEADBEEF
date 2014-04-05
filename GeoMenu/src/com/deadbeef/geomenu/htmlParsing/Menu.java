package com.deadbeef.geomenu.htmlParsing;

import java.util.ArrayList;

public class Menu {
	
	private ArrayList<Category> categories;
	private String restaurantName;
	
	protected Menu(String restaurantName) {
		this.restaurantName = restaurantName;
		categories = new ArrayList<Category>();
	}
	
	private void addCategory(String categoryName) {
		Category cat = new Category(categoryName, restaurantName);
		categories.add(cat);
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	
	public ArrayList<Category> getCategories() {
		return categories;
	}
	
	
}
