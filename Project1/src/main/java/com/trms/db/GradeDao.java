package com.trms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;

import com.trms.trms.Grade;
import com.trms.trms.Request;

public class GradeDao {
	private static Connection conn = ConnectionFactory.getConnectionFactory().createConnection();
	public void createGrade(Grade grade) {
		String sql = "insert into TRMSgrading (g_type, pass) values (?,?);";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, grade.getGrade_type());
			stmt.setString(2, grade.getPassing());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int findGradeID(Grade grade) {
		String sql = "select g_id from TRMSgrading where g_type=? and pass=?;";
		int out = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, grade.getGrade_type());
			stmt.setString(2, grade.getPassing());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				out = rs.getInt(1);
			}
//			else {
//				createGrade(grade);
//				out = findGradeID(grade);
//				return out;
//			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return out;
	}
	public Grade getGradebyID(int id) {
		String sql = "select * from TRMSgrading where g_id=?;";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Grade out = new Grade(rs.getInt(1), rs.getInt(2), rs.getString(3));
				return out;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
