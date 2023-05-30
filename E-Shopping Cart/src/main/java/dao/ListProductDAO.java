package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import content.DBContext;
import model.Cart;
import model.Product;

public class ListProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	//return the list of products by searching
	public List<Product> search(String s) throws Exception{
		List<Product> list = new ArrayList<>();
		String query = "Select * from Products Where product_name like ?";
		try {
			 conn = new DBContext().getConnection();
			 ps = conn.prepareStatement(query);
			 ps.setString(1, "%" +s+ "%");
			 rs = ps.executeQuery();
			 while (rs.next()) {
				//Đưa tất cả product search dc theo đúng yêu cầu vào list.
					list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
							rs.getString(5), rs.getString(6), rs.getString(7)));
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//get products
	public Product getProduct(String id) throws Exception {
		
		String query = "Select * from Products Where product_id=?";
		try {
			conn = new DBContext().getConnection(); //connect with SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getString(6), rs.getString(7));   
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	//get all products
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		String query = "Select * from Products;";
		try {
			conn = new DBContext().getConnection(); //connect with SQL
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery(); //return result from query of SQL
			while(rs.next()) {
				//Đưa tất cả product trên DB vào 
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Product> getListByPage(List<Product> list, int start, int end){
		List<Product> arr = new ArrayList<>();
		for(int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
		
	}


}



