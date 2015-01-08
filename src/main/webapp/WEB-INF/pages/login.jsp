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
 
 #bg{
   //border: 1px solid red;
   width:880px;
   height:598px;
   margin-left: 356px;
   margin-top: 47px;
 }
 #logo{
   margin-left: 21px;
   margin-top: 13px;
 }
 #post{
   //border: 1px solid red;
   margin-left: 20px;
   margin-top: 80px;
   width: 448px;
   height: 304px;
 }
 #container
 { 
	position:absolute;
 	margin-left:200px;
 	margin-top:-380px;
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
    left:490px;
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
	  <div id="bg">
	    <div id="logo" name="logo_div">
		   <img src="<c:url value="/resource/img/logo_login.png"/>"/>
		   <img src="<c:url value="/resource/img/word1.png" />"/>
		</div>
	    <div id="post" name="post_div">
		   <img src="<c:url value="/resource/img/cloud.jpg" />"/>
		</div>
        <div id="container" >
            <form:form method="post" action="requestLogin" commandName="account" role="form">
                <div class="form-group">
                    <div id="user_text" >
                    <form:label path="userName">username:</form:label>
                    </div>
                    <div id="user_input">
                    <form:input path="userName" class="form-control" placeholder="username"/>
                    </div>
                </div>
                <div class="form-group">
                    <div id="password_text">
                    <form:label path="password">passowrd:</form:label>
                    </div>
                     <div id="password_input">
                     <form:password path="password" class="form-control" placeholder="password"/>
                     </div>
                </div>
                <div id="login" >
                	<button style="background:#4169E1;color:white" type="submit" class="btn btn-default">Login</button>
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