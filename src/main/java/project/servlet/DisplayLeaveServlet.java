package project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.controller.DisplayLeaveController;
import project.controller.ManagerSignInController;
import project.model.SignInModel;

import java.io.IOException;

/**
 * Servlet implementation class DisplayLeaveServlet
 */
public class DisplayLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayLeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("username");
		if (session != null && session.getAttribute("username") != null) {
			
			SignInModel model=new SignInModel();
			model.setusername(username);
			DisplayLeaveController control=new DisplayLeaveController(model);
			if(session.getAttribute("empname") != null && control.getleavedata()) {
				//request.setAttribute("username",model.getusername());
					System.out.println("getleavedata Success");
					request.setAttribute("leaveList", control.leaveList);
					request.getRequestDispatcher("History.jsp").forward(request, response);
			}	
			else if(control.getallleavedata(username)) {
				System.out.println("getleavedata Success");
				request.setAttribute("leaveList", control.leaveList);
				
				if(session.getAttribute("username").toString().equals("admin"))
				{
					
					request.getRequestDispatcher("AdminManageLeave.jsp").forward(request, response);
				}
				
				else
				{
					request.getRequestDispatcher("ManagerManageLeave.jsp").forward(request, response);
					
				}
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
