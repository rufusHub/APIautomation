package APIautomation.APIautomation;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class post_method_using_orgJson {
	
	public static void main(String[] args) {
		
		// ************
		// simple JSON
		// ************
		JSONObject js = new JSONObject();
		js.put("firstName","Alicia");
		js.put("lastName","Caro");
		js.put("Designation","Mom");
		js.put("id","09682475");
		js.put("Location","PE");
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(js.toString())
		.when()
		.post("http://localhost:3000/APIBatchStudents");
		 System.out.println("status code is: " + res.statusCode());
	
		 
		// ************
		// complex JSON
		// ************
		JSONObject inner = new JSONObject();
		inner.put("houseNo", "385");
		inner.put("Sector", "301-B");
		inner.put("Type", "Primary Address");
		
		JSONObject outer = new JSONObject();
		outer.put("firstName","Alicia");
		outer.put("lastName","Caro");
		outer.put("Designation","Mom");
		outer.put("id","09682479");
		outer.put("Location","PE");
		outer.put("Address", inner);
		
		Response res2=
		given()
		.contentType(ContentType.JSON)
		.body(outer.toString())
		.when()
		.post("http://localhost:3000/APIBatchStudents");
		System.out.println("status code is: " + res2.statusCode());
		System.out.println("Response data is: ");
		System.out.println(res2.asString());
		
		
		// ************
		// Array
		// ************
		JSONObject inner1 = new JSONObject();
		inner1.put("houseNo", "295");
		inner1.put("Sector", "201-C");
		inner1.put("Type", "Primary Address");
		
		JSONObject inner2 = new JSONObject();
		inner2.put("houseNo", "175");
		inner2.put("Sector", "101-A");
		inner2.put("Type", "Primary Address");
		
		JSONArray array = new JSONArray();
		array.put(0, inner1);
		array.put(1, inner2);
		
		JSONObject outer1 = new JSONObject();
		outer1.put("firstName","Meche");
		outer1.put("lastName","Zapata");
		outer1.put("Designation","Nurse");
		outer1.put("id","38682479");
		outer1.put("Location","UK");
		outer1.put("Address", array);
		
		Response res3=
		given()
		.contentType(ContentType.JSON)
		.body(outer1.toString())
		.when()
		.post("http://localhost:3000/APIBatchStudents");
		System.out.println("status code is: " + res3.statusCode());
		System.out.println("Response data is: ");
		System.out.println(res3.asString());
	}
}
