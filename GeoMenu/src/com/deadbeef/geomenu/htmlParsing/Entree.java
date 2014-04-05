package com.deadbeef.geomenu.htmlParsing;

public class Entree {
	
	private String name;
	private String description;
	private boolean eaten;
	private boolean favorite;
	
	protected Entree(String name, String description, boolean eaten, boolean favorite) {
		this.name = name;
		this.description = description;
		this.eaten = eaten;
		this.favorite = favorite;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean getEaten() {
		return eaten;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setEaten(boolean eaten) {
		this.eaten = eaten;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
}
