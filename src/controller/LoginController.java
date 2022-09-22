package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "logincontroller", urlPatterns = { "/logincontroller" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		if (pass.equals("abc"))
		{
			Cookie c=new Cookie("uname", name);
			response.sendRedirect("profile");
		}
		else
		{
			request.getRequestDispatcher("login").include(request, response);
			
			out.print("<p style='color:red'> Sorry Wrong Password");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
