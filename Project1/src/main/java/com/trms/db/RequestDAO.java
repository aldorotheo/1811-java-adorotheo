package com.trms.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.trms.trms.Request;

public class RequestDAO {
	private static Connection conn = ConnectionFactory.getConnectionFactory().createConnection();

	public List<Request> readRequests(int emp_id) {
		String sql = "select * from TRMSReqs where emp_id = ?;";
		ArrayList<Request> output = new ArrayList<Request>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, emp_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LocalDateTime ldt = rs.getTimestamp(5).toLocalDateTime();
				Request out = new Request(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getTime(4), ldt,
						rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getInt(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getString(14));
				
				output.add(out);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	public Request readRequestById(int req_id) {
		String sql = "select * from TRMSReqs where req_id=?;";
		Request output = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, req_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				output = new Request(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getTime(4),
						rs.getTimestamp(5).toLocalDateTime(), rs.getString(6), rs.getString(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getString(14));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	public int getRequestId() {
		String sql = "select * from trmsreqs order by a_date desc limit 1;";
		int output = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				output = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	public void createRequest(Request req) {
		String sql = "insert into TRMSReqs (emp_id,s_date,s_time,a_date,s_location,description,s_cost,g_format,ev_type,just,t_missed,status,urgency) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			Timestamp now = new Timestamp(System.currentTimeMillis());
			LocalDateTime then = now.toLocalDateTime();
			LocalDateTime then2 = then.plusWeeks(2);
			LocalDateTime then1 = then.plusWeeks(1);
			LocalDateTime submitted = LocalDateTime.of(req.getS_date().toLocalDate(), req.getS_time().toLocalTime());
			if (submitted.isAfter(then1)) {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, req.getEmp_id());
				stmt.setDate(2, req.getS_date());
				stmt.setTime(3, req.getS_time());
				stmt.setTimestamp(4, now);
				stmt.setString(5, req.getS_location());
				stmt.setString(6, req.getDescription());
				stmt.setDouble(7, req.getS_cost());
				stmt.setInt(8, req.getG_format());
				stmt.setInt(9, req.getEv_type());
				stmt.setString(10, req.getJust());
				stmt.setString(11, req.getT_missed());
				stmt.setInt(12, req.getStatus());
				if (submitted.isBefore(then2)) {
					stmt.setInt(13, 1);
				} else {
					stmt.setInt(13, 0);
				}
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateRequest(Request req) {
		String sql = "update TRMSReqs set s_date=?, s_time=?, s_location=?, description=?, s_cost=?, g_format=?, ev_type=?, just=?, t_missed=?, urgency=?, finalg=? where req_id=? and emp_id=?;";
		PreparedStatement stmt;
		try {
			Timestamp now = new Timestamp(System.currentTimeMillis());
			LocalDateTime then = now.toLocalDateTime();
			LocalDateTime then2 = then.plusWeeks(2);
			LocalDateTime then1 = then.plusWeeks(1);
			LocalDateTime submitted = LocalDateTime.of(req.getS_date().toLocalDate(), req.getS_time().toLocalTime());
			if (submitted.isAfter(then1)) {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(13, req.getEmp_id());
				stmt.setDate(1, req.getS_date());
				stmt.setTime(2, req.getS_time());
				//stmt.setTimestamp(4, now);
				stmt.setString(3, req.getS_location());
				stmt.setString(4, req.getDescription());
				stmt.setDouble(5, req.getS_cost());
				stmt.setInt(6, req.getG_format());
				stmt.setInt(7, req.getEv_type());
				stmt.setString(8, req.getJust());
				stmt.setString(9, req.getT_missed());
				//stmt.setInt(10, req.getStatus());
				stmt.setString(11, req.getFinalg());
				stmt.setInt(12, req.getReq_id());
				if (submitted.isBefore(then2)) {
					stmt.setInt(10, 1);
				} else {
					stmt.setInt(10, 0);
				}
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
