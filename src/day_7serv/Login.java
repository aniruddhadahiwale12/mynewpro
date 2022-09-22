package day_7serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Cookie c[]=request.getCookies();
		if(c==null)
		{
		
		request.getRequestDispatcher("nav.html").include(request, response);
		out.print("<form action='logincontroller' >");
		out.print("<input type='text' name='uname' placeholder='Enter User name'><br/><br/>");
		out.print("<input type='password' name='pass' placeholder='Enter Password'><br/><br/>");
		out.print("<input type='submit' value='login'>");
		out.print("<input type='reset'>");
		out.print("</form>");
		}
		else
		{
			response.sendRedirect("profile");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
