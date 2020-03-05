<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="mybeans.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
body  {
  background-image: url("mk.jpg");
  background-color: #cccccc;
}


.msg
{
font-size:30px;

}
#text
{
font-size:20px;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session.setAttribute("receiver",request.getParameter("receiver"));
%>

<table id="t">
<tr>
<td>
<form action="sendmsg" method="post">
<textarea id="text" rows="5" cols="40" name="msg"></textarea>
<input type="submit" value="SEND">
</form>
</td>
</tr>
<tr>
<td>
<h4 class="msg" style="color:white">Earlier conversations:</h4>
</td>
</tr>
<%
ArrayList<message> ml=new ArrayList<>();
MyData md=new MyData();
ml=md.getText(session.getAttribute("email").toString(),request.getParameter("receiver"));
for(message l:ml)
{
	if(l.getSender().equals(session.getAttribute("email").toString()))
	{	
%>
<tr >
<td class="msg" style="color:white">YOU:</td>
<td class="msg" style="color:white"><%=l.getMsg() %></td>
<td></td>
<td></td>
<td></td>
<td class="msg" style="color:white"><%=l.getDate()%></td>
</tr>

<%
	}
	else
	{

%>
<tr >
<td  class="msg" style="color:white"><%=l.getSender() %></td>
<td class="msg" style="color:white"><%=l.getMsg() %></td>
<td></td>
<td></td>
<td></td>
<td class="msg" style="color:white"><%=l.getDate()%></td>
</tr>
<%}} %>
</table>
</body>
</html>