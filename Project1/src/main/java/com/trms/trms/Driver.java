package com.trms.trms;

import com.trms.db.EmployeeDAO;

public class Driver {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee tim = dao.login("timmy","pass");
		if(tim.getUsername().isEmpty()) {
			System.out.println("Login failed");
		}
		else {
		System.out.println(tim);
		}
	}

}
