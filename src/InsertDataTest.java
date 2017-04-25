import java.sql.*;

import connection.*;
import db.*;

public class InsertDataTest {
/*
	public static void main(String[] args) {
		String categories[] = { "Art", "Books", "Business&Industry", "Clothing", "Car", 
				"Collectibles", "Electronics", "Entertainment", "Pet", "Toys", "Other" };
		String auctionStatuses[] = { "open", "expired", "sold" };
		String customerGroups[] = { "retailer", "private vendor" };
		String paymentMethods[] = { "Cash transfer", "Credit Card", "Paypal" };
		int paymentMethodsDues[] = { 4, 2, 6 };
		String shipmentMethod[] = { "Express Shipping", "Standard Shipping", "International Air Shipment" };
		int shipmentMethodsDues[] = { 40, 5, 15 };

		Category c;
		for(int i = 0; i<categories.length;i++){
			c = Category.create(null, "/noicon.jpg", true, categories[i]);
			System.out.println(c.getName());
		}

		CustomerGroup cg;
		for(int i = 0; i<customerGroups.length;i++){
			cg = CustomerGroup.create(customerGroups[i]);
			System.out.println(cg.getName());
		}

		AuctionStatus as;
		for (int i = 0; i < auctionStatuses.length; i++) {
			as = AuctionStatus.create(auctionStatuses[i]);
			System.out.println(as.getName());
		}

		Connection con = ConnectionManager.connect();		
		PreparedStatement preparedStatement;
		try {
			for (int i = 0; i < paymentMethods.length; i++) {
				preparedStatement = con.prepareStatement("INSERT INTO payment_method(name,dues,comment)"+
						"VALUES(?,?,?) RETURNING payment_method_id");
				preparedStatement.setString(1, paymentMethods[i]);
				preparedStatement.setInt(2, paymentMethodsDues[i]);
				preparedStatement.setNull(3, Types.VARCHAR);
				preparedStatement.executeQuery();
			}
			
			for(int i = 0; i < shipmentMethod.length; i++){
				preparedStatement = con.prepareStatement("INSERT INTO shipment_method(name,dues,comment)"+
						"VALUES(?,?,?) RETURNING shipment_method_id");
				preparedStatement.setString(1, shipmentMethod[i]);
				preparedStatement.setInt(2, shipmentMethodsDues[i]);
				preparedStatement.setNull(3, Types.VARCHAR);
				preparedStatement.executeQuery();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionManager.close(con);		
	}
	*/
}
