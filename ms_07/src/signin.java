import mybeans.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signin")
public class signin extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String user=request.getParameter("uname");
		String gender=request.getParameter("gender");
		MyData md=new MyData();
		String x=md.check(email,user);
		
		if(x!="")
		response.sendRedirect("index.jsp?msg1="+x);
		else
		{
			String pp="";
			
			String path=getServletContext().getRealPath("/")+"\\images\\";
			File f=new File(path+request.getParameter("email"));
			f.mkdir();
			FileInputStream fis=null;
			if(gender.equals("male"))
			{
				fis=new FileInputStream(path+"boy.jpg");
				pp="boy.jpg";
			}
			else
			{
				fis=new FileInputStream(path+"\\girl.jpg");
				pp="girl.jpg";
			}
			FileOutputStream fos=new FileOutputStream(path+request.getParameter("email")+"\\"+pp);
			int i;
			while((i=fis.read())!=-1)
			{
				fos.write(i);
			}
			fis.close();
			fos.close();
		users u=new users(email,pass,user,gender,pp);
		md.SaveUser(u);
		response.sendRedirect("index.jsp?msg1=Data Saved");
		}
		
	}

}
