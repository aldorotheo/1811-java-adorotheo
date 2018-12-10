package com.trms.service;

import java.util.List;

import com.trms.db.AlertDao;
import com.trms.trms.Alert;

public class AlertService {
	private static AlertDao dao = new AlertDao();
	private static LogService lServ = new LogService();
	public List<Alert> readAllMessages(int emp_id) {
		return dao.readAllMessages(emp_id);
	}
	public List<Alert> readUnreadMessages(int emp_id) {
		return dao.readUncheckedMessages(emp_id);
	}
	public void sendMessage(int emp_id, int receiver, String message) {
		dao.sendMessage(emp_id, receiver, message);
		lServ.log(emp_id + " sent " + message + " to " + receiver);
		
	}
}
