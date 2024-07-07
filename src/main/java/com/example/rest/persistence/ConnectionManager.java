package com.example.rest.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/postgres";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "root";

    static Connection connection;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
		if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        }
        return connection;
	}

}