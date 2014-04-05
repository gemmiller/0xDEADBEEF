package com.deadbeef.geomenu.htmlParsing;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.os.AsyncTask;

public class fetcher extends AsyncTask<String, String, Void> {
	
	//private variables
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
}
