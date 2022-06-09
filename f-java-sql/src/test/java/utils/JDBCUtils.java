package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String user;
	private static String password;
	private static String url;

	static {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/test/resources/mysql.properties"));
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			url = properties.getProperty("url");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void close(Statement statement, Connection connection) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
