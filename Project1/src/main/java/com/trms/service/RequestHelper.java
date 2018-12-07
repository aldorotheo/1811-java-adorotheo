package com.trms.service;

import javax.servlet.http.HttpServlet;

import com.trms.servlet.AcceptServlet;
import com.trms.servlet.EditServlet;
import com.trms.servlet.LoginServlet;
import com.trms.servlet.LogoutServlet;
import com.trms.servlet.ManagerServlet;
import com.trms.servlet.PageNotFoundServlet;
import com.trms.servlet.RedirectServlet;
import com.trms.servlet.RequestServlet;

public class RequestHelper {
	private static HttpServlet loginServlet = new LoginServlet();
	private static HttpServlet logoutServlet = new LogoutServlet();
	private static HttpServlet requestServlet = new RequestServlet();
	private static HttpServlet pageNotFoundServlet = new PageNotFoundServlet();
	private static HttpServlet managerServlet = new ManagerServlet();
	private static HttpServlet editServlet = new EditServlet();
	private static HttpServlet redirectServlet = new RedirectServlet();
	private static HttpServlet acceptServlet = new AcceptServlet();
	public HttpServlet dispatchRequest(String path) {
		HttpServlet nextServlet = null;
		switch(path) {
		case "/Project1/trms/login":
			nextServlet = loginServlet;
			break;
		case "/Project1/trms/logout":
			nextServlet = logoutServlet;
			break;
		case "/Project1/trms/request":
			nextServlet = requestServlet;
			break;
		case "/Project1/trms/manage":
			nextServlet = managerServlet;
			break;
		case "/Project1/trms/redirect":
			nextServlet = redirectServlet;
			break;
		case "/Project1/trms/edit":
			nextServlet = editServlet;
			break;
		case "/Project1/trms/deny":
			nextServlet = acceptServlet;
			break;
		case "/Project1/trms/accept":
			nextServlet = acceptServlet;
			break;
		default:
			if (path.contains("/Project1/trms/manage/")) {
				
				nextServlet = managerServlet;
				break;
			}
			nextServlet = pageNotFoundServlet;
		}
		return nextServlet;
	}
}
