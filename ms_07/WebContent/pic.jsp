<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("email")==null)
{
	response.sendRedirect("index.jsp");
}
%>
<%
String path= getServletContext().getRealPath("/")+"\\images\\ayush@gmail.com";

File f=new File(path);
		
		File list[]=f.listFiles();
		

		for(File f1:list) {
		String path1="images/ayush@gmail.com/";
		path1=path1+f1.getName();
		
		
		%>
				<img src="<%=path1 %>" height="225px" width="225px"/><br>
				<%=path%><br>
		<%}%>
</body>
</html>