<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
function check(value,control)
{
  	if(value.length==0)
  		document.getElementById(control).innerHTML="<font color='red'>Sorry can't leave it blank</font>";
  	else
       document.getElementById(control).innerHTML="";

}

function validate()
{
  var email=document.getElementById("email").value;
  var pass=document.getElementById("pass").value;
  var uname=document.getElementById("uname").value;
  var pno=document.getElementById("pno").value;
  var flag=0;
  if(email.length==0)
	  {
	  document.getElementById("error").innerHTML="<font color='red'>Sorry can't leave it blank</font>";
       flag=1;
	  }
  if(pass.length==0)
	  {
	  document.getElementById("error2").innerHTML="<font color='red'>Sorry can't leave it blank</font>";
	  flag=1
	  }
  if(uname.length==0)
	  {
	  document.getElementById("error3").innerHTML="<font color='red'>Sorry can't leave it blank</font>";
	  flag=1;
	  }
  if(pno.length==0)
	  {
	  document.getElementById("error4").innerHTML="<font color='red'>Sorry can't leave it blank</font>";
	  flag=1
	  }
    if(flag=0)
	  return true;
    else
      return false;
}

function checkEmail(value)
{
    var flag=0;
	var i=value.indexOf("@");
	var j=value.lastIndexOf(".");
	if(i==-1)
		{
		document.getElementById("error1").innerHTML="<font color='red'>Missing @</font>";
	     flag=1;
		}
		if(j==-1)
		{
		document.getElementById("error1").innerHTML="<font color='red'>Missing .</font>";
		flag=1;
		}
		if(i>=j)
		{
		document.getElementById("error1").innerHTML="<font color='red'>Misplaced @ and .</font>";
		flag=1;
		}
		if(flag==0)
			{
			document.getElementById("error1").innerHTML="";
			return true;
			}
		else
			return false;
				
	}

var x;

function save()
{

	var email=document.getElementById("email").value;
	var pass=document.getElementById("pass").value;
	var uname=document.getElementById("uname").value;
	var pno=document.getElementById("pno").value;
	x=new XMLHttpRequest();
	x.open("GET","signin?email="+email+"&pass="+pass+"&uname="+uname+"&pno="+pno,true);
	x.onreadystatechange=maze;
	x.send(null);
	
}

function maze()
{
  if(x.readyState==4)
	{
	  document.getElementById("finalmsg").innerHTML=x.responseText;
	}
}



</script>
</head>
<body>
<table>
<tr>
<td>Enter Email</td><td><input type="text" name="email" id="email" onblur="check(this.value,'error'),checkEmail(this.value)"></td>
<td><span id="error1"></span></td>
<td><span id="error"></span></td>
</tr>
<tr>
<td>Enter Password</td><td><input type="password" name="pass" id="pass" onblur="check(this.value,'error2')" ></td>
<td><span id="error2"></span></td>
</tr>
<tr>
<td>Enter User Name</td><td><input type="text" name="uname" id="uname" onblur="check(this.value,'error3')"></td>
<td><span id="error3"></span></td>
</tr>
<tr>
<td>Enter Phone Number</td>
<td><input type="text" name="pno" id="pno" onblur="check(this.value,'error4')"></td>
<td><span id="error4"></span></td>
</tr>
<tr>
<td><input type="button" value="SignUp" onclick="save()"></td>
<td><span id="finalmsg"></span>   </td>
</tr>
</table>
</body>
</html>