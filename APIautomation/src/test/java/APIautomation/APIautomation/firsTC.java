package APIautomation.APIautomation;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class firsTC {
	public static void main(String[] args) {
		
		Response res =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APIBatchStudents");
		
//		System.out.println("Status code is " + res.statusCode());
//		System.out.println("Response data is: ");
//		System.out.println(res.asString());
//		
		// Parsing
		JSONArray js = new JSONArray(res.asString());
		int L = js.length();
//		System.out.println(L);
		
		System.out.println(js);	//prints out the complete array.
		
		// prints 'id' from object 0
		JSONObject j = js.getJSONObject(0);
		System.out.println(j.get("id"));
		
		// print 'id' for all objects in the array.
		for(int i=0; i<L; ++i) {
			JSONObject k = js.getJSONObject(i);
			System.out.println(k.get("id"));
		}
		
		// print 'keys'
		JSONObject a = js.getJSONObject(1);
		Set <String> allkeys = a.keySet();
		System.out.println(allkeys);
		
		
		// taking key:value one by one
		for (int i=0; i<L; ++i) {
			JSONObject h = js.getJSONObject(i);
			Set <String> allkeys2 = h.keySet();
			for (String key: allkeys2) {
				System.out.println("Key name is: " + key);
				System.out.println("Value is: " + h.get(key));
			}
		}
		
		// take data from: array - object - array - object
		JSONArray js2 = new JSONArray(res.asString());
		JSONObject j2 = js2.getJSONObject(9);
		JSONArray js3 = j2.getJSONArray("address");
		JSONObject j3 = js3.getJSONObject(0);
		System.out.println(j3);
		
	}
}
