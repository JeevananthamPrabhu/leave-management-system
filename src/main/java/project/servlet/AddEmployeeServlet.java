package project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.controller.AddEmployeeController;
import project.model.EmployeeDataModel;

import java.io.IOException;

/**
 * Servlet implementation class AddEmployeeServlet
 */
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
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
			EmployeeDataModel model=new EmployeeDataModel();
			model.setempid(request.getParameter("employeeID"));
			model.setname(request.getParameter("employeeName"));
			model.setdept(request.getParameter("employeeDepartment"));
			String addby = (String)session.getAttribute("username");
			if(new AddEmployeeController(model,addby).store())
			{
				System.out.println("AddEmp Success");
				if(addby.equals("admin"))
				{
					response.sendRedirect("AdminAddEmployee.jsp");
					//request.getRequestDispatcher("AdminAddEmployee.jsp").forward(request, response);
				}
				else
				{
					response.sendRedirect("ManagerAddEmployee.jsp");
					//request.getRequestDispatcher("ManagerAddEmployee.jsp").forward(request, response);
				}					
			}
			else
			{
				System.out.println("AddEmp Fail");
				response.sendRedirect("AddEmployee.jsp");
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
