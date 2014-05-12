package by.epam.lw5.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseConnection {
	private Connection connection;
	
	public Connection getBaseConnection() throws SQLException{
		if (connection == null||connection.isClosed()){
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=root&password=123456");
			return connection;
		}else{
			return connection;
		}
	}	
}
