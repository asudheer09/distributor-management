package com.example.dsm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	private String state;
	private String pinCode;
	private String country;
	@Override
	public String toString() {
		return "Contact [id=" + id + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + ", country="
				+ country + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
