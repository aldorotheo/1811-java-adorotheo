package com.trms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDao {
	private static Connection conn = ConnectionFactory.getConnectionFactory().createConnection();
	public int getEventCoverage(int ev_id) {
		String sql = "select ev_cov from TRMSEvents where ev_id=?;";
		int out = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ev_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				out = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
		
	}
}
