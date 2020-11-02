package com.cruds.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cruds.db.StudentDAO;
import com.cruds.entity.Student;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> list=new StudentDAO().getAll();
		request.setAttribute("STUD_LIST", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("student.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no=request.getParameter("rollno");
		String sname=request.getParameter("name");
		System.out.println(no +":" +sname);

		StudentDAO dao=new StudentDAO();
		Student d=new Student(Integer.parseInt(no), sname);
		PrintWriter out =response.getWriter();
		if(dao.create(d))
		{
			request.setAttribute("MESSAGE", "SUCCESSFUL CREATION");

		}else
		{
			request.setAttribute("MESSAGE", "ERROR ");
		}

		doGet(request, response);
	}

		
	}

