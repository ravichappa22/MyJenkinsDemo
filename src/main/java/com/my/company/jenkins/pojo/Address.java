package com.my.company.jenkins.pojo;

public class Address {
	
	private String addressOne;
	private String city;
	private String state;
	private String country;
	
	public Address(String addressOne, String city, String state, String country) {
		super();
		this.addressOne = addressOne;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String getAddressOne() {
		return addressOne;
	}
	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
