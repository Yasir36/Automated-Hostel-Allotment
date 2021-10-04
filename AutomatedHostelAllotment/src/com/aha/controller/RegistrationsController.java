package com.aha.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aha.dao.StudentDao;
import com.aha.dao.UserDao;
import com.aha.daoimpl.StudentDaoImpl;
import com.aha.daoimpl.UserDaoImpl;
import com.aha.model.StudentBean;


@WebServlet("/RegistrationFormController")
public class RegistrationsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao students;
	private StudentBean student;
    public RegistrationsController() {
        super();
        students = new StudentDaoImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String surname = request.getParameter("surname");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String cnic = request.getParameter("CNIC");
		String guardianName = request.getParameter("guardianName");
		String guardianCNIC = request.getParameter("guardianCNIC");
		String currentAddress = request.getParameter("currentAddress");
		String permanentAddress = request.getParameter("permanentAddress");
		String district = request.getParameter("district");
		int postalCode = Integer.parseInt(request.getParameter("postalCode"));
		String rollNo = request.getParameter("rollNo");
		String dept = request.getParameter("dept");
		String email = request.getParameter("email");
		
		student = new StudentBean(firstName,lastName,fatherName,surname,dateOfBirth,cnic,
								  district,currentAddress,permanentAddress,postalCode,
								  guardianName,guardianCNIC,rollNo,dept,email,0);
		if(students.addStudent(student)>0) {
			UserDao userDAO = new UserDaoImpl();
			System.out.println("Student Added Succesfully");
			userDAO.registerStudent(rollNo, "Registered");
			request.setAttribute("fPaid", "false");
			request.setAttribute("rollNo",rollNo);
			RequestDispatcher view= request.getRequestDispatcher("afterRegistering.jsp");
			view.forward(request, response);
		}
		else {
			RequestDispatcher view= request.getRequestDispatcher("register.jsp");
			view.forward(request, response);
			System.out.println("Student Not Added!");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
