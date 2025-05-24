package pageObjects;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://db4free.net:3306/nagamurali";
		String userName = "nagamurali12";
		String passwrd = "nagamurali@12";
		Connection con = DriverManager.getConnection(url,userName,passwrd);
		PreparedStatement ps = con.prepareStatement("Sql query");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name"));
		}
		rs.close();
		ps.close();
		con.close();

	}

}
