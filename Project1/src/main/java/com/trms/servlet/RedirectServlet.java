package com.trms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trms.trms.Employee;

public class RedirectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		Employee emp = (Employee) sess.getAttribute("user");
		if (emp.getEmp_type() != 3) {
			resp.sendRedirect("/Project1/manager.html");
			return;
		} else {
			resp.sendRedirect("/Project1/manage.html");
			resp.sendRedirect("/Project1/login.html");
			return;
		}
	}
}