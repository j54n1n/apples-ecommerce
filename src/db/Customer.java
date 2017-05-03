package db;

import java.sql.*;
import java.util.ArrayList;

import connection.ConnectionManager;


public class Customer {

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

	private Customer(int customer_id, String salutation, String name,
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
	
	public Customer modify(String salutation, String name,
			String surname, String country, String province,
			String city, String street,	String streetNo, String zip, String email, String pwd){
		Customer customer = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE customer SET salutation = ? , firstname = ? , lastname = ? , " +
							"country = ? , province = ? , city = ?, email = ? , " +
							"\"streetNo\" = ? , zip = ?, email = ? , pwd = ?"+
							"WHERE address_id = "+this.customer_id+
							"RETURNING address_id;");
			preparedStatement.setString(1, salutation);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, surname);
			preparedStatement.setString(4, country);
			preparedStatement.setString(5, province);
			preparedStatement.setString(6, city);
			preparedStatement.setString(7, street);
			preparedStatement.setString(8, streetNo);
			preparedStatement.setString(9, zip);
			preparedStatement.setString(10, email);
			preparedStatement.setString(11, pwd);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customer = new Customer(resultSet.getInt(1),salutation,name,surname,country,province,
						city,street,street,zip,email,pwd
						);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return customer;
	}	
	
	public boolean delete(){
		boolean success = false;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE customer_id = "+this.customer_id+";");		
			if(preparedStatement.executeUpdate() > 0){
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}		
		return success;
	}

	public static Customer create(String salutation, String name,
			String surename, String country, String province,
			String city, String street,	String streetNo, String zip, int customer_id,
			String email, String pwd
			) {
		Customer customer = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(
					"INSERT INTO customer (salutation, firstname, lastname, " +
							"country, province, city, street, " +
							"street_no, zip, email, zip) " +
							"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
					"RETURNING customer_id");
			preparedStatement.setString(1, salutation);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, surename);
			preparedStatement.setString(4, country);
			preparedStatement.setString(5, province);
			preparedStatement.setString(6, city);
			preparedStatement.setString(7, street);
			preparedStatement.setString(8, streetNo);
			preparedStatement.setString(9, zip);
			preparedStatement.setString(10, email);
			preparedStatement.setString(11, pwd);
			// Retrieve the result of RETURNING statement to get the current id.
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {				
				customer = new Customer(resultSet.getInt(1), salutation,
						name, surename, country, province, city,
						street, streetNo, zip,email,pwd);
				if(preparedStatement.executeUpdate() > 0){
					connection.commit();					
				}else{
					connection.rollback();
					return null;
				}			
			}else {
				connection.rollback();
				return null;
			}
			preparedStatement.close();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return customer;
	}

	public static Customer find(int id) {
		Customer customer = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM customer WHERE customer_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer = new Customer(id, resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(1),
						resultSet.getString(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getString(7),
						resultSet.getString(8), resultSet.getString(9),
						resultSet.getString(10), resultSet.getString(11));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return customer;
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