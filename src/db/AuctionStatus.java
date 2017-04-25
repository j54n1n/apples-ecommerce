package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionManager;

public class AuctionStatus {
	
	private int auction_status_id;
	private String name;
	
	private AuctionStatus(int id, String name) {
		this.auction_status_id = id;
		this.name = name;
	}
	
	public static AuctionStatus create(String name) {
		AuctionStatus auctionStatus = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO auction_status (name) " +
					"VALUES (?) " +
					"RETURNING auction_status_id");
			preparedStatement.setString(1, name);
			// Retrieve the result of RETURNING statement to get the current id.
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				auctionStatus = new AuctionStatus(resultSet.getInt(1), name);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return auctionStatus;
	}
	
	public static AuctionStatus find(int id) {
		AuctionStatus auctionStatus = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM auction_status WHERE auction_status_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				auctionStatus = new AuctionStatus(id, resultSet.getString(2));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return auctionStatus;
	}
	
	public int getId() {
		return auction_status_id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "AuctionStatus: " + auction_status_id + ", " + name; 
	}
}