package pageObjects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class LibraryApi {

	public LibraryApi(){
		
		RestAssured.baseURI= "http://216.10.245.166";
	}
	
	public String id;
	@Test(dataProvider="BookData")
	public void addBook(String isbn, String aisle) {
		String response = given().header("Content-Type","application/json").body(Payload.addBook(isbn,aisle)).when().post("/Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		System.out.println(js.getString("Msg"));
		id = js.getString("ID");
		System.out.println(id);
	}
	
	@DataProvider(name = "BookData")
	public Object[][] getData(){
		return new Object[][] {{"Naga","9705"},{"Murali","438932"}};
	}
	
	
	
//	@Test
//	public void getBook(String id) {
//	this.id=id;
//		String response = given().queryParam("AuthorName", "John foe").get("/Library/GetBook.php").then().assertThat().statusCode(200)
//				.extract().response().asString();
//		System.out.println(response);
//		JsonPath js = new JsonPath(response);
//		js.getString("response.Name");
//	}
	@Test
	public void deleteBook() {
		System.out.println(id);
		String response = given().header("Content-Type","application/json").body("{\"ID\":\""+id+"\"}").when().post("/Library/DeleteBook.php").then().assertThat().statusCode(200).
				extract().response().asString();
		JsonPath js = new JsonPath(response);
		System.out.println(js.getString("msg"));
	}

}
