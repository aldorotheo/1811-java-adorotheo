package com.trms.trms;

public class Employee {
	private int emp_id;
	private int supervisor;
	private int depthead;
	private String fname = "";
	private String lname = ""; 
	private String username = "";
	private String pass = "";
	private double balance;
	private int emp_type;

	public int getEmp_id() {
		return emp_id;
	}

	public int getSupervisor() {
		return supervisor;
	}

	public int getDepthead() {
		return depthead;
	}

	public String getFname() {
		return fname;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", supervisor=" + supervisor + ", depthead=" + depthead + ", fname="
				+ fname + ", lname=" + lname + ", username=" + username + ", pass=" + pass + ", balance=" + balance
				+ ", emp_type=" + emp_type + "]";
	}

	public Employee(int emp_id, String fname, String lname, String username, String pass, int supervisor, int depthead,
			double balance, int emp_type) {
		super();
		this.emp_id = emp_id;
		this.supervisor = supervisor;
		this.depthead = depthead;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.pass = pass;
		this.balance = balance;
		this.emp_type = emp_type;
	}

	public int getEmp_type() { // used to read which type of login should be handled. benco, employee,
								// supervisor, or depthead. benco is 0, depthead is 1, supervisor is 2, employee
								// is 3
		return emp_type;
	}

	public Employee() {
	}

	public String getLname() {
		return lname;
	}

	public String getUsername() {
		return username;
	}

	public String getPass() {
		return pass;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
