package db;

import java.sql.*;
import java.util.ArrayList;

import connection.ConnectionManager;

public class Category {
	
	private int category_id;
	private int parent_id;
	private String icon;
	private boolean isOnline;
	private String name;
	private Category[] children;
	
	public Category() {}

	public Category(int id, int parent, String iconPath, boolean isOnline, String name) {
		this.category_id = id;
		this.parent_id = parent;
		this.icon = iconPath;
		this.isOnline = isOnline;
		this.name = name;
		this.children = getChildren(id);
	}
	
	public static Category[] getChildren(int id){
		ArrayList<Category> categories = new ArrayList<Category>();
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM category WHERE parent_id = ? AND online");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				boolean isOnline = resultSet.getBoolean(4);
				if(isOnline) {
					categories.add(new Category(resultSet.getInt(1), id, resultSet.getString(3), isOnline, resultSet.getString(5)));
				}
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return (Category[])categories.toArray(new Category[categories.size()]);
	}
	
	/*
	public static Category create(int parent, String iconPath,	boolean isOnline, String name) {
		Category category = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO category (" +
					((parent != null) ? "parent_id, " : "") + "icon, " + "status, "+
					"name) " +
					"VALUES (" + ((parent != null) ? "?, " : "") +
					"?, ?, ?) " +
					"RETURNING category_id");
			if(parent != null) {
				preparedStatement.setInt(1, parent.getId());
				preparedStatement.setString(2, iconPath);
				preparedStatement.setBoolean(3, isOnline);
				preparedStatement.setString(4, name);
			} else {
				preparedStatement.setString(1, iconPath);
				preparedStatement.setBoolean(2, isOnline);
				preparedStatement.setString(3, name);
			}
			// Retrieve the result of RETURNING statement to get the current id.
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				category = new Category(resultSet.getInt(1), parent, iconPath, isOnline,name);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return category;
	}
	*/
	
	public static Category find(int id) {
		Category category = null;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Connection connection = ConnectionManager.connect();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM category WHERE category_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				category = new Category(id, resultSet.getInt(2),
						resultSet.getString(3), resultSet.getBoolean(4), resultSet.getString(5));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(connection);
		}
		return category;
	}

	public int getId() {
		return category_id;
	}

	public int getParent() {
		return parent_id;
	}

	public String getIcon() {
		return icon;
	}
	
	public String getName() {
		return name;
	}

	public boolean isStatus() {
		return isOnline;
	}
	
	public Category[] getChildren() {
		return children;
	}

	@Override
	public String toString() {
		return "Category: " + category_id + ", " + parent_id + ", " + icon + ", " + isOnline;
	}
}