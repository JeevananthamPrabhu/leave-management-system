package project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.controller.ApplyLeaveController;
import project.model.LeaveDataModel;

import java.io.IOException;

/**
 * Servlet implementation class ApplyLeaveServlet
 */
public class ApplyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyLeaveServlet() {
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
			
			String empid=(String)session.getAttribute("username");
			String empname=(String)session.getAttribute("empname");
		
			String leavetype=request.getParameter("leavetype");
			String reason=request.getParameter("reason");
			String fromdatearray[]=request.getParameter("fromdate").split("-");
			String fromdate=fromdatearray[2]+"-"+fromdatearray[1]+"-"+fromdatearray[0];
			String todatearray[]=request.getParameter("todate").split("-");
			String todate=todatearray[2]+"-"+todatearray[1]+"-"+todatearray[0];
			LeaveDataModel model=new LeaveDataModel();
	  
	        model.setleavetype(leavetype); 
	        model.setreason(reason);
	        model.settodate(todate);
	        model.setfromdate(fromdate);
	        model.setempname(empname);
	        model.setempid(empid);
	     //   System.out.println(request.getParameter("username"));
	        ApplyLeaveController control=new ApplyLeaveController(model);
	        if(control.store())
			{
				System.out.println("leaveadd Success");
				
					//request.setAttribute("username", username);
					//request.setAttribute("resultList", control.resultList);
					//request.setAttribute("leaveadded", "");
				request.setAttribute("currentPage", "Apply.jsp");
					request.getRequestDispatcher("Apply.jsp").forward(request, response);
					//System.out.println("Task get Success");
			}
			else
			{
				System.out.println("leaveadd Fail");
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
