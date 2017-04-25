package db;

import java.sql.*;
import java.util.ArrayList;

import connection.ConnectionManager;

public class Client {

	private int customer_id;
	private String login;
	private String url;
	private String ip;
	private Date birthday;
	private String language_id;
	private int customerNo;
	private int count_offers;
	private int count_orders;
	private String email;
	private String comment;
	private Date lastLogin;
	private int customerGroup;
	
	private static final boolean IS_CRYPTED = false;

	public Client(){}
	
	private Client(int id, String login, String url,
			String ip, Date birthday, String languageId, int customerNo,
			int countOffers, int countOrders, String email, String comment,
			Date lastLogin, int customerGroupId) {
		this.customer_id = id;
		this.login = login;
		this.url = url;
		this.ip = ip;
		this.birthday = birthday;
		this.language_id = languageId;
		this.customerNo = customerNo;
		this.count_offers = countOffers;
		this.count_orders = countOrders;
		this.email = email;
		this.comment = comment;
		this.lastLogin = lastLogin;
		this.customerGroup = customerGroupId;
	}
	
	public Auction[] getAuctions(){
		ArrayList<Auction> auctions = new ArrayList<Auction>();
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM auction "+
			"WHERE customer_id = "+customer_id+" AND online ");			
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
	
	public Client login(String username, String password){
		Client client = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			if(IS_CRYPTED) {
				preparedStatement = connection.prepareStatement(
					"SELECT \"login\", \"url\", \"ip\", \"birthday\", \"language_id\", \"customerNo\"," +
							"\"count_offers\", \"count_orders\", \"email\", \"comment\", \"lastLogin\", \"customer_group_id\","+
							"\"customer_id\" FROM client WHERE login = ? AND pw = crypt( ? , pw)");
			} else {
				preparedStatement = connection.prepareStatement(
					"SELECT \"login\", \"url\", \"ip\", \"birthday\", \"language_id\", \"customerNo\"," +
							"\"count_offers\", \"count_orders\", \"email\", \"comment\", \"lastLogin\", \"customer_group_id\","+
							"\"customer_id\" FROM client WHERE login = ? AND pw = ?");
			}
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				client = new Client(resultSet.getInt(13),resultSet.getString(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getDate(4),
						resultSet.getString(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),
						resultSet.getString(9),resultSet.getString(10),resultSet.getDate(11),
						resultSet.getInt(12));
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return client;
	}

	public Client create(String login, String password, String url,
			String ip, Date birthday, String languageId, int customerNo,
			int countOffers, int countOrders, String email, String comment,
			Date lastLogin, int customerGroup) {
		Client client = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			if(IS_CRYPTED) {
				preparedStatement = connection.prepareStatement(
					"INSERT INTO client (login, pw, url, ip, birthday,"	+
					"language_id, \"customerNo\", count_offers, " +
					"count_orders, email, comment, \"lastLogin\", " +
					"customer_group_id) " +
					"VALUES (?, crypt( ? , gen_salt('md5')), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
					"RETURNING customer_id");
			} else {
				preparedStatement = connection.prepareStatement(
					"INSERT INTO client (login, pw, url, ip, birthday,"	+
					"language_id, \"customerNo\", count_offers, " +
					"count_orders, email, comment, \"lastLogin\", " +
					"customer_group_id) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
					"RETURNING customer_id");
			}
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, url);
			preparedStatement.setString(4, ip);
			preparedStatement.setDate(5, birthday);
			preparedStatement.setString(6, languageId);
			preparedStatement.setInt(7, customerNo);
			preparedStatement.setInt(8, countOffers);
			preparedStatement.setInt(9, countOrders);
			preparedStatement.setString(10, email);
			preparedStatement.setString(11, comment);
			preparedStatement.setDate(12, lastLogin);
			preparedStatement.setInt(13, customerGroup);
			// Retrieve the result of RETURNING statement to get the current id.
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				client = new Client(resultSet.getInt(1), login, url,
						ip, birthday, languageId, customerNo, countOffers,
						countOrders, email, comment, lastLogin, customerGroup);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return client;
	}
	
	public static Client find(int id) {
		Client client = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT \"login\", \"url\", \"ip\", \"birthday\", \"language_id\", \"customerNo\"," +
							"\"count_offers\", \"count_orders\", \"email\", \"comment\", \"lastLogin\", \"customer_group_id\""+
							"FROM client WHERE customer_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				client = new Client(id,resultSet.getString(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getDate(4),
						resultSet.getString(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),
						resultSet.getString(9),resultSet.getString(10),resultSet.getDate(11),
						resultSet.getInt(12));
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return client;
	}

	public int getId() {
		return customer_id;
	}

	public String getLogin() {
		return login;
	}

	public String getUrl() {
		return url;
	}

	public String getIp() {
		return ip;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getLanguageId() {
		return language_id;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public int getCountOffers() {
		return count_offers;
	}

	public int getCountOrders() {
		return count_orders;
	}

	public String getEmail() {
		return email;
	}

	public String getComment() {
		return comment;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public int getCustomerGroup() {
		return customerGroup;
	}
	
	@Override
	public String toString() {
		return "Client: " + customer_id + ", Name: " + login +", Email:"+  email +", CustGroup: "+customerGroup;
	}
}