package project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.controller.ActionLeaveController;
import project.controller.AddEmployeeController;
import project.model.EmployeeDataModel;
import project.model.LeaveDataModel;

import java.io.IOException;

/**
 * Servlet implementation class ActionLeaveServlet
 */
public class ActionLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionLeaveServlet() {
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
			
		LeaveDataModel model=new LeaveDataModel();
		model.setleaveid(request.getParameter("leaveid"));
		model.setstatus(Integer.parseInt(request.getParameter("action")));
		if(new ActionLeaveController(model).setaction())
		{
			
			System.out.println("Setaction Success");
			request.getRequestDispatcher("DisplayLeaveServlet").forward(request, response);
		}
		else
		{
			System.out.println("Setaction Fail");
			response.sendRedirect("index.jsp");
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
