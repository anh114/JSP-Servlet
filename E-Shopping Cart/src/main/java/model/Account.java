package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Account {
	private String usr, pwd;
	private int role;
	private String name, address, phone;
	private int check;
    Connection conn;
	
	
	
	public Account(Connection conn) {
		this.conn = conn;
	}
	public Account() {
		
	}
	
	public Account(String usr, String pwd, int role, String name, String address, String phone, int check) {
		this.usr =usr;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
		//xem lai cho field này
		this.check = check;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}
	
	public boolean login(String username, String password) throws SQLException {
		String query = "Select count(*) as counter from Account Where user_mail=? and password=?";
	
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		int count = 0;
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt("counter");
		}
		rs.close();
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	public boolean exists(String username) throws SQLException {
		
		String sql = "Select Count(*) as count from Account Where user_mail=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,  username);
		
		ResultSet rs = stmt.executeQuery();
		int count = 0;
		if(rs.next()) {
			count = rs.getInt("count");
		}
		rs.close();

		
		if(count > 0) {
			return true;
		}
		
		return false;
	}
	
	public void createAdmmin(String username, String password, int role) throws SQLException {
			String sql = "insert into Account (user_mail, password, account_role) values (?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setInt(3, role);
			
			stmt.executeUpdate();
			
			stmt.close();
		
	}
	
	public boolean checkAdmin(String usermail) throws SQLException{
		String sql = "Select account_role From Account Where user_mail like ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, usermail);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			if(rs.getInt(1) == 1) {
				return true;
			}
		}
		return false;
		

		
		
	}
	
	public void createCustomer(String userMail, String password,int role, String userName, String userAddress, String userPhone) throws SQLException {
		String sql = "insert into Account (user_mail, password, account_role, user_name, user_address, user_phone) values (?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, userMail);
		stmt.setString(2, password);
		stmt.setInt(3, role);
		stmt.setString(4, userName);
		stmt.setString(5, userAddress);
		stmt.setString(6, userPhone);
		
		stmt.executeUpdate();
		
		stmt.close();
	
}
	
	public boolean valid(String user_mail, String password) {
		// make sure that email is valid
		String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regex = "[a-zA-Z0-9_!@#$%^&*]+";
		
		if (password.matches(regex) && user_mail.matches(regexMail)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<String> findCus(String usermail) throws SQLException{
		String sql = "Select * from Account Where user_mail Like ?";
		ArrayList<String> cus = new ArrayList<String>();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, usermail);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			String username = rs.getString(4);
			String useraddress = rs.getString(5);
			String userphone = rs.getString(6);
			
			cus.add(username);
			cus.add(useraddress);
			cus.add(userphone);
			
		}
		return cus;
		
	}
	
	
}
