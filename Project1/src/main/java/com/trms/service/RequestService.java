package com.trms.service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

import com.trms.db.EmployeeDAO;
import com.trms.db.EventDao;
import com.trms.db.RequestDAO;
import com.trms.trms.Request;

public class RequestService {
	private RequestDAO dao = new RequestDAO();
	private EventDao edao = new EventDao();
	private EmployeeDAO emdao = new EmployeeDAO();
	public void createRequest(int emp_id, Date s_date, Time s_time, String s_location,
			String description, double s_cost, int g_format, int ev_type, String just, String t_missed, int status) {
		int coverage = edao.getEventCoverage(ev_type);
		double balance = emdao.getBalance(emp_id);
		double reimbursementAmount = s_cost * (coverage/100.0);
		if (reimbursementAmount > balance)
			reimbursementAmount = balance;
		balance = balance - reimbursementAmount;
		emdao.updateBalance(emp_id, balance);
		Request req = new Request(emp_id, s_date, s_time, s_location,
				description, reimbursementAmount,g_format, ev_type,just,t_missed,status); 
		dao.createRequest(req);
	}
	
	public int getRequestId() {
		return dao.getRequestId();
	}
	
	public void updateRequest(Request req, Request original) {
		if (req.getS_cost()!=0.0) {
			double s_cost = req.getS_cost();
			int ev_type = req.getEv_type();
			int emp_id = req.getEmp_id();
			int coverage = edao.getEventCoverage(ev_type);
			double balance = emdao.getBalance(emp_id);
			double reimbursementAmount = s_cost * (coverage/100.0);
			balance = balance + original.getS_cost();
			emdao.updateBalance(req.getEmp_id(), balance);
			if (reimbursementAmount > balance)
				reimbursementAmount = balance;
			balance = balance - reimbursementAmount;
			emdao.updateBalance(emp_id, balance);
		}
		dao.updateRequest(req);
	}
	
	public Request readRequestById(int id) {
		Request r = dao.readRequestById(id);
		return r;
	}
	
	public void acceptRequest(int req_id, int emp_id, int emp_type, boolean accept) {
		dao.acceptRequest(req_id, emp_id, emp_type, accept);
	}
	
}
