package com.deadbeef.geomenu.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Battle's Bar-B-Q", "(515) 292-1670", "218 Welch Ave, Ames IA 50014 "));
        addItem(new DummyItem("2", "Aunt Maude's", "(515) 233-4136", "547 Main St, Ames IA 50010 "));
        addItem(new DummyItem("3", "Cafe Beaudelaire","(515) 292-7429", "2504 E Lincoln Way, Ames IA 50010"));
        addItem(new DummyItem("4", "The Cafe", "(515) 292-0100", "2616 Northridge Parkway, Ames IA 50010"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;
        public String phone;
        
        public String address;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }
        
        public DummyItem(String id, String content, String phone, String address) {
            this.id = id;
            this.content = content;
            this.phone = phone;
            
            this.address = address;
        }

        @Override
        public String toString() {
        	if(phone != null){
            return content +"\n" + phone + "\n" + address;
        	}
        	else{
        		return content;
        	}
        }
    }
}
