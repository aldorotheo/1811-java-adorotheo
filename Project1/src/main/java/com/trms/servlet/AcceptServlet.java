package com.trms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trms.service.AlertService;
import com.trms.service.RequestService;
import com.trms.trms.Employee;
import com.trms.trms.Request;

/**
 * Servlet implementation class AcceptServlet
 */
public class AcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req,resp);
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getRequestURI();
		RequestService rs = new RequestService();
		HttpSession s = req.getSession();
		Employee emp = (Employee) s.getAttribute("user");
		int req_id = Integer.parseInt(req.getParameter("getID"));
		Request reee = rs.readRequestById(req_id);
		if("/Project1/trms/accept".equals(path)) {
			rs.acceptRequest(req_id, emp.getEmp_id(), emp.getEmp_type(), true);
		}
		else if("/Project1/trms/deny".equals(path)) {
			AlertService aServ = new AlertService();
			aServ.sendMessage(emp.getEmp_id(), reee.getEmp_id(), req.getParameter("reason"));
			rs.acceptRequest(req_id, emp.getEmp_id(), emp.getEmp_type(), false);
		}
		resp.sendRedirect("/Project1/manager.html");
		return;
	}

}
