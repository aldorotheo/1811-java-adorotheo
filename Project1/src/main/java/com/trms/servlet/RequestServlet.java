package com.trms.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.OffsetDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.db.FileDao;
import com.trms.service.FileService;
import com.trms.service.GradeService;
import com.trms.service.RequestService;
import com.trms.trms.Employee;
import com.trms.trms.Request;

public class RequestServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileJson;
		HttpSession s = req.getSession();
		Employee emp = (Employee) s.getAttribute("user");
		System.out.println(req.getParameter("date"));
		Date date = Date.valueOf(req.getParameter("date"));
		Time time = Time.valueOf(req.getParameter("time"));
		String loc = req.getParameter("loc");
		String desc = req.getParameter("desc");
		double cost = Double.parseDouble(req.getParameter("cost"));
		int pres = Integer.parseInt(req.getParameter("grad"));
		String grade = req.getParameter("grade");
		GradeService gs = new GradeService();
		int g_format = gs.getGradeId(pres, grade);
		int event = Integer.parseInt(req.getParameter("event"));
		String just = req.getParameter("just");
		String tmiss = req.getParameter("tmiss");
		String[] files = req.getParameterValues("files");
		FileService fs = new FileService();
		// System.out.println(req.getParameterNames());
		// ObjectMapper om = new ObjectMapper();
		// for (Part part : req.getParts()) {
		// System.out.println(part);
		// }
		RequestService rs = new RequestService();
		rs.createRequest(emp.getEmp_id(), date, time, loc, desc, cost, g_format, event, just, tmiss, 0);
		int req_id = rs.getRequestId();
		for (int i = 0; i < files.length; i++) {
			fs.insertFile(req_id, files[i]);
		}
		resp.sendRedirect("/manager.html");
//		RequestDispatcher rd = req.getRequestDispatcher("/manager.html");
//		rd.forward(req, resp);
	}
}