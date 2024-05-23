package project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.controller.AddManagerController;
import project.model.ManagerDataModel;

import java.io.IOException;

/**
 * Servlet implementation class AddManagerServlet
 */
public class AddManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddManagerServlet() {
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
			ManagerDataModel model=new ManagerDataModel();
			model.setusername(request.getParameter("managerID"));
			model.setname(request.getParameter("managerName"));
			model.setemail(request.getParameter("emailID"));
			if(new AddManagerController(model).store())
			{
				
				System.out.println("Addmanager Success");
				request.getRequestDispatcher("AdminAddManager.jsp").forward(request, response);
			}
			else
			{
				System.out.println("AddManager Fail");
				request.getRequestDispatcher("AddManager Fail").forward(request, response);
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
