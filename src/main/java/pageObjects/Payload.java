package pageObjects;

public class Payload {

	
	public static String addBook(String isbn, String aisle) {
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}";
	}
}
