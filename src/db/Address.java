package db;

import java.sql.*;
import java.util.ArrayList;

import connection.ConnectionManager;


public class Address {

	private int address_id;
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
	private String title;

	private Address(int id, String salutation, String title, String name,
			String surname, String company, String country, String province,
			String city, String street, String streetNo, String zip) {
		this.address_id = id;
		this.firstname = name;
		this.lastname = surname;
		this.salutation = salutation;
		this.title = title;
		this.company = company;
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.streetNo = streetNo;
		this.zip = zip;
	}
	
	public Address modify(String salutation, String title, String name,
			String surname, String company, String country, String province,
			String city, String street,	String streetNo, String zip){
		Address address = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE address SET salutation = ? , firstname = ? , lastname = ? , " +
							"company = ? , country = ? , province = ? , city = ?, street = ? , " +
							"\"streetNo\" = ? , zip = ?, title = ? "+
							"WHERE address_id = "+this.address_id+
							"RETURNING address_id;");
			preparedStatement.setString(1, salutation);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, surname);
			preparedStatement.setString(4, company);
			preparedStatement.setString(5, country);
			preparedStatement.setString(6, province);
			preparedStatement.setString(7, city);
			preparedStatement.setString(8, street);
			preparedStatement.setString(9, streetNo);
			preparedStatement.setString(10, zip);
			preparedStatement.setString(11, title);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				address = new Address(resultSet.getInt(1), salutation, title,
						name, surname, company, country, province, city,
						street, streetNo, zip);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return address;
	}	
	
	public boolean delete(){
		boolean success = false;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM address WHERE address_id = "+this.address_id+";");		
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

	public static Address create(String salutation,	String title, String name,
			String surename, String company, String country, String province,
			String city, String street,	String streetNo, String zip, int customer_id) {
		Address address = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(
					"INSERT INTO address (salutation, firstname, lastname, " +
							"company, country, province, city, street, " +
							"\"streetNo\", zip, title) " +
							"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
					"RETURNING address_id");
			preparedStatement.setString(1, salutation);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, surename);
			preparedStatement.setString(4, company);
			preparedStatement.setString(5, country);
			preparedStatement.setString(6, province);
			preparedStatement.setString(7, city);
			preparedStatement.setString(8, street);
			preparedStatement.setString(9, streetNo);
			preparedStatement.setString(10, zip);
			preparedStatement.setString(11, title);
			// Retrieve the result of RETURNING statement to get the current id.
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				address = new Address(resultSet.getInt(1), salutation, title,
						name, surename, company, country, province, city,
						street, streetNo, zip);
				preparedStatement = connection.prepareStatement(
						"INSERT INTO has_address(address_id, client_id)"+
						"VALUES ( "+address.getId()+", "+customer_id+");");
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
		return address;
	}

	public static Address[] findByClient(int client_id) {
		ArrayList<Address> addresses = new ArrayList<Address>();
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement("SELECT address.address_id, " +
					"address.salutation, address.firstname, address.lastname, " +
					"address.company, address.country, address.province, address.city, "+
					"address.street, address.\"streetNo\", address.zip, address.title "+
					"FROM address, client, has_address	"+
					"WHERE address.address_id = has_address.address_id "+
					"AND has_address.client_id = client.customer_id AND client.customer_id = ?");
			preparedStatement.setInt(1, client_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				addresses.add(new Address(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(12), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getString(7),
						resultSet.getString(8), resultSet.getString(9),
						resultSet.getString(10), resultSet.getString(11)));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return (Address[])addresses.toArray(new Address[addresses.size()]);
	}

	public static Address find(int id) {
		Address address = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM address WHERE address_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				address = new Address(id, resultSet.getString(2),
						resultSet.getString(12), resultSet.getString(3),
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
		return address;
	}

	public int getId() {
		return address_id;
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
		return title;
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
		return "Address: " + salutation + ", " + title + ", " + firstname +
				", " + lastname + ", " + company + ", " + country + ", " +
				province + ", " + city + ", " + street + ", " + streetNo +
				", " + zip;
	}
}