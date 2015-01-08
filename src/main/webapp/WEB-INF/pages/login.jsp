<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

     
<html>
    <head>
        <meta charset="utf-8">
        <title>Hackthon Application</title>

        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
        <style>
 #top{
     color:red;
	 width: 800px;
	 height: 100px ;
	 border: 1px solid red;
	 margin-left: 475px;
	 margin-top: 37px;
	 position: relative;
   }

 #left{
     color:green;
	 width: 180px;
	 height:699px;
	 border: 1px solid green;
	 margin-left: 290px;
	 margin-top: -103px;
	  position: relative;
   }
   
   #right{
     color:blue;
	 width: 800px;
	 height: 590px;
	 border: 1px solid blue;
	 margin-left: 475px;
	 margin-top: -592px;
	 position: relative;
   }
   
 #container
 {
 	position:absolute;
 	left:350px;
 	top:100px;
 	width:400px;
 	height:400px;
 } 
 
 #user_text
 {
 position:absolute;
 left:350px;
 top:135px;
 width:200px;
 height:127px;"
 }
 #user_input
 {
  position:absolute;
  left:350px;
  top:160px;
  width:200px;
  height:127px;
 }
 #password_text
 {
  position:absolute;
  left:350px;
  top:195px;
  width:200px;
  height:127px;"
 }
 #password_input
 {
  position:absolute;
  left:350px;
  top:220px;
  width:200px;
  height:127px;"
 }
 #login
 {
position:absolute;
left:410px;
top:260px;
width:200px;
height:127px;"
 }
 #register
 {
  position:absolute;
  left:350px;
  top:300px;
  width:200px;
  height:127px;
 }
#forget
{
 position:absolute;
 left:440px;
 top:300px;
 width:200px;
 height:127px;"
} 
  </style>
    </head>

    <body>
        <div id="container" >
           <form:form method="post" action="requestLogin" commandName="account" role="form">
                <div class="form-group">
                    <div id="user_text" >
                    <form:label path="Username">username:</form:label>
                    </div>
                    <div id="user_input">
                    <form:input path="Username" class="form-control" placeholder="username"/>
                    </div>
                </div>
                <div class="form-group">
                    <div id="password_text">
                    <form:label path="Password">passowrd:</form:label>
                    </div>
                     <div id="password_input">
                     <form:password path="Password" class="form-control" placeholder="password"/>
                     </div>
                </div>
                <div id="login" >
                	<button type="submit" class="btn btn-default">Login</button>
                </div>
                <div id="register">
                <a href="register.jsp">Rigister</a>
                </div>
                <div id="forget" >
                <a href="forget.jsp">Forget password?</a>
                </div>
            </form:form>
        </div>
    </body>
</html>