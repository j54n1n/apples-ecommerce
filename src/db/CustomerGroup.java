package db;

import java.sql.*;

import connection.ConnectionManager;

public class CustomerGroup {
	
	private int customer_group_id;
	private String name;
	
	public CustomerGroup() {}
	
	public CustomerGroup(int id, String name) {
		customer_group_id = id;
		this.name = name;
	}
	
	public static CustomerGroup create(String name) {
		CustomerGroup customerGroup = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO customer_group (name) VALUES (?)" +
					"RETURNING customer_group_id");
			preparedStatement.setString(1, name);
			// Retrieve the result of RETURNING statement to get the current id.
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customerGroup = new CustomerGroup(resultSet.getInt(1), name);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return customerGroup;
	}
	
	public static CustomerGroup random() {
		String rd = Long.toHexString(Double.doubleToLongBits(Math.random()));
		return create("Group_" + rd);
	}
	
	public static CustomerGroup find(int id) {
		CustomerGroup customerGroup = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM customer_group WHERE customer_group_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customerGroup = new CustomerGroup(id, resultSet.getString(2));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return customerGroup;
	}

	public int getId() {
		return customer_group_id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "CustomerGroup: " + customer_group_id + ", " + name;
	}
}