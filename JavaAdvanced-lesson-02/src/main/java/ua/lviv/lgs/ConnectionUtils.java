package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	static String url = "jdbc:mysql://localhost:3306/PersonDB";
	static String username = "peles";
	static String password = "654321";
	
	static Connection connect() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
