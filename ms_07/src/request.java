

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import mybeans.*;

@WebServlet("/request")
public class request extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  String receiver=request.getParameter("receiver");
	  HttpSession hs=request.getSession();
	  String sender=hs.getAttribute("email").toString();
	  String dor=new Date().toString();
	  int status=0;
	  MyData md=new MyData();
	  String x=md.checkf(sender, receiver);
	  if(x=="")
	  {
	  friends f=new friends(0,sender,receiver,status,dor);
	  md.sendRequest(f);
	  response.sendRedirect("Welcome2.jsp?msg=Request Sent");  
	  }
	  else
	  {
		  response.sendRedirect("Welcome2.jsp?msg="+x);
	  }
	}

}
