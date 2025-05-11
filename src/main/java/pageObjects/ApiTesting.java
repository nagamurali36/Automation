package pageObjects;
import io.restassured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class ApiTesting {
	static Response response = null;

	public static void main(String[] args) {

//		RestAssured.baseURI = "https://rahulshettyacademy.com";
//		
//		RequestSpecification request = RestAssured.given();
//		response = request.queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
//				+ "  \"location\": {\r\n"
//				+ "    \"lat\": -38.383494,\r\n"
//				+ "    \"lng\": 33.427362\r\n"
//				+ "  },\r\n"
//				+ "  \"accuracy\": 50,\r\n"
//				+ "  \"name\": \"Frontline house\",\r\n"
//				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
//				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
//				+ "  \"types\": [\r\n"
//				+ "    \"shoe park\",\r\n"
//				+ "    \"shop\"\r\n"
//				+ "  ],\r\n"
//				+ "  \"website\": \"http://google.com\",\r\n"
//				+ "  \"language\": \"French-IN\"\r\n"
//				+ "}\r\n"
//				+ "")
//				.when().post("maps/api/place/add/json");
////				.then().log().all().assertThat().statusCode(200)
////				.body("scope", equalTo("APP"));
//		System.out.println(response.getStatusCode());
//		System.out.println(response.asString());
//		String placeID = response.jsonPath().getString("place_id");
//		System.out.println("Place ID is : "+placeID);
////		System.out.println(response.getStatusLine());
//		
////		Get collection
//		response = request.queryParam("key", "qaclick123").queryParam("place_id", placeID).when().get("maps/api/place/get/json");
//		System.out.println(response.asString());
//		Assert.assertEquals("29, side layout, cohen 09",response.jsonPath().getString("address"), "Address Mismatch");
////		Assert.ass
//		System.out.println("SUccefully validated");
		
		
		
		
		JsonPath js = new JsonPath("");
		int courseCount = js.getInt("courses.size()");
		
		System.out.println(courseCount);
		
		int purchaseAmt = js.getInt("dashboard.purchaseAmount");
		
		System.out.println("Purchase Amount is :"+purchaseAmt);
		
		String firstTitle = js.getString("courses.title[0]");
		
		System.out.println("First Title "+firstTitle);
		
		
		for(int i=0;i<courseCount;i++) {
			System.out.println("Title of Course "+js.getString("courses.title["+i+"]"));
			System.out.println("Price of course "+js.getString("courses.price["+i+"]"));
		}
		
//		System.out.println(c);
		
		int noOfCopiesRPA = js.getInt("courses.copies[2]");
		System.out.println("No of RPA Copies "+noOfCopiesRPA);
		
		int totalCourseAmt =  0;
		for (int i=0;i<courseCount;i++) {
			int price = js.getInt("courses.price["+i+"]");
			int copies = js.getInt("courses.copies["+i+"]");
			int courseAmt = price*copies;
			totalCourseAmt = totalCourseAmt+courseAmt;
		}
		
		System.out.println(totalCourseAmt);
		Assert.assertEquals(purchaseAmt, totalCourseAmt,"Total Course Amount");
		
		
	}

}
