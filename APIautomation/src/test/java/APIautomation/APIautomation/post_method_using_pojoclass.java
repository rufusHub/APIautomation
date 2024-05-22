package APIautomation.APIautomation;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class post_method_using_pojoclass {

	public static void main(String[] args) {
		
		// Complex Json
//		AddressInformation address = new AddressInformation();
//		address.setHouseNo("398");
//		address.setType("Primary");
//		address.setType("12");

		// Array
		AddressInformation[] address = new AddressInformation[2];
		address[0] = new AddressInformation();
		address[0].setHouseNo("388");
		address[0].setType("Primary");
		address[0].setWardNo("14");
		address[1] = new AddressInformation();
		address[1].setHouseNo("388");
		address[1].setType("Secondary");
		address[1].setWardNo("14");

		// Simple Json
		BasicInformation basic = new BasicInformation();
		basic.setFirstname("Joselu");
		basic.setLastname("Perez");
		basic.setId("51413380");
		basic.setDesignation("Data Enginner");
		
		// Array 
		basic.setAddress(address);
		
		// Complex Json
//		basic.setAddress(address);		
		
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(basic)
		.when()
		.post("http://localhost:3000/APIBatchStudents");
		
		System.out.println("Status code is: " + res.statusCode());
		System.out.println("Response is: ");
		System.out.println(res.asString());
	}
	
	// Complex Json
	
	
	
	
}
