package tech.luv2code.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private String DB_URL = "jdbc:mysql://mysqldb:3306/feedback_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private String USER_NAME = "root";
	private String PASSWORD = "AmazingNews123$";
	Connection connection = null;

	public Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
