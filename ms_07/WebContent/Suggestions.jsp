<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<input type="text" name="name" id="name" onkeyup="fun(this.value)"><br>
<div id="xolo" style="height:200px; width:200px">
</div>
</body>
</html>