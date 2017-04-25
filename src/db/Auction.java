package db;

import java.sql.*;
import java.util.ArrayList;
import connection.ConnectionManager;

public class Auction {

	private int auction_id;
	private String title;
	private String description;
	private int start_price;
	private int express_price;
	private int amount;
	private Date date_added;
	private Date date_modified;
	private Date date_end;
	private boolean online;
	private String image;
	private int viewed;
	private int auction_status_id;
	private int customer_id;

	public Auction() {}

	public Auction(int id, String title, String description, int startPrice,
			int expressPrice, int amount, Date dateAdded, Date dateEnd, Date dateModified,
			boolean isOnline, String imagePath, int viewed,
			int auctionStatus_id, int customer_id) {
		this.auction_id = id;
		this.title = title;
		this.description = description;
		this.start_price = startPrice;
		this.express_price = expressPrice;
		this.amount = amount;
		this.date_added = dateAdded;
		this.date_modified = dateModified;
		this.online = isOnline;
		this.image = imagePath;
		this.viewed = viewed;
		this.auction_status_id = auctionStatus_id;
		this.date_end = dateEnd;
		this.customer_id=customer_id;
	}
	
	public boolean delete(){
		boolean success = false;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM auction WHERE auction_id = "+this.auction_id+";");		
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

	public static Auction create(String title, String description, int startPrice,
			int expressPrice, int amount, Date dateAdded, Date dateEnd, Date dateModified,
			boolean isOnline, String imagePath, int viewed, int auctionStatus_id,
			int customer_id, int categoryID[]) {
		Auction auction = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(
					"INSERT INTO auction (description, start_price, " +
							"express_price, amount, date_added, date_modified, " +
							"online, image, viewed, auction_status, title, date_end, customer_id) " +
							"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
					"RETURNING auction_id");
			preparedStatement.setString(1, description);
			preparedStatement.setInt(2, startPrice);
			preparedStatement.setInt(3, expressPrice);
			preparedStatement.setInt(4, amount);
			preparedStatement.setDate(5, dateAdded);
			preparedStatement.setDate(6, dateModified);
			preparedStatement.setBoolean(7, isOnline);
			preparedStatement.setString(8, imagePath);
			preparedStatement.setInt(9, viewed);
			preparedStatement.setInt(10, auctionStatus_id);
			preparedStatement.setString(11, title);
			preparedStatement.setDate(12, dateEnd);
			preparedStatement.setInt(13, customer_id);
			// Retrieve the result of RETURNING statement to get the current id.
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				auction = new Auction(resultSet.getInt(1), title, description,
						startPrice, expressPrice, amount, dateAdded, dateEnd,
						dateModified, isOnline, imagePath, viewed,
						auctionStatus_id, customer_id);
				String statement = "INSERT INTO categorized_as(auction_id, category_id)"+" VALUES "; 
				statement += (categoryID.length == 0 || categoryID == null)?"("+auction.getId()+", 0 )":"";
				for (int i = 0; i < categoryID.length; i++) {
					statement += (i != 0)?", ":"";
					statement += ("("+auction.getId()+", "+categoryID[i]+")");
				}
				preparedStatement = connection.prepareStatement(statement);
				if( preparedStatement.executeUpdate() > 0 ){
					preparedStatement = connection.prepareStatement("UPDATE client SET count_orders = (count_offers + 1) WHERE customer_id = ? ;");
					preparedStatement.setInt(1, customer_id);
					preparedStatement.executeUpdate();
					connection.commit();
				} else {
					connection.rollback();
					auction = null;
				}				
			}else{
				connection.rollback();
				auction = null;
			}
			preparedStatement.close();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return auction;
	}

	public static Auction find(int id) {
		Auction auction = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM auction WHERE auction_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				auction = new Auction(id, resultSet.getString(12), resultSet.getString(2),
						resultSet.getInt(3), resultSet.getInt(4),
						resultSet.getInt(5), resultSet.getDate(6), resultSet.getDate(13),
						resultSet.getDate(7), resultSet.getBoolean(8),
						resultSet.getString(9), resultSet.getInt(10),
						resultSet.getInt(11), resultSet.getInt(14));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return auction;
	}
	
	
	public Bet getHighestBet(){
		Bet highestBet = null;
		PreparedStatement maxBetStatement = null;
		ResultSet resultSet;
		Connection connection = ConnectionManager.connect();
		
		try {
			maxBetStatement = connection.prepareStatement(
					"SELECT * FROM bet b WHERE auction_id = ? AND b.amount = "+
			"(SELECT max(amount) from bet WHERE auction_id = ?)");
			maxBetStatement.setInt(1, auction_id);
			maxBetStatement.setInt(2, auction_id);
			resultSet = maxBetStatement.executeQuery();
			if (resultSet.next()) {
				highestBet = new Bet(resultSet.getInt(1), resultSet.getInt(2), new java.sql.Timestamp(resultSet.getLong(3)), resultSet.getInt(4), resultSet.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return highestBet;
	}
	
	public static Auction[] find(String title) {
		ArrayList<Auction> auctions = new ArrayList<Auction>();
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM auction WHERE LOWER(auction.title) LIKE ? "+
			"AND online");
			preparedStatement.setString(1, "%" + title.toLowerCase() + "%");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				auctions.add(new Auction(resultSet.getInt(1), resultSet.getString(12),
						resultSet.getString(2),	resultSet.getInt(3), resultSet.getInt(4),
						resultSet.getInt(5), resultSet.getDate(6), resultSet.getDate(13),
						resultSet.getDate(7), resultSet.getBoolean(8),
						resultSet.getString(9), resultSet.getInt(10),
						resultSet.getInt(11),resultSet.getInt(14)));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return (Auction[])auctions.toArray(new Auction[auctions.size()]);
	}

	public static Auction[] listByCategoryId(int categoryID, int start, int range) {
		ArrayList<Auction> auctions = new ArrayList<Auction>();
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM auction, categorized_as "+
							"WHERE categorized_as.auction_id = auction.auction_id AND category_id = ? " +
							"AND online "+
							"ORDER BY auction.auction_id LIMIT ? OFFSET ?");
			preparedStatement.setInt(1, categoryID);
			preparedStatement.setInt(2, range);
			preparedStatement.setInt(3, start);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				auctions.add(new Auction(resultSet.getInt(1), resultSet.getString(12),
						resultSet.getString(2),	resultSet.getInt(3), resultSet.getInt(4),
						resultSet.getInt(5), resultSet.getDate(6), resultSet.getDate(13),
						resultSet.getDate(7), resultSet.getBoolean(8),
						resultSet.getString(9), resultSet.getInt(10),
						resultSet.getInt(11), resultSet.getInt(14)));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return (Auction[])auctions.toArray(new Auction[auctions.size()]);
	}

	public int getCustomerId(){
		return customer_id;
	}
	public int getId() {
		return auction_id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getStartPrice() {
		return start_price;
	}

	public int getExpressPrice() {
		return express_price;
	}

	public int getAmount() {
		return amount;
	}

	public Date getDateAdded() {
		return date_added;
	}

	public Date getDateModified() {
		return date_modified;
	}

	public boolean isOnline() {
		return online;
	}
	
	public Date getDateEnd(){
		return date_end;
	}
	
	public String getImagePath() {
		return image;
	}

	public int getViewed() {
		return viewed;
	}

	public int getAuctionStatusID() {
		return auction_status_id;
	}

	@Override
	public String toString() {
		return "Auction: " + auction_id + " Title: " + title;
	}
}