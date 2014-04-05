package com.deadbeef.geomenu.htmlParsing;

import java.util.ArrayList;

public class Category {
	
	private ArrayList<Entree> entrees;
	private String categoryName;
	private String restaurantName;
	
	protected Category(String categoryName, String restaurantName) {
		this.categoryName = categoryName;
		this.restaurantName = restaurantName;
		entrees = new ArrayList<Entree>();
	}
	
	private void addEntree(String name, String description) {
		boolean eaten = isEaten(restaurantName, name);
		boolean favorite = isFavorite(restaurantName, name);
		Entree entree = new Entree(name, description, eaten, favorite);
		entrees.add(entree);
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public ArrayList<Entree> getEntrees() {
		return entrees;
	}
}
