

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mybeans.*;


@WebServlet("/wallpost")
public class wallpost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession hs=request.getSession();
		String email=hs.getAttribute("email").toString();
		String msg=request.getParameter("msg");
		wpost w=new wpost(0,email,msg);
		MyData md=new MyData();
		md.saveWpost(w);
		response.sendRedirect("Welcome2.jsp?mssg=Wall Posted");
	}

}
