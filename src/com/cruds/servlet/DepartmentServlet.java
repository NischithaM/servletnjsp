package com.cruds.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cruds.db.DepartmentDAO;
import com.cruds.entity.Department;

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Department> list=new DepartmentDAO().getAll();
		request.setAttribute("DEPT_LIST", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("department.jsp");

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("ACTION");
		DepartmentDAO dao=new DepartmentDAO();
		if("CREATE".equals(action))
		{
			String dno=request.getParameter("deptid");
			String dname=request.getParameter("deptname");
			System.out.println(dno +":" +dname);
			
			
			Department d=new Department(Integer.parseInt(dno), dname);
			
			if(dao.create(d))
			{
				request.setAttribute("MESSAGE", "SUCCESSFUL CREATION");

			}else
			{
				request.setAttribute("MESSAGE", "ERROR ");
				
			}
		}
		/*String dno=request.getParameter("deptno");
		String dname=request.getParameter("deptname");
		System.out.println(dno +":" +dname);

		DepartmentDAO dao=new DepartmentDAO();
		Department d=new Department(Integer.parseInt(dno), dname);
		PrintWriter out =response.getWriter();
		//out.println("WELCOME TO  "+dno +":" + dname);
		if(dao.create(d))
		{
			//out.println(" SUCCESS ");
			out.println("<html><head><title>success</title></head>");
			out.println("<body><h1>SUCCESS</h1></body>");
			out.println("</html>");
			request.setAttribute("MESSAGE", "SUCCESSFUL CREATION");

		}else
		{
			request.setAttribute("MESSAGE", "ERROR ");
			out.println("ERROR");
		}

		RequestDispatcher rd=request.getRequestDispatcher("department.jsp");

		rd.forward(request, response);
		*/
		
		if("DELETE".equals(action))
		{
			
			String id=request.getParameter("hdnDeptId");
			
			//System.out.println("DELETE" +id);
			
			
			if(dao.delete(Integer.parseInt(id)))
			{
				request.setAttribute("MESSAGE", "DELETE SUCCESS");
			}
			else
			{
				request.setAttribute("MESSAGE","DELETE ERROR");
			}
			
		}
		if("UPDATE".equals(action))
		{
			String id=request.getParameter("deptid");
			String name=request.getParameter("deptname");
			
			//System.out.println("UPDATE" +name);
			
			Department d=new Department(Integer.parseInt(id),name);
			
			if(dao.update(d))
			{
				request.setAttribute("MESSAGE", "UPDATE SUCCESS");
			}
			else
			{
				request.setAttribute("MESSAGE", "UPDATE ERROR");
			}
			
			
		}
		doGet(request, response);
	}

}
