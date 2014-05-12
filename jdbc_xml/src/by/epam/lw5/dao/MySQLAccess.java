package by.epam.lw5.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;

import by.epam.lw5.entity.Employee;
import by.epam.lw5.parsers.dom.DomWriter;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private BaseConnection bConnection = new BaseConnection();

	public void readDataBase() throws Exception {
		//List<Employee> empList = null;
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = bConnection.getBaseConnection();

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			
		//	statement.execute("USE test");
			resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");
			writeResultSet(resultSet);

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	public void writeDataBase(List<Employee> empList){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = bConnection.getBaseConnection();

			statement = connect.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEE" +
					"(id INT AUTO_INCREMENT NOT NULL, age INT, name VARCHAR(20), gender VARCHAR(20), role VARCHAR(20), primary key (id));";
			statement.executeUpdate(sql);
			insertToDB(empList);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		List<Employee> empList = new ArrayList<Employee>();
		while(resultSet.next()) {
			String name = resultSet.getString("name");
			int age = resultSet.getInt("age");
			String gender = resultSet.getString("gender");
			String role = resultSet.getString("role");
			Employee employee = new Employee(name, age,gender, role);
			empList.add(employee);
		}
		try {
			DomWriter.run(empList);
		} catch (TransformerException e) {	
			e.printStackTrace();
		}
	}
	
	private void insertToDB(List<Employee> empList) throws SQLException{
		System.out.println("Inserting records into the table ...");
		try {
			connect = bConnection.getBaseConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		statement = connect.createStatement();
		for(Employee employee : empList){
		int age = employee.getAge();
		String name = employee.getName();
		String role = employee.getRole();
		String gender = employee.getGender();
		String sql = "INSERT INTO `EMPLOYEE` (`id`, `age`, `name`, `gender`, `role`) " +
				"VALUES (" + "NULL,"  + age +", '" + name + "', " + "'" + gender + "', " + "'" + role + "'" + ")";
		statement.executeUpdate(sql);
		}
		System.out.println("Inserting complited.");
	}
	
	private void close() {
		close(resultSet);
		close(statement);
		close(connect);
	}

	private void close(Object c) {
		try {
			if (c != null) {
				((Closeable) c).close();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
