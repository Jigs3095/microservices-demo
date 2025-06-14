package com.university.app.response;

import com.university.app.entity.Student;

public class StudentResponse {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private AddressResponse addressResponse;
	
	public AddressResponse getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressResponse addResponse) {
		this.addressResponse = addResponse;
	}

	public StudentResponse(Student st){
		this.id = st.getId();
		this.firstName = st.getFirstName();
		this.lastName =  st.getLastName();
		this.email = st.getEmail();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
