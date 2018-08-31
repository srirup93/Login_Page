package ExamplePackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		try{
			UserBean user=new UserBean();
			user.setFirstName(request.getParameter("FirstName"));
			user.setLastName(request.getParameter("LastName"));
			user.setUserName(request.getParameter("UserName"));
			user.setPassword(request.getParameter("Password"));
			
			user=UserDAO.register(user);
			if(user.isRegistered())
			{
				response.sendRedirect("successReg.jsp");
			}
			else
			{
				out.println("Invalid Credential");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
