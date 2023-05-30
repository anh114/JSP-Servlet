package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

import content.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDAO {
	Connection conn;
	
	public OrdersDAO(Connection conn) {
		this.conn = conn;
	}
	
	public OrdersDAO() {
		
	}
	
	
	
	//insert information of Order to data source, that including list of products
	// in cart and information of buyer in Orders
	
	/*
	 Orders(int status, String address, String phoneNumber, String userMail, Date receivedDate, String discount)
			
	 Cart<Product>: int id, String name, float price, int number; getAmount(); size()

	 */
	
	public int insertOrder(Orders o, Cart c) throws Exception{
		//Update in Orders table
		String sql = "insert into Orders (user_mail, order_status, order_date, order_discount_code, order_address) values (?, ?, ?, ?, ?)";
		List<Product> listP = c.getItems();
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		int orderId;
		try (Connection con = new DBContext().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			) {
			
			for(int i = 0; i < listP.size(); i++) {
				stmt.setString(1, o.getUserMail());
				stmt.setInt(2, o.getStatus());
				stmt.setDate(3, date);
				stmt.setString(4, o.getDiscount());
				stmt.setString(5, o.getAddress());
				
			}
			int affectedRows = stmt.executeUpdate();
			if(affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if(generatedKeys.next()) {
					
						orderId = generatedKeys.getInt(1);
						return orderId;
					
				
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
		}
		
	}
	
	public void insertOrderDetail(Cart c, Orders o, int orderId) throws Exception {
		String sql = "insert into Orders_detail (order_id, product_id, amount_product, price_product) values (?, ?, ?, ?)";
		List<Product> listP = c.getItems();
					
		for(int i = 0; i < listP.size(); i++) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderId);
			stmt.setInt(2, listP.get(i).getId());
			stmt.setInt(3, listP.get(i).getNumber());
			stmt.setFloat(4, listP.get(i).totalPrice());
			stmt.executeUpdate();	
			stmt.close();
		}
			
			
		
		
	}
	
	


}
