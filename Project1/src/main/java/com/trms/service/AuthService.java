package com.trms.service;

import com.trms.db.EmployeeDAO;
import com.trms.trms.Employee;

public class AuthService {
	private EmployeeDAO dao = new EmployeeDAO();
	public Employee login(String user, String pass) {
		Employee out = dao.login(user, pass);
		return out;
	}
	String yes = "yes";
	if (yes.equals("yes")){
		yes = "no";
	}
}
