package com.trms.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.service.ManagerService;
import com.trms.trms.Employee;
import com.trms.trms.Request;

/**
 * Servlet implementation class ManagerServlet
 */
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ManagerService mServ = new ManagerService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getRequestURI();
		if("/Project1/trms/manage".equals(path)) {
			//return entire user list
			HttpSession s = request.getSession();
			Employee emp = (Employee) s.getAttribute("user");
			ObjectMapper om = new ObjectMapper();
			List<Request> reqList = mServ.readRequests(emp.getEmp_id());
			String reqListjson = om.writeValueAsString(reqList);
			response.getWriter().write(reqListjson);		
		}
		else if("/Project1/trms/manage/emp".equals(path)) {
			//return entire user list
			HttpSession s = request.getSession();
			Employee emp = (Employee) s.getAttribute("user");
			ObjectMapper om = new ObjectMapper();
			List<Request> reqList = mServ.readEmployeeRequests(emp.getEmp_id(), emp.getEmp_type());
			String reqListjson = om.writeValueAsString(reqList);
			response.getWriter().write(reqListjson);	
		}
		else if ("/Project1/trms/manage/current".equals(path)) {
			HttpSession s = request.getSession();
			Employee emp = (Employee) s.getAttribute("user");
			ObjectMapper om = new ObjectMapper();
			List<Request> reqList = mServ.readCurrentRequests(emp.getEmp_id(), emp.getEmp_type());
			String reqListjson = om.writeValueAsString(reqList);
			response.getWriter().write(reqListjson);
		}
		else {
			String req_id = path.substring(path.lastIndexOf("/")+1);
			ArrayList<Request> al= new ArrayList<Request>();
			Request req = mServ.readRequest(Integer.parseInt(req_id));
			al.add(req);
			ObjectMapper om = new ObjectMapper();
			String reqJson = om.writeValueAsString(al);
			response.getWriter().write(reqJson);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
