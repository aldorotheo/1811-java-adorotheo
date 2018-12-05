package com.trms.servlet;

import java.io.IOException;
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
		System.out.println(path);
		if("/Project1/trms/manage".equals(path)) {
			//return entire user list
			HttpSession s = request.getSession();
			Employee emp = (Employee) s.getAttribute("user");
			List<Request> reqList = mServ.readRequests(emp.getEmp_id());
//			System.out.println(emp.getEmp_id());
//			System.out.println(reqList);
//			ObjectMapper om = new ObjectMapper();
//			String reqListJson = om.writeValueAsString(reqList);
			for (Request r : reqList) {
				response.getWriter().write(r.toString());		
			}
		}
		else {
			String req_id = path.substring(path.lastIndexOf("/")+1);
			
			Request req = mServ.readRequest(Integer.parseInt(req_id));
//			ObjectMapper om = new ObjectMapper();
//			String reqJson = om.writeValueAsString(req);
			response.getWriter().write(req.toString());
			
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
