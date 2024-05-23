package project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import project.controller.LeaveBalanceController;


import java.io.IOException;

/**
 * Servlet implementation class DisplayLeaveBalanceServlet
 */
public class DisplayLeaveBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayLeaveBalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			LeaveBalanceController control=new LeaveBalanceController((String)session.getAttribute("username"));
			if(control.getleavedata()) {
				//request.setAttribute("username",model.getusername());
				System.out.println("getleavedata Success");
					request.setAttribute("List", control.List);
					request.getRequestDispatcher("LeaveBalance.jsp").forward(request, response);
			}	
			else {
				System.out.println("getleavedata Fail");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("index.jsp");
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
