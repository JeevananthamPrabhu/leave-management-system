package project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.controller.DisplayManagerController;

import java.io.IOException;

/**
 * Servlet implementation class DisplayManagerServlet
 */
public class DisplayManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayManagerServlet() {
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
			DisplayManagerController control=new DisplayManagerController();
			if(control.getdata()) {
				//request.setAttribute("username",model.getusername());
				System.out.println("getmanagerdata Success");
					request.setAttribute("managerList", control.managerList);
					request.getRequestDispatcher("AdminManager.jsp").forward(request, response);
			}	
			else {
				System.out.println("getmanagerdata Fail");
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
