package com.trms.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trms.service.FileService;
import com.trms.service.GradeService;
import com.trms.service.RequestService;
import com.trms.trms.Employee;
import com.trms.trms.Request;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPut(request, response);
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		int req_id = Integer.parseInt(req.getParameter("req_id"));
		RequestService rs = new RequestService();
		Request r = rs.readRequestById(req_id);
		Employee emp = (Employee) s.getAttribute("user");
		Date date = Date.valueOf(req.getParameter("date"));
		if(date==null)
			date = r.getS_date();
		String timer = (req.getParameter("time"));
		Time time;
		if(timer==null)
			time = r.getS_time();
		else
			time = Time.valueOf(timer);
		String loc = req.getParameter("loc");
		if(loc==null)
			loc = r.getS_location();
		String desc = req.getParameter("desc");
		if(desc==null)
			desc = r.getDescription();
		String coster = (req.getParameter("cost"));
		double cost;
		if (coster==null) {
			cost = r.getS_cost();
		}
		else
			cost = Double.parseDouble(coster);
		int pres = Integer.parseInt(req.getParameter("grad"));
		String grade = req.getParameter("grade");
		GradeService gs = new GradeService();
		int g_format = gs.getGradeId(pres, grade);
		if(g_format==0)
			g_format=r.getG_format();
		int event = Integer.parseInt(req.getParameter("event"));
		if(event==0)
			event=r.getEv_type();
		String just = req.getParameter("just");
		if(just==null)
			just=r.getJust();
		String tmiss = req.getParameter("tmiss");
		if(tmiss=="0")
			tmiss=r.getT_missed();
		String finalg = req.getParameter("finalg");
		if (finalg==null)
			finalg = r.getFinalg();
		String[] files = req.getParameterValues("files");
		FileService fs = new FileService();
		Request request = new Request(req_id, emp.getEmp_id(), date, time, LocalDateTime.now(), loc, desc, cost, g_format, event, just, tmiss, 0, finalg);
		rs.updateRequest(request);
		for (int i = 0; i < files.length; i++) {
			fs.insertFile(req_id, files[i]);
		}
		resp.sendRedirect("/manager.html");
//		RequestDispatcher rd = req.getRequestDispatcher("/manager.html");
//		rd.forward(req, resp);
	}
	

}
