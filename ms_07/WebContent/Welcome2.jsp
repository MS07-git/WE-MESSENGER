<%@ page import="mybeans.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>

<html lang="en">
	<head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"> 
        <meta charset="utf-8">
        <title>Facebook Theme Demo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link href="assets/css/facebook.css" rel="stylesheet">
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
function fun1(str)
{
	x=new XMLHttpRequest();
	x.open("GET","autocomplete?name="+str,true);
	x.onreadystatechange=maze1;
	x.send(null);		
}

function maze1()
{
  if(x.readyState==4)
	{
	  document.getElementById("xolo1").innerHTML=x.responseText;
	}	
	
}

function fill1(s)
{
	document.getElementById("name1").value=s;
}




</script>
 <style>   
     #xolo
     {
    	 position:relative;
         right:130px;
         
     }
      #xolo1
     {
    	 position:relative;
         right:130px;
         
     }
     #imgx
     {
     position:relative;
       right:10px;
     }
     #mydiv
     {
     height:400px;
     
     }
     #but
     {
     position:relative;
     left:870px;
     top:10px;
     }
     
    
     </style>
        
    </head>
    
    <body>
    
        
        <%
        
        
        
          
MyData ms=new MyData();
users y=ms.getUser(session.getAttribute("email").toString());
String source="images/"+session.getAttribute("email")+"/"+y.getPp();
%>
        
        
        
        <div class="wrapper">
			<div class="box">
				<div class="row row-offcanvas row-offcanvas-left">
					
					<!-- sidebar -->
					<div class="column col-sm-2 col-xs-1 sidebar-offcanvas" id="sidebar">
					  
						<ul class="nav">
							<li><a href="#" data-toggle="offcanvas" class="visible-xs text-center"><i class="glyphicon glyphicon-chevron-right"></i></a></li>
						</ul>
					   
						<ul class="nav hidden-xs" id="lg-menu">
							
							<li><h3>Connect</h3></li>
							<li><h3>to</h3></li>
							<li><h3>the</h3></li>
							<li><h3>people</h3></li>
							<li><h3>around</h3></li>
							<li><h3>you.</h3></li>
						</ul>
						<ul class="list-unstyled hidden-xs" id="sidebar-footer">
							<li>
							  <a href="http://usebootstrap.com/theme/facebook"><h3>We-Messenger</h3>  <i class="glyphicon glyphicon-heart-empty"></i>Make your move.</a>
							</li>
						</ul>
					  
						<!-- tiny only nav-->
					  <ul class="nav visible-xs" id="xs-menu">
							<li><a href="#featured" class="text-center"><i class="glyphicon glyphicon-list-alt"></i></a></li>
							<li><a href="#stories" class="text-center"><i class="glyphicon glyphicon-list"></i></a></li>
							<li><a href="#" class="text-center"><i class="glyphicon glyphicon-paperclip"></i></a></li>
							<li><a href="#" class="text-center"><i class="glyphicon glyphicon-refresh"></i></a></li>
						</ul>
					  
					</div>
					<!-- /sidebar -->
				  
					<!-- main right col -->
					<div class="column col-sm-10 col-xs-11" id="main">
						
						<!-- top nav -->
						<div class="navbar navbar-blue navbar-static-top">  
							<div class="navbar-header">
							  </div>
							<nav class="collapse navbar-collapse" role="navigation">
							<form class="navbar-form navbar-left">
								<div class="input-group input-group-sm" style="max-width:360px;">
								<h4>We Messenger</h4>
								  <div class="input-group-btn"></div>
								</div>
							</form>
							<ul class="nav navbar-nav">
							  <li><form action="logout" method="get">
								<input id="but" type="submit" value="Logout">
								</form>
							  </li>
							 </ul>
							<ul class="nav navbar-nav navbar-right">
							  
							</ul>
							</nav>
						</div>
						<!-- /top nav -->
					  
						<div class="padding">
							<div class="full col-sm-9">
							  
								<!-- content -->                      
								<div class="row">
								  
								 <!-- main col left --> 
								 <div class="col-sm-5">
								   
									  <div class="panel panel-default">
										<div class="panel-thumbnail"><img src="<%=source %>" class="img-responsive" height="225px" width="225px"></div>
										<form enctype="multipart/form-data" action="fileupload.jsp" method="post">
      Upload new<br>
      <input type="file" name="f1">
      <br>        
      <br>
      <input type="submit">
      </form>
										<div class="panel-body">
										  <p class="lead"><h1>Welcome
                                          <%=session.getAttribute("email") %>
                                          </h1></p>
                                          <%
                                          MyData mx=new MyData();
                                          int j=mx.Followers(session.getAttribute("email").toString());
                                          String pathh= getServletContext().getRealPath("/")+"\\images\\"+session.getAttribute("email");

                                          File fx=new File(pathh);
                                          		
                                          		File list1[]=fx.listFiles();
                                          		int ml=list1.length;
                                          
                                          %>
										  <p> <%=j %> Friends, <%=ml %> Posts</p>
										  
										  <p>
											<img src="assets/img/uFp_tsTJboUY7kue5XAsGAs28.png" height="28px" width="28px">
										  </p>
										</div>
									  </div>

								   
									  <div class="panel panel-default">
										<div class="panel-heading"> <h4>Pending Requests</h4></div>
										  <div class="panel-body">
											<div class="list-group">
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
											
											  </div>
										  </div>
									  </div>
								   
									  <div class="well"> 
										   <form class="form-horizontal" action="wallpost" method="post" role="form">
											<h4>What's New</h4>
											 <div class="form-group" style="padding:14px;">
											  
											  <textarea class="form-control" placeholder="Update your status" name="msg" ></textarea>
											<input type="submit" value="post">
											<%if(request.getParameter("mssg")!=null)
{
 out.println(request.getParameter("mssg"));
}
%>
											</div>
											
											</form>
									  </div>
								   
									  <div class="panel panel-default">
										 <div class="panel-heading"> <h4>Friends</h4>
										 <img src="data:image/jpeg;base64,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" class="img-circle pull-right"> 
										 </div>
										  <div class="panel-body" style="height:100px;width:400px;border:solid 2px orange;overflow:scroll;overflow-x:hidden;overflow-y:scroll;">
											<% ArrayList<friends> af=new ArrayList<>();
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

											
											<div class="clearfix"></div>
											</div>
									  </div>
								   
									  
										
								   
								  </div>
								  
								  <!-- main col right -->
								  <div class="col-sm-7">
									   
										<div class="well"> 
										   <form class="form" action="request" method="post">
											<h4>Send Request</h4>
											<div class="input-group text-center">
											<input class="form-control input-lg"  type="text" name="receiver" id="name" onkeyup="fun(this.value)"><br>
											<div id="xolo" >
</div>
											  <span class="input-group-btn"><input type="submit" value="Send_Request"></span>
											</div>
											<%if(request.getParameter("msg")!=null)
											{
 												out.println(request.getParameter("msg"));
											}
											%>
										  </form>
										</div>
							  
									   <div class="panel panel-default">
										 <div class="panel-heading"> <h4>WallPosts</h4></div>
										  <p><img id="imgx" src="data:image/jpeg;base64,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" class="img-circle pull-right"> </p>
											
										  <div class="panel-body" style="height:100px;width:400px;border:solid 2px orange;overflow:scroll;overflow-x:hidden;overflow-y:scroll;">
											<div class="clearfix"></div><% 
											ArrayList<wpost> w=new ArrayList<>();
MyData x=new MyData();
w=x.getPosts(session.getAttribute("email").toString());
for(wpost z:w)
{
%>
<%=z.getEmail() %><br>
<%=z.getMsg() %><br><br>
<%} %>
											<hr>
											
										  </div>
									   </div>
									
									   <div class="panel panel-default">
										 <div class="well"> 
										   <form class="form" action="Unfriend" method="get">
											<h4>Unfriend</h4>
											<div class="input-group text-center">
											<input class="form-control input-lg"  type="text" name="receiver" id="name1" onkeyup="fun1(this.value)">
											 <div id="xolo1" >
                                             </div>
											  <span class="input-group-btn"><input type="submit" value="Confirm"></span>
											</div>
											<%if(request.getParameter("msg")!=null)
											{
 												out.println(request.getParameter("msg"));
											}
											%>
										  </form>
										</div>
									   </div>

									   <div class="panel panel-default">
										 <div class="panel-heading"> <h4>About Us</h4></div>
										  <div class="panel-body">
											Our website allows you to:<br>
											1-Make new friends<br>
											2-Post whats on your mind<br>
											3-Update your profile picture<br>
											4-Send Messages<br>
											Hope you have a good time here.
										  </div>
									   </div>
									
									   <div id="mydiv" class="panel panel-default">
										<div class="panel-thumbnail"><img src="" class="img-responsive"></div>
										<div class="panel-body">
										  <p class="lead">Your profile pictures</p>
										  <div style="height:320px;width:400px;border:solid 2px orange;overflow:scroll;overflow-x:hidden;overflow-y:scroll;">
										  <%
String path= getServletContext().getRealPath("/")+"\\images\\"+session.getAttribute("email");

File f=new File(path);
		
		File list[]=f.listFiles();
		

		for(File f1:list) {
		String path1="images/"+session.getAttribute("email")+"/";
		path1=path1+f1.getName();
		
		
		%>
				<img src="<%=path1 %>" height="225px" width="225px"/><br><br>
			
		<%}%>
		</div>
										 
										</div>
									  </div>
									
								  </div>
							   </div><!--/row-->
							  
								
							  
								
									
								  </div>
								  
								</div>
							  
							  <hr>
							  
							  <h4 class="text-center">
							  </h4>
								
							  <hr>
								
							  
							</div><!-- /col-9 -->
						</div><!-- /padding -->
					</div>
					<!-- /main -->
				  
				</div>
			</div>
		</div>


		<!--post modal-->
		<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
		  <div class="modal-dialog">
		  <div class="modal-content">
			  <div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					Update Status
			  </div>
			  <div class="modal-body">
				  <form class="form center-block">
					<div class="form-group">
					  <textarea class="form-control input-lg" autofocus="" placeholder="What do you want to share?"></textarea>
					</div>
				  </form>
			  </div>
			  <div class="modal-footer">
				  <div>
				  <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">Post</button>
					<ul class="pull-left list-inline"><li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li><li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li><li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>
				  </div>	
			  </div>
		  </div>
		  </div>
		</div>
        
        <script type="text/javascript" src="assets/js/jquery.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.js"></script>
        <script type="text/javascript">
        $(document).ready(function() {
			$('[data-toggle=offcanvas]').click(function() {
				$(this).toggleClass('visible-xs text-center');
				$(this).find('i').toggleClass('glyphicon-chevron-right glyphicon-chevron-left');
				$('.row-offcanvas').toggleClass('active');
				$('#lg-menu').toggleClass('hidden-xs').toggleClass('visible-xs');
				$('#xs-menu').toggleClass('visible-xs').toggleClass('hidden-xs');
				$('#btnShow').toggle();
			});
        });
        </script>
</body></html>