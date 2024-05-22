package APIautomation.APIautomation;

public class BasicInformation {
	
	private String firstname;
	private String lastname;
	private String id;
	private String designation;
	
    // Complex Json	
//	private AddressInformation address;
//		
//	public AddressInformation getAddress() {
//		return address;
//	}
//	public void setAddress(AddressInformation address) {
//		this.address = address;
//	}
	
	
	// Array 
	private AddressInformation[] address;
	public AddressInformation[] getAddress() {
		return address;
	}
	public void setAddress(AddressInformation[] address) {
		this.address = address;
	}
	
	
	// Simple JSON
	public String getFirstname() {
		return firstname;
	}	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
