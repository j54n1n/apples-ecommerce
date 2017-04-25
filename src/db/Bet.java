package db;

import java.sql.*;
import java.util.Calendar;

import connection.ConnectionManager;

public class Bet {

	private int bet_id;
	private int amount;
	private Timestamp timestamp;
	private int client_id;
	private int auction_id;

	public Bet() {}

	Bet(int id, int amount, Timestamp timestamp, int client,
			int auction) {
		this.bet_id = id;
		this.amount = amount;
		this.timestamp = timestamp;
		this.client_id = client;
		this.auction_id = auction;
	}

	public static Bet place(int amount, int client_id, int auction_id) {
		int minimumBet = Integer.MIN_VALUE;
		Bet bet = null;
		ResultSet minAmount;
		ResultSet betResult;
		PreparedStatement minAmountStatement = null;
		PreparedStatement betResultStatement = null;
		Connection connection = ConnectionManager.connect();
		try {
			connection.setAutoCommit(false);
			//Check Highest Bet
			minAmountStatement = connection.prepareStatement("SELECT MAX(amount) FROM bet WHERE auction_id = ?");
			minAmountStatement.setInt(1, auction_id);
			minAmount = minAmountStatement.executeQuery();
			minAmount.next();
			minimumBet = minAmount.getInt(1);
			if(minimumBet == 0){				
				//If no bet is set at all;				
				minAmountStatement = connection.prepareStatement("SELECT start_price FROM auction WHERE auction_id = ?");
				minAmountStatement.setInt(1, auction_id);
				minAmount = minAmountStatement.executeQuery();
				minAmount.next();
				minimumBet = minAmount.getInt(1);
			} else {
				//add minimum bid
				System.out.println(minimumBet);
				minAmountStatement = connection.prepareStatement("SELECT amount FROM auction WHERE auction_id = ?");
				minAmountStatement.setInt(1, auction_id);
				minAmount = minAmountStatement.executeQuery();
				minAmount.next();			
				minimumBet += minAmount.getInt(1);
			}
			//Bid was high enough
			if(amount >= minimumBet){
				betResultStatement = connection.prepareStatement(
						"INSERT INTO bet (amount, \"timestamp\", client_id, " +
								"auction_id) " +
								"VALUES (?, ?, ?, ?) " +
						"RETURNING bet_id");
				betResultStatement.setInt(1, amount);
				Timestamp timestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
				betResultStatement.setLong(2, timestamp.getTime() / 1000L);
				betResultStatement.setInt(3, client_id);
				betResultStatement.setInt(4, auction_id);
				betResult = betResultStatement.executeQuery();
				if (betResult.next()) {
					bet = new Bet(betResult.getInt(1), amount, timestamp, client_id,
							auction_id);					
				}
				betResultStatement.close();
			}
			//Check if in the meantime any other customer bid more
			minAmountStatement = connection.prepareStatement("SELECT MAX(amount) FROM bet WHERE auction_id = ?");
			minAmountStatement.setInt(1, auction_id);
			minAmount = minAmountStatement.executeQuery();
			if(minAmount.next()){
				int checkHighest = minAmount.getInt(1);
				//IF anything other happened, abort and return null;
				if(checkHighest > amount){
					connection.rollback();
					connection.setAutoCommit(true);
					return null;
				}
			} 
			betResultStatement = connection.prepareStatement("UPDATE client SET count_orders = (count_orders + 1) WHERE customer_id = ? ;");
			betResultStatement.setInt(1, client_id);
			betResultStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					e.printStackTrace();
					connection.rollback();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.close(connection);
		}
		return bet;
	}

	public static Bet find(int id) {
		Bet bet = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM bet WHERE bet_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				bet = new Bet(id, resultSet.getInt(2),
						new Timestamp(resultSet.getLong(3) * 1000L),
						resultSet.getInt(4), resultSet.getInt(5));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return bet;
	}

	public int getId() {
		return bet_id;
	}

	public int getAmount() {
		return amount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public int getClientId() {
		return client_id;
	}

	public int getAuctionId() {
		return auction_id;
	}

	@Override
	public String toString() {
		return "Bet: " + bet_id + ", " + amount + ", " + timestamp.getTime() +
				", " + client_id + ", " + auction_id;
	}
}