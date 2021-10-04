package com.aha.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aha.dao.ApplicantDao;
import com.aha.dao.UserDao;
import com.aha.daoimpl.ApplicantDaoImpl;
import com.aha.daoimpl.UserDaoImpl;
import com.aha.model.UserBean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private String userType;
    private final String U_TYPE = "STUDENT";
	public static boolean listIsUploaded = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		RequestDispatcher view = req.getRequestDispatcher("Login.jsp");
		userDao = new UserDaoImpl();
		
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		user.setUserType(U_TYPE);
		
	
		userType = userDao.getUserType(username);
		System.out.println("user: "+username+" Type: "+userType);
		
		if(userType==null || userType=="") {
			if(username.contains("18sw")) {
				userDao.addUser(user);
				view = req.getRequestDispatcher("register.jsp");
			}
			else {
				view = req.getRequestDispatcher("error.jsp");
			}
		}
		else if(userType.equalsIgnoreCase("admin"))
		{
			if(userDao.authenticateUser(username, password)!=0)
				view = req.getRequestDispatcher("adminForm.jsp");	
			else
				view = req.getRequestDispatcher("error.jsp");
		}
		else if(userType.equalsIgnoreCase("student"))
		{
			if(userDao.authenticateUser(username, password)!=0) {
				System.out.println("user authenticated!");
				if(userDao.isRegistered(username)) 
				{
					System.out.println("User has registered already!");
					ApplicantDao applicantDAO = new ApplicantDaoImpl();
					
					if(applicantDAO.getApplicantFeesStatus(username).equalsIgnoreCase("paid")) {
						req.setAttribute("fPaid", "true");
					}
					else {
						req.setAttribute("fPaid", "false");
						req.setAttribute("rollNo", user.getUsername());
						System.out.println(username+req.getAttribute("rollNo"));
					}
					
//					if(listIsUploaded && )
					view = req.getRequestDispatcher("afterRegistering.jsp");
				}
				else {
					view = req.getRequestDispatcher("register.jsp");
				}
			}
			else 
				view = req.getRequestDispatcher("error.jsp");
			
		}
		else {
			System.out.println("User Does Not Exist!");
		}
		view.forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
