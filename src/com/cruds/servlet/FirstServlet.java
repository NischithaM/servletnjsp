package com.cruds.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.entity.Department;

public class FirstServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("username");
		HttpSession session=req.getSession();
		//req.setAttribute("USER_NAME", name);
		session.setAttribute("USER_NAME", name);
		session.setAttribute("TEST_ATTR","testing");
		
		getServletContext().setAttribute("dept",new Department(10101,"xyz"));
	
		RequestDispatcher rd=req.getRequestDispatcher("second.jsp");
		rd.forward(req, resp);
	}

}
