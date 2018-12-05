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
}
