package com.aha.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aha.classes.Allotee;
import com.aha.classes.AllotmentAlgorithm;
import com.aha.classes.Room;
import com.aha.dao.AlloteeDao;
import com.aha.daoimpl.AlloteeDaoImpl;

/**
 * Servlet implementation class AllotmentController
 */
@WebServlet("/AllotmentController")
public class AllotmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllotmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlloteeDao alloteeDAO = new AlloteeDaoImpl();
		List<Allotee> applicants = alloteeDAO.getAllAllotees();
		
		AllotmentAlgorithm alotter = new AllotmentAlgorithm();
		List<Room> rooms = alotter.alotApplicants(applicants);
		LoginController.listIsUploaded = true;
		request.setAttribute("rooms", rooms);
		RequestDispatcher view = request.getRequestDispatcher("hostelList.jsp");
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
