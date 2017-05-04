package Serializables;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import connection.ConnectionManager;


public class CustomerObject implements Serializable {

	private static final long serialVersionUID = -5577579081118070434L;

	private int customer_id;
	private String salutation;
	private String firstname;
	private String lastname;
	private String company;
	private String country;
	private String province;
	private String city;
	private String street;
	private String streetNo;
	private String zip;
	private String email;
	private String pwd;
	
	
	public CustomerObject(int customer_id, String salutation, String name,
			String surname, String country, String province,
			String city, String street, String streetNo, String zip, String email, String pwd) {
		this.customer_id = customer_id;
		this.firstname = name;
		this.lastname = surname;
		this.salutation = salutation;
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.streetNo = streetNo;
		this.zip = zip;
		this.email = email;
		this.pwd = pwd;
	}

	public int getId() {
		return customer_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getSalutation() {
		return salutation;
	}

	public String getTitle() {
		return email;
	}

	public String getCompany() {
		return company;
	}

	public String getCountry() {
		return country;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public String getZip() {
		return zip;
	}

	@Override
	public String toString() {
		return "Customer: " + salutation + ", " + email + ", " + firstname +
				", " + lastname + ", " + country + ", " +
				province + ", " + city + ", " + street + ", " + streetNo +
				", " + zip;
	}
}
