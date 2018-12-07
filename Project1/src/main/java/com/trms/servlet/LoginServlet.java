package com.trms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trms.service.AuthService;
import com.trms.trms.Employee;

public class LoginServlet extends HttpServlet {
	private AuthService auth = new AuthService();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		Employee emp = auth.login(user, pass);
		if (!emp.getUsername().isEmpty()) {
			HttpSession sess = req.getSession();
			sess.setAttribute("user", emp);
			if (emp.getEmp_type() != 3) {
				resp.sendRedirect("/Project1/manager.html");
				return;
			} else {
				resp.sendRedirect("/Project1/manage.html");
				return;
			}
			// RequestDispatcher rd = req.getRequestDispatcher("/manager.html");
			// rd.forward(req, resp);
		} else {
			resp.getWriter().write("<h1>Sorry, we didn't recognize your username or password.</h1>");
		}
	}
}
