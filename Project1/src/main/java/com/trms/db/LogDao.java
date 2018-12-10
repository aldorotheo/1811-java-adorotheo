package com.trms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogDao {
	private static Connection conn = ConnectionFactory.getConnectionFactory().createConnection();
	public void log(String log) {
		String sql = "insert into TRMSLogs (logdesc, logtime) values (?, 'now');";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, log);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
