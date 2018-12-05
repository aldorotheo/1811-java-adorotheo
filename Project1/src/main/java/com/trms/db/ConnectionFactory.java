package com.trms.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static String url;
	private static String username;
	private static String password;
	private static final String filename = "C:/Users/aldor/Documents/workspace-spring-tool-suite-4-4.0.1.RELEASE/Project1/src/main/resources/database.properties";
	private ConnectionFactory() {
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(filename);
			prop.load(fis);
			ConnectionFactory.url=prop.getProperty("url");
			ConnectionFactory.username=prop.getProperty("username");
			ConnectionFactory.password=prop.getProperty("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static ConnectionFactory cf = null;

	public synchronized static ConnectionFactory getConnectionFactory() {
		if (cf == null) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = 	DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Unable to make connection to the database");
			e.printStackTrace();
		}
		return conn;
	}

}
