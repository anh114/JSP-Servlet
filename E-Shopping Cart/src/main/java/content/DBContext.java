package content;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShoppingDB", "root", "cassiopeia");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

}
