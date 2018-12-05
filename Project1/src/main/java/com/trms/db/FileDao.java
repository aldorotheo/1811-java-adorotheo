package com.trms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileDao {
	private static Connection conn = ConnectionFactory.getConnectionFactory().createConnection();
	public void insertFile(int req_id, String filename) {
		String sql = "insert into TRMSFiles (req_id, file) values (?,?);";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, req_id);
			stmt.setString(2, filename);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
