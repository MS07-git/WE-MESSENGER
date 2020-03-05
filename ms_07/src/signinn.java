
import mybeans.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import mybeans.MyData;
import mybeans.users;

@WebServlet("/signinn")
public class signinn extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String user=request.getParameter("uname");
		String gender=request.getParameter("gender");
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
		
		user u=new user(email,pass,user,gender,pp);
		MyData md=new MyData();
		md.SaveUser1(u);
		response.sendRedirect("index1.jsp");
	}

}
