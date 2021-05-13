package com.jdbc;

import java.sql.*;

public class JdbcTest {

	public static void main(String[] args) throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection dbcon = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
				"postgres", "root");
		System.out.println("Connection: " + dbcon);
		Statement stmt = dbcon.createStatement();
		stmt.executeUpdate("INSERT INTO employee VALUES(7, 'Ivan', 45000)"); //DML
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee"); //SQL
		while(rs.next()) {
			System.out.println(rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getDouble("sal"));
		}
		rs.close();
		stmt.close();
		dbcon.close();
	}

}
