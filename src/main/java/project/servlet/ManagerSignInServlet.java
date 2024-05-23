package project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.controller.ManagerSignInController;
import project.model.SignInModel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SignInServlet
 */
public class ManagerSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerSignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
		SignInModel model=new SignInModel();
		model.setusername(username);
		model.setpassword(password);
		ManagerSignInController control=new ManagerSignInController(model);
		if(control.get()) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("name", control.name);
			System.out.println("Login Success");
			if(model.getusername().equals("admin"))
			{
			//	request.getRequestDispatcher("AdminAddEmployee.jsp").forward(request, response);
				response.sendRedirect("AdminAddEmployee.jsp");
			}
			
			else
			{
			//	request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				response.sendRedirect("AddEmployee.jsp");
			}
				
				
		}
		else if(control.checkexists()){
			System.out.println("Sign In Fail exists");
			request.setAttribute("signinfailinvalid", "");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}		
		else {
			System.out.println("Sign In Fail");
			request.setAttribute("signinfail", "");
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
