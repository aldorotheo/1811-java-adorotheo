package com.trms.service;

import java.util.List;

import com.trms.db.RequestDAO;
import com.trms.trms.Request;

public class ManagerService {
	private RequestDAO rdao = new RequestDAO();
	public Request readRequest(int req_id) {
		return rdao.readRequestById(req_id);
	}
	
	public List<Request> readRequests(int emp_id) {
		return rdao.readRequests(emp_id);
	}
	
	public List<Request> readEmployeeRequests(int emp_id, int emp_type) {
		return rdao.readEmployeeRequests(emp_id, emp_type);
	}

	public List<Request> readCurrentRequests(int emp_id, int emp_type) {
		return rdao.readCurrentRequests(emp_id, emp_type);
	}
}
