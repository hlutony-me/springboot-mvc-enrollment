package com.spring.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name="user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
	private String password;
	private String firstName;

	private String lastName;

	private String address;

	private String city;

	private String postalCode;


	public User(Long id, String userName, String password, String firstname, String lastname, String address, String city, String postalCode) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstname;
		this.lastName = lastname;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
	}
	public User(){

	}

	public User(String userName, String password, String firstname, String lastname, String address, String city, String postalCode) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstname;
		this.lastName = lastname;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getPassword() {
		return password;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
