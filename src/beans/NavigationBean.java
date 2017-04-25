package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionManager;
import db.Category;

public class NavigationBean {
	
	ArrayList<Category> cats = new ArrayList<Category>();
	
	public NavigationBean(){
		
		ResultSet resultSet;
		Connection connection = ConnectionManager.connect();
		try {
			
			
			Statement stmt = connection.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM category WHERE parent_id IS NULL OR parent_id = 0;");
			
			while(resultSet.next()) 
			{
				cats.add(new Category(resultSet.getInt(1), resultSet.getInt(2),resultSet.getString(3), resultSet.getBoolean(4), resultSet.getString(5)));	
			}
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
			ConnectionManager.close(connection);
		}
	
		
	};
	
	
	public String[] test = {"asdsadsdasd","asdasd"};
	
	public Category[] getTestText(){
		
		Category[] categories;
		categories = new Category[20];

		categories[0] = new Category(1, 0, "", true, "kuchen");
		categories[1] = new Category(2, 0, "", true, "tasche");
		return categories;
		
	}
	

	
	public Category[] getAllCategories(){
		
		return (Category[])cats.toArray(new Category[cats.size()]);
	}
	
}
