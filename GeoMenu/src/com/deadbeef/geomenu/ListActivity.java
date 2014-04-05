package com.deadbeef.geomenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
 
public class ListActivity extends Activity {
 
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    ArrayList<View> liked;
    ArrayList<View> notliked;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_listmain);
 
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        liked = new ArrayList<View>();
        notliked = new ArrayList<View>();
        // preparing list data
        prepareListData(getIntent().getExtras().getString("item_id"));
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new OnChildClickListener() {
        	 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
                	if(!liked.contains(v)&&!notliked.contains(v))
                	{
                		v.setBackgroundColor(Color.GREEN);
                		liked.add(v);
        				
                	}
                	else if(!notliked.contains(v))
                	{
                		v.setBackgroundColor(Color.RED);
                		liked.remove(v);
                		notliked.add(v);
                	}
                	else
                	{
                		v.setBackgroundColor(Color.WHITE);
                		notliked.remove(v);
                	}
                return false;
            }
        });
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpTo(this, new Intent(this, MenuItemListActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
 
    /*
     * Preparing the list data
     */
    private void prepareListData(String key) {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        Integer newKey = Integer.parseInt(key);
        switch(newKey) {
        case 1:
        	
        	// Adding child data
            listDataHeader.add("Bar-B-Q Sandwhiches");
            listDataHeader.add("Dinners");
            listDataHeader.add("Family Pack");
            
            
        	List<String> bbqSandwhiches = new ArrayList<String>();
            bbqSandwhiches.add("Beef");
            bbqSandwhiches.add("Pork");
            bbqSandwhiches.add("Ham");
            bbqSandwhiches.add("Turkey");
            bbqSandwhiches.add("Combo");
             
            List<String> bbqDinners = new ArrayList<String>();
            bbqDinners.add("Sliced Beef");
            bbqDinners.add("Sliced Pork");
            bbqDinners.add("Sliced Ham");
            bbqDinners.add("Spare Ribs");
            bbqDinners.add("Two Meats");
            bbqDinners.add("Rib Tips");
            bbqDinners.add("Chicken");
     
            List<String> familyPack = new ArrayList<String>();
            familyPack.add("Spare Ribs");
            familyPack.add("Sliced Beef");
            familyPack.add("Sliced Pork");
            familyPack.add("Sliced Ham");
            
            listDataChild.put(listDataHeader.get(0), bbqSandwhiches); // Header, Child data
            listDataChild.put(listDataHeader.get(1), bbqDinners);
            listDataChild.put(listDataHeader.get(2), familyPack);
        break;
        case 2:
        	// Adding child data
            listDataHeader.add("Salads and Soups");
            listDataHeader.add("Specials");
            listDataHeader.add("Lunches");
     
            // Adding child data
            List<String> top250 = new ArrayList<String>();
            top250.add("Half Sandwich");
            top250.add("Salad Nicoise");
            top250.add("Printers Salad");
     
            List<String> nowShowing = new ArrayList<String>();
            nowShowing.add("Quiche");
            nowShowing.add("Pan Seared Salmon");
            nowShowing.add("B.L.T.");
     
            List<String> comingSoon = new ArrayList<String>();
            comingSoon.add("Ham Reuben");
            comingSoon.add("Maude's Burger");
            comingSoon.add("French Dip");
            
            listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
            listDataChild.put(listDataHeader.get(1), nowShowing);
            listDataChild.put(listDataHeader.get(2), comingSoon);
        break;
        case 3:
        	// Adding child data
            listDataHeader.add("Appetizers");
            listDataHeader.add("Soup and Salad");
            listDataHeader.add("Dessert ");
        	List<String> APPETIZERS = new ArrayList<String>();
            APPETIZERS.add("BRASILIAN FRIES");
            APPETIZERS.add("CHICKEN STRIPS (3) WITH FRIES");
            APPETIZERS.add("MOZZARELLA STICKS");
            APPETIZERS.add("CHEESE EMPANDADS (2)");
            APPETIZERS.add("CHEESE & JALAPENO CHICKEN");
            APPETIZERS.add("JALAPENO POPPERS");
     
            List<String> SALADSOUPS = new ArrayList<String>();
            SALADSOUPS.add("CHICKEN SALAD");
            SALADSOUPS.add("HEART OF ARTICHOKE SALAD");
            SALADSOUPS.add("SNIJED CGUCJEB SALAD SANDWICH");
            SALADSOUPS.add("BLACK BEAN SOUP / SOUP FO THE DAY");
     
            List<String> DESSERT = new ArrayList<String>();
            DESSERT.add("CHOCOLATE CONFUSION CAKE");
            DESSERT.add("NEW YORK CHEESECAKE");
            DESSERT.add("TIRAMISU");
     
            listDataChild.put(listDataHeader.get(0), APPETIZERS); // Header, Child data
            listDataChild.put(listDataHeader.get(1), SALADSOUPS);
            listDataChild.put(listDataHeader.get(2), DESSERT);
        	break;
        case 4:
        	// Adding child data
            listDataHeader.add("Drinks");
            listDataHeader.add("Starters");
            listDataHeader.add("Dinners");
            List<String> cafdrinks = new ArrayList<String>();
            cafdrinks.add("Water");
            cafdrinks.add("Coke");
            cafdrinks.add("Diet Coke");
            cafdrinks.add("Lemonade");
     
            List<String> cafstats = new ArrayList<String>();
            cafstats.add("Daily Bread");
            cafstats.add("Daily Soup");
     
            List<String> cafdinners = new ArrayList<String>();
            cafdinners.add("New York Strip");
            cafdinners.add("Grilled Salmon");
            cafdinners.add("Chicken Parmesan");
            listDataChild.put(listDataHeader.get(0), cafdrinks); // Header, Child data
            listDataChild.put(listDataHeader.get(1), cafstats);
            listDataChild.put(listDataHeader.get(2), cafdinners);
        	break;
        }
    }
}