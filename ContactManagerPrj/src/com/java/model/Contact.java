package com.java.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Contact {

	private Integer id;
	
	@NotEmpty(message = " Name is required")
	private String name;
	
	@NotEmpty(message = " Email is required")
	@Email(message = " Invalid Email")
	private String email;
	
	@NotEmpty(message = " Address is required")
	private String address;
	
	@NotEmpty(message = " Phone number is required")
	@Size(min = 12, max = 12, message = " Size must be 12")
	private String phone;

	public Contact() {
	};

	public Contact(Integer id, String name, String email, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
