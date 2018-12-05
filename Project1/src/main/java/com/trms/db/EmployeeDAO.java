package com.trms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trms.trms.Employee;

public class EmployeeDAO {
	private static Connection conn = ConnectionFactory.getConnectionFactory().createConnection();

	public Employee login(String username, String password) {
		String sql = "select * from TRMSEmp where username = ? and pass = crypt(?, (select pass where username = ?));";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2,  password);
			stmt.setString(3, username);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Employee output = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDouble(8), rs.getInt(9));
				return output;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Employee();
	}
	
	public Employee readEmployee(int emp_id) {
		String sql = "select * from TRMSEmp where emp_id = ?;";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, emp_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Employee output = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDouble(8), rs.getInt(9));
				return output;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Employee();
	}
	
	public double getBalance(int emp_id) {
		String sql = "select balance from TRMSEmp where emp_id = ?;";
		double output = 0.0;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, emp_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				output = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public void updateBalance(int emp_id, double balance) {
		String sql = "update TRMSEmp set balance=? where emp_id=?;";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(2, emp_id);
			stmt.setDouble(1, balance);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
