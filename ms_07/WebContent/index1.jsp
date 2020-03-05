<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#myVideo {
  position: fixed;
  right: 0;
  bottom: 0;
  min-width: 100%; 
  min-height: 100%;
}

/* Add some content at the bottom of the video/page */
.content {
  position: fixed;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  color: #f1f1f1;
  width: 100%;
  height:100%;
  padding: 20px;
}

/* Style the button used to pause/play the video */
#myBtn {
  width: 200px;
  font-size: 18px;
  padding: 10px;
  border: none;
  background: #000;
  color: #fff;
  cursor: pointer;
}

#myBtn:hover {
  background: #ddd;
  color: black;
}
</style>
<script>
// Get the video
var video = document.getElementById("myVideo");

// Get the button
var btn = document.getElementById("myBtn");

// Pause and play the video, and change the button text
function myFunction() {
  if (video.paused) {
    video.play();
    btn.innerHTML = "Pause";
  } else {
    video.pause();
    btn.innerHTML = "Play";
  }
}
</script>

</head>
<body>
<video autoplay muted loop id="myVideo">
  <source src="11.mp4" type="video/mp4">
</video>

<!-- Optional: some overlay text to describe the video -->
<div class="content">
  <h1>WELCOME TO WE-MESSENGER</h1>
  <p>
  
<h1>Sign Up</h1><br>
<form action="signin" method="post">
<table>
<tr>
<td>Enter Email</td><td><input type="text"  pattern="([a-z0-9\._%+-]{3,})@([a-z\d_]{4,})\.([a-z]{2,4})$" name="email"
                placeholder="Enter Email" title="enter valid e-mail" autocomplete="off" required></td>
</tr>
<tr>
<td>Enter Password</td><td><input type="password" name="pass"></td>
</tr>
<tr>
<td>Enter User Name</td><td><input type="text" name="uname"></td>
</tr>
<tr>
<td>Gender</td>
<td>M<input type="radio" name="gender" value="male"></td>
<td>F<input type="radio" name="gender" value="female"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="SignUp"></td>
</tr>
</table>
</form><br>
<%if(request.getParameter("msg1")!=null)
	{%>
<p style="color:red"><%=request.getParameter("msg1")%></p>
<%
}%>
<br><br>
<hr>

<h1>Login</h1><br>
<form action="login" method="post">
<table>
<tr>
<td>Enter Email</td><td><input type="text" name="email"></td>
</tr>
<tr>
<td>Enter Password</td><td><input type="password" name="pass"></td>
</tr>
<tr>
<td>
<%if(request.getParameter("msg")!=null)
{
 out.println(request.getParameter("msg"));
}
%>
</td>
<td><input type="submit" value="Login"></td>
</tr>
</table>
</form>

  
  
  </p>
</div>


</body>
</html>