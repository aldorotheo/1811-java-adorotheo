package com.trms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.service.AlertService;
import com.trms.trms.Alert;
import com.trms.trms.Employee;
import com.trms.trms.Request;

public class MessageServlet extends HttpServlet {
	private static AlertService aServ = new AlertService();
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		Employee emp = (Employee) s.getAttribute("user");
		String path = req.getRequestURI();
		ObjectMapper om = new ObjectMapper();
		if ("/Project1/trms/message/send".equals(path)) {
			aServ.sendMessage(emp.getEmp_id(), Integer.parseInt(req.getParameter("receiver")), req.getParameter("message"));
			if (emp.getEmp_type() == 3) {
				resp.sendRedirect("/Project1/manage.html");
				return;
			}
			else if (emp.getEmp_type() != 3) {
				resp.sendRedirect("/Project1/manager.html");
				return;
			}
		}
		else if ("/Project1/trms/message".equals(path)) {
			List<Alert> messageList = aServ.readAllMessages(emp.getEmp_id());
			String messageListjson = om.writeValueAsString(messageList);
			System.out.println(messageListjson);
			resp.getWriter().write(messageListjson);
		}
		else if ("/Project1/trms/message/unread".equals(path)) {
			List<Alert> messageList = aServ.readUnreadMessages(emp.getEmp_id());
			String messageListjson = om.writeValueAsString(messageList);
			System.out.println(messageListjson);
			resp.getWriter().write(messageListjson);
		}
	}

}
