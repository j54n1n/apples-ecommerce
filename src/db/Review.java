package db;

import java.sql.*;

import connection.ConnectionManager;

public class Review {
	
	private int review_id;
	private String text;
	private Date date_added;
	private Date date_modified;
	private int rating;
	private Client customer_id;
	private Auction auction_id;
	
	
	public Review(){}
	private Review(int id, String text, Date dateAdded,
			Date dateModified, int rating, Client client,
			Auction auction) {
		this.review_id = id;
		this.text = text;
		this.date_added = dateAdded;
		this.date_modified = dateModified;
		this.rating = rating;
		this.customer_id = client;
		this.auction_id = auction;
	}
	
	public static Review create(String text, Date dateAdded,
			Date dateModified, int rating, Client client,
			Auction auction) {
		Review review = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO review (text, date_added, date_modified, " +
					"rating, customer_id, auction_id) " +
					"VALUES (?, ?, ?, ?, ?, ?) " +
					"RETURNING review_id");
			preparedStatement.setString(1, text);
			preparedStatement.setDate(2, dateAdded);
			preparedStatement.setDate(3, dateModified);
			preparedStatement.setInt(4, rating);
			preparedStatement.setInt(5, client.getId());
			preparedStatement.setInt(6, auction.getId());
			// Retrieve the result of RETURNING statement to get the current id.
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				review = new Review(resultSet.getInt(1), text, dateAdded,
						dateModified, rating, client, auction);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return review;
	}
	
	public static Review find(int id) {
		Review review = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM review WHERE review_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				review = new Review(id, resultSet.getString(2),
						resultSet.getDate(3), resultSet.getDate(4),
						resultSet.getInt(5), Client.find(resultSet.getInt(6)),
						new Auction().find(resultSet.getInt(7)));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return review;
	}

	public int getId() {
		return review_id;
	}

	public String getText() {
		return text;
	}

	public Date getDateAdded() {
		return date_added;
	}

	public Date getDateModified() {
		return date_modified;
	}

	public int getRating() {
		return rating;
	}

	public Client getClient() {
		return customer_id;
	}

	public Auction getAuction() {
		return auction_id;
	}
	
	@Override
	public String toString() {
		return "Review: " + review_id + ", " + text + date_added.toString() +
				", " + date_modified.toString() + ", " + rating + ", " +
				", " + customer_id.getId() + ", " + auction_id.getId();
	}
}