package com.trms.service;

import com.trms.db.EmployeeDAO;
import com.trms.trms.Employee;

public class AuthService {
	private EmployeeDAO dao = new EmployeeDAO();
	private static LogService lServ = new LogService();
	public Employee login(String user, String pass) {
		Employee out = dao.login(user, pass);
		lServ.log(user + " attempted to login");
		return out;
	}
}
