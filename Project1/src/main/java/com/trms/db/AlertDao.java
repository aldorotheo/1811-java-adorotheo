package com.trms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trms.trms.Alert;

public class AlertDao {
	private static Connection conn = ConnectionFactory.getConnectionFactory().createConnection();
	public List<Alert> readAllMessages(int emp_id) {
		ArrayList<Alert> al = new ArrayList<Alert>();
		String sql = "select * from TRMSAlerts where toemp_id=?;";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, emp_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				al.add(new Alert(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
	}
	
	public List<Alert> readUncheckedMessages(int emp_id) {
		ArrayList<Alert> al = new ArrayList<Alert>();
		String sql = "select * from TRMSAlerts where toemp_id=? and checked = 0;";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, emp_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				al.add(new Alert(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
			}
			sql = "update TRMSAlerts set checked=1 where toemp_id=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, emp_id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	
	public void sendMessage(int emp_id, int receiver, String message) {
		String sql = "insert into TRMSAlerts (emp_id, toemp_id, msg, checked) values (?, ?, ?, 0);";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, emp_id);
			stmt.setInt(2, receiver);
			stmt.setString(3, message);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
