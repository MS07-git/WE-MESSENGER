<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="mybeans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
MyData md=new MyData();
users x=md.getUser(session.getAttribute("email").toString());
String source="images/"+session.getAttribute("email")+"/"+x.getPp();
%>
<table style="width:1400px" border='1'>
<tr>
<td>
<h1>Welcome
<%=session.getAttribute("email") %>
</h1>
</td>
<td>
<%=x.getPp()%>
<img src=<%=source%> height="300px">
</td>
</tr>
</table>

      <form enctype="multipart/form-data" action="fileupload.jsp" method="post">
      Upload new<br>
      <input type="file" name="f1">
      <br>        
      <br>
      <input type="submit">
      </form>



</body>
</html>