package htmlParsing;

public class RestListItem{
		private String name;
		private String url;
		private String distance;
		private String address;
		private String category;
		
		protected RestListItem(String name, String url, String distance, String address, String category){
			this.name = name;
			this.url = url;
			this.distance = distance;
			this.address = address;
			this.category = category;
		}
		
		public String getName() {
			return name;
		}
		
		public String getURL() {
			return url;
		}
		
		public String getDistance() {
			return distance;
		}
		
		public String getAddress() {
			return address;
		}
		
		public String getCategory() {
			return category;
		}
	}