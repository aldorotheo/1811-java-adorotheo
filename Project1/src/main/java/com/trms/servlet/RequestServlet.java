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
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileJson;
		HttpSession s = req.getSession();
		Employee emp = (Employee) s.getAttribute("user");
		System.out.println(req.getParameter("date"));
		String dater = (req.getParameter("date"));
		Date date = null;
		if (dater!=null)
			date = Date.valueOf(dater);
		Time time = null;
		String timer = (req.getParameter("time"));
		if (timer!=null)
			time = Time.valueOf(timer);
		String loc = req.getParameter("loc");
		String desc = req.getParameter("desc");
		String coster = req.getParameter("cost");
		double cost=0.0;
		if (coster!=null)
			cost = Double.parseDouble(coster);
		String preser = req.getParameter("grad");
		int pres=0;
		if (preser!=null)
			pres = Integer.parseInt(preser);
		String grade = req.getParameter("grade");
		GradeService gs = new GradeService();
		int g_format = gs.getGradeId(pres, grade);
		String eventer = (req.getParameter("event"));
		int event=0;
		if (eventer!=null)
			event = Integer.parseInt(eventer);
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
		resp.sendRedirect("/Project1/manage.html");
		return;
//		RequestDispatcher rd = req.getRequestDispatcher("/manage.html");
//		rd.forward(req, resp);
//		return;
	}
}