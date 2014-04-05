package com.deadbeef.geomenu.htmlParsing;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.AsyncTask;

public class fetcher extends AsyncTask<String, String, Void> {
	
	//private variables
	Document doc = null;
	private ArrayList<RestListItem> restaurants;

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
	
	protected ArrayList<RestListItem> getRestaurants() {
		return restaurants;
	}
	
	protected void parseRestaurantList() {
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
}
