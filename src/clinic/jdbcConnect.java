package clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_db", "root", "Sushmi@123");
		System.out.println("connection created");

	}

}
