package project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.controller.DisplayEmployeeController;

import java.io.IOException;

/**
 * Servlet implementation class DisplayEmployeeServlet
 */
public class DisplayEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEmployeeServlet() {
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
			String addby = (String)session.getAttribute("username");
			DisplayEmployeeController control=new DisplayEmployeeController(addby);
			if(control.getempdata()) {
				//request.setAttribute("username",model.getusername());
				System.out.println("getempdata Success");
					request.setAttribute("empList", control.empList);
					if(session.getAttribute("username").toString().equals("admin"))
					{
						request.getRequestDispatcher("AdminEmployee.jsp").forward(request, response);
					}
					
					else
					{
						request.getRequestDispatcher("ManagerEmployee.jsp").forward(request, response);
						
					}
						
			}	
			else {
				System.out.println("getempdata Fail");
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
