package com.deadbeef.geomenu.htmlParsing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;







import java.util.Locale;

import android.content.Context;
import android.util.Log;

public class Category {
	
	private ArrayList<Entree> entrees;
	private String categoryName;
	private String restaurantName;
	private final String IFEATENLFILE = "IFEATENLFILE";
	private final String ISFAVORITELISTFILE = "ISFAVORITELISTFILE";
	
	private Context fileContext;
	
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
	
	private boolean isEaten(String restaurantName, String name)
	{	
		String itemName = restaurantName+=name;
		String str= "";
		
		try {
			FileInputStream fis = fileContext.openFileInput(IFEATENLFILE);
			byte[] buffer = new byte[(int) fis.getChannel().size()];
	        fis.read(buffer);
	        for(byte b:buffer) str+=(char)b;
	        fis.close();
	        Log.i("STACKOVERFLOW", String.format("GOT: [%s]", str));
	    } catch (IOException e) {
	        Log.e("STACKOVERFLOW", e.getMessage(), e);
	    }
		
		
		return str.toLowerCase(Locale.getDefault()).contains(itemName.toLowerCase(Locale.getDefault()));
	}
	
	private boolean isFavorite(String restaurantName, String name)
	{
		String itemName = restaurantName+=name;
		String str= "";
		
		try {
			FileInputStream fis = fileContext.openFileInput(ISFAVORITELISTFILE);
			byte[] buffer = new byte[(int) fis.getChannel().size()];
	        fis.read(buffer);
	        for(byte b:buffer) str+=(char)b;
	        fis.close();
	        Log.i("STACKOVERFLOW", String.format("GOT: [%s]", str));
	    } catch (IOException e) {
	        Log.e("STACKOVERFLOW", e.getMessage(), e);
	    }
		
		
		return str.toLowerCase(Locale.getDefault()).contains(itemName.toLowerCase(Locale.getDefault()));
	}
}
