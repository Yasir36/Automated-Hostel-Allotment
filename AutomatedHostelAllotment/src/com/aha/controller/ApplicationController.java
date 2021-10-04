package com.aha.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aha.dao.ApplicantDao;
import com.aha.dao.StudentDao;
import com.aha.daoimpl.ApplicantDaoImpl;
import com.aha.daoimpl.StudentDaoImpl;
import com.aha.model.ApplicantBean;


/**
 * servlet implementation class ApplicationController
 */
@WebServlet("/ApplicationController")
public class ApplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String getApprovedApplicants = request.getParameter("getApprovedApplicants");
		String action = request.getParameter("action");
		RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
		ApplicantDao applicantDAO = new ApplicantDaoImpl();
		
		if(getApprovedApplicants==null)
			getApprovedApplicants="";
		
		if(action==null)
			action="";
		
		if(action.equalsIgnoreCase("approve"))
		{
			StudentDao studentDAO = new StudentDaoImpl();
			studentDAO.approveStudent(Integer.parseInt(request.getParameter("id")), 1);
			request.setAttribute("operation", "approve");
			request.setAttribute("applicants", applicantDAO.getUnapprovedApplicants());
			view = request.getRequestDispatcher("applications.jsp");
		}
		else if(action.equalsIgnoreCase("reject"))
		{
			StudentDao studentDAO = new StudentDaoImpl();
			studentDAO.approveStudent(Integer.parseInt(request.getParameter("id")), 0);
			request.setAttribute("operation", "reject");
			request.setAttribute("applicants", applicantDAO.getApprovedApplicants());
			view = request.getRequestDispatcher("applications.jsp");
		}
		else if(getApprovedApplicants.equals("true"))
		{
			List<ApplicantBean> applicants = applicantDAO.getUnapprovedApplicants();
			request.setAttribute("applicants", applicants);
			request.setAttribute("operation", "approve");
			view = request.getRequestDispatcher("applications.jsp");
		}
		else if(getApprovedApplicants.equals("false"))
		{
			List<ApplicantBean> applicants = applicantDAO.getApprovedApplicants();
			request.setAttribute("applicants", applicants);
			request.setAttribute("operation", "reject");
			view = request.getRequestDispatcher("applications.jsp");
		}
		else {
			String rollNo = request.getParameter("rollNo");
			ApplicantBean applicant = new ApplicantBean();
			applicant.setRollNo(rollNo);
		
			applicant.setFeesStatus("paid");
			if(applicantDAO.addApplicant(applicant)>0) {
				System.out.println("applicant added!");
				request.setAttribute("fPaid", "true");
				view = request.getRequestDispatcher("afterRegistering.jsp");
			}
			else {
				view = request.getRequestDispatcher("error.jsp");
			}
		}
		
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
