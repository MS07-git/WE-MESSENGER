<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mybeans.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function fun(str)
{
	x=new XMLHttpRequest();
	x.open("GET","autocomplete?name="+str,true);
	x.onreadystatechange=maze;
	x.send(null);		
}

function maze()
{
  if(x.readyState==4)
	{
	  document.getElementById("xolo").innerHTML=x.responseText;
	}	
	
}

function fill(s)
{
	document.getElementById("name").value=s;
}




</script>

</head>
<body>
<%
MyData ms=new MyData();
users y=ms.getUser(session.getAttribute("email").toString());
String source="images/"+session.getAttribute("email")+"/"+y.getPp();
%>
<table style="width:1400px" border='1'>
<tr>
<td background="<%=source%>" >
<h1>Welcome
<%=session.getAttribute("email") %>
</h1>
 <form enctype="multipart/form-data" action="fileupload.jsp" method="post">
      Upload new<br>
      <input type="file" name="f1">
      <br>        
      <br>
      <input type="submit">
      </form>
</td>


<td>
Send Request:
<form action="request" method="post">
Receiver ID<br>
<input type="text" name="receiver" id="name" onkeyup="fun(this.value)"><br>
<div id="xolo" style="height:200px; width:200px">
</div>
<input type="submit" value="Send_Request"><br>
<%if(request.getParameter("msg")!=null)
{
 out.println(request.getParameter("msg"));
}
%>
</form>
</td>

<td>
Pending Requests:
<% 
MyData md=new MyData();
ArrayList<friends> al=new ArrayList<>();
al=md.getPending(session.getAttribute("email").toString());
for( friends f:al)
{
%>
<h4><%=f.getSender()%></h4>
<a href=accept?id=<%=f.getId()%>>Accept</a>
<a href=reject?id=<%=f.getId()%>>Reject</a>
<% } %>


</td>
</tr>

<tr>
<td>
<h3>MY FRIENDS</h3>:<br>
<%
ArrayList<friends> af=new ArrayList<>();
MyData mc=new MyData();
af=mc.getFriends(session.getAttribute("email").toString());
for(friends l:af)
{
	if(l.getSender().equals(session.getAttribute("email").toString()))
	{
%>
<a href="message.jsp?receiver=<%=l.getReceiver()%>"><%=l.getReceiver()%></a><br>
<%
	}
	else
	{

%>
<a href="message.jsp?receiver=<%=l.getSender()%>"><%=l.getSender()%></a><br>
<%}}%>

</td>

<td>

<h3>What's on your mind?</h3><br>
<form action="wallpost" method="post">
<textarea rows="5" cols="20" name="msg"></textarea>
<input type="submit" value="post"><br>

<%if(request.getParameter("mssg")!=null)
{
 out.println(request.getParameter("mssg"));
}
%>
</form>
</td>


<td>
<h2>All WALL UPDATES</h2>
<%
ArrayList<wpost> w=new ArrayList<>();
MyData x=new MyData();
w=x.getPosts(session.getAttribute("email").toString());
for(wpost z:w)
{
%>
<%=z.getEmail() %><br>
<%=z.getMsg() %><br><br>
<%} %>

</td>

</tr>


</table>
</body>
</html>