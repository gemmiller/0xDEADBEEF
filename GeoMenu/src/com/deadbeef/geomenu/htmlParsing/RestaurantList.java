package com.deadbeef.geomenu.htmlParsing;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.AsyncTask;


public class RestaurantList {
	
	private Document doc;
	private ArrayList<RestListItem> restaurants;
	
	//Goes to the default page, which is no filters and sorting by distance
	public RestaurantList(String latitude, String longitude){	
		
		//Opens webpage and parses
		fetcher temp = new fetcher();
		temp.execute("http://www.allmenus.com/custom-results/lat/" + latitude + "/long/" + longitude + "/&filters=none?sort=distance&");
		//restaurants = temp.getRestaurants();
	}
	
	private void populateRestaurants() {
		String baseURL = "http://www.allmenus.com";
		
		//Gets a list of all restaurants as elements
		Elements restHTML = doc.getElementsByTag("D1").get(0).children();
		
		//Each restaurant is comprised of two elements
		Element restParse1;
		Element restParse2;
		
		for(int i = 0; i < restHTML.size(); i = i+2) {
			restParse1 = restHTML.get(i);
			restParse2 = restHTML.get(i+1);
			
			String name = restParse1.text();
			String url = baseURL + restParse1.attr("href");
			String distance = restParse1.attr("p");
			String address = restParse2.text();
			String category = restParse2.attr("br");
			
			RestListItem temp = new RestListItem(name,url,distance,address,category);
			restaurants.add(temp);
		}
	}
	
	private ArrayList<RestListItem> getrestaurants() {
		return restaurants;
	}
	
	/*
	private Menu getRestaurantMenu(int selection) {
		Document menu;
		
		//Opens restaraunt page
		try {
			menu = Jsoup.connect(restaurants.get(selection).getURL()).get();
		} catch (IOException e) {
			System.out.println("There was an error while getting the menu.");
			e.printStackTrace();//???
		}
		
		//PARSEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
		Menu temp;
		
		//Gets the categories
		Elements categories = menu.getElementsByClass("category");
		for(Element currentCat : categories){
			String catName = currentCat.getElementsByTag("h3").toString();
			
			
			//Goes through the entrees of the category
			Elements entrees = cat.getElementsByTag("d1");
			String entName;
			String entDesc;
			for(int i = 0; i < entrees.size(); i = i+2){
				entName = entrees.get(i).getElementsByTag("dt").toString();
				entDesc = entrees.get(i+1).getElementsByTag("dd").toString();
				Entree entree = new Entree(entName, entDesc, 0, false);
				
			}
			
				Entree entree = new Entree(entName, entDesc, 0, false);
			}
		}
		return temp = new Menu();
		return null;
	}*/
	
	public class fetcher extends AsyncTask<String, String, Void> {
		
		protected void onPostExecute(Void result) {
		
		}
		
		protected Void doInBackground(String... params) {
			Document doc = null;
			try {
				doc = Jsoup.connect(params.toString()).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
}
