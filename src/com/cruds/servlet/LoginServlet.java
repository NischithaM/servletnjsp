package com.cruds.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.db.UserDAO;
import com.cruds.entity.Department;
import com.cruds.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//System.out.println(username +":" +password);

		session.setAttribute("username", username);
		session.setAttribute("password", password);
		UserDAO dao=new UserDAO();
		User u=new User(username, password);
		PrintWriter out =response.getWriter();
		if(dao.login(u))
		{	
				User role=dao.getRole(username);
				session.setAttribute("MESSAGE","  hi "+ username+ "  "+ role);
				getServletContext().setAttribute("user",new User("ADMIN"));
				RequestDispatcher rd=request.getRequestDispatcher("LoginSuccess.jsp");
				rd.forward(request, response);

		}else
		{
			session.setAttribute("MESSAGE", "INVALID CREDENTIALS");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}

		doGet(request, response);
	}

}
