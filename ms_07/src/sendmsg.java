

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import mybeans.*
;@WebServlet("/sendmsg")
public class sendmsg extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession hs=request.getSession();
		String sender=hs.getAttribute("email").toString();
		String receiver=hs.getAttribute("receiver").toString();
		String message=request.getParameter("msg");
		String date=new Date().toString();
		message m=new message(0,sender,receiver,message,date);
		MyData md=new MyData();
		md.sendMessage(m);
		response.sendRedirect("message.jsp?receiver="+receiver);
	}

}
