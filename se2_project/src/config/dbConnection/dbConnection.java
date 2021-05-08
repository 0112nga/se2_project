package config.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
	private static String db_URL = "jdbc:mysql://localhost:3306/se2projectschema";
	private static String username = "root";
	private static String password = "root";
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(db_URL, username, password);
			System.out.println("Connect to DB success");
		} catch (Exception e) {
			System.out.println("Connect to DB failed");
			e.printStackTrace();
		}
		return connection;
	}
}
