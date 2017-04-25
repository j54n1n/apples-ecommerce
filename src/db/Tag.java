package db;

import java.sql.*;

import connection.ConnectionManager;

public class Tag {
	
	private int tag_id;
	private String name;
	private int meta;
	
	
	public Tag(){}
	private Tag(int id, String name, int meta) {
		this.tag_id = id;
		this.name = name;
		this.meta = meta;
	}
	
	public static Tag create(String name, int meta) {
		Tag tag = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO tag (name, meta) " +
					"VALUES (?, ?) " +
					"RETURNING tag_id");
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, meta);
			// Retrieve the result of RETURNING statement to get the current id.
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				tag = new Tag(resultSet.getInt(1), name, meta);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return tag;
	}
	
	public static Tag find(int id) {
		Tag tag = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM tag WHERE tag_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				tag = new Tag(id, resultSet.getString(2), resultSet.getInt(3));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return tag;
	}

	public int getId() {
		return tag_id;
	}

	public String getName() {
		return name;
	}

	public int getMeta() {
		return meta;
	}
	
	@Override
	public String toString() {
		return "Tag: " + tag_id + ", " + name + ", " + meta;
	}
}