

import mybeans.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String email=request.getParameter("email");
		 String pass=request.getParameter("pass");
		 users u=new users(email,pass,"","","");
		 MyData md=new MyData();
		  if (md.isVaild(u))
			  {
			    HttpSession hs=request.getSession();
		    	hs.setAttribute("email",u.getEmail());
		    	response.sendRedirect("Welcome2.jsp");
			  }
		  else
		  {
			  response.sendRedirect("index.jsp?msg=Invalid Credentials");
		  }
		}

	}


