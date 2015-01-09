<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title>Homepage</title>
<head>
 <style>
   #top{
     color:red;
	 width: 800px;
	 height: 100px ;
	 border: 1px solid #FFFF99;
	 margin-left: 475px;
	 margin-top: 37px;
	 position: relative;
	 background-image: url(<c:url value="/resource/img/see_left.jpg" />);
   }
   
   #left{
     color:green;
	 width: 180px;
	 height:699px;
	 border: 1px solid #FFFF99;
	 margin-left: 290px;
	 margin-top: -100px;
	 position: relative;
	 background-image: url(<c:url value="/resource/img/see_left.jpg" />);
   }
   
   #right{
     color:blue;
	 width: 800px;
	 height: 590px;
	//border: 1px solid blue;
	//background-image: url(right_bg.jpg);
	 margin-left: 475px;
	 margin-top: -592px;
	 position: relative; 
   }
   
   #table{
	 width:774px;
	 height:445px;
	 //border: 1px solid blue;
	 margin-left: 10px;
	 margin-top: 1px;
	 position: relative;
  } 
  #tools{
    width: 774px;
	height: 89px;
	//border:1px solid green;
	position: relative;
	margin-left: 10px;
	margin-top: 10px;
  }
  #search{
    //border: 1px solid red;
	margin-left: 20px;
	margin-top: 10px;
  }
  #upload{
    //border: 1px solid red;
	margin-left: 308px;
	margin-top: -46px;
  }
  th{
   color:#696969;
   border-bottom:2px solid grey;
  }
  td{
   color:#696969;
   border-bottom:1px solid grey;
  }
  #nextlast{
   margin-left: 710px;
  }
 </style>
</head>

<body>
 <!--Top Menu-->
 <div id="top" name="top_div">
   <div style="margin-left:730px; margin-top: 10px">
      <button style="background:#003300;"><a href="logout"><font color="white">Logout</font></a></button>
   </div>
    <div style="margin-left:610px; margin-top: -20px">
      <button style="background:#003300;"><a href="homepage.html"><font color="white">Homepage</font></a></button>
   </div>
   
 </div>
 <div id="left" name="left_div">
   <div id="logo" name="logo_div" style="margin-left: 16px; margin-top:10px">
     <img src="<c:url value="/resource/img/logo_login.png"/>" width="145px" height="87px"/>
   </div>
   <!--Personal Infomation-->
   <div id="personalinfo" name="personalinfo_div" style="width: 145px; height: 380px; margin-left: 16px; margin-top:60px">
 
	 
   </div> 
 </div>
 
 <div id="right" name="right_div">
    <div id="tools">
      <div id="search">
	    <form>
		   <input type="text" style="height:30px" value="search" id="search" name="search_input">
		   <input type="submit" style="height:30px;width:30px" value="Go" name="submit">
		</form>
      </div>
      <div id="upload"> 
	    <!--Share people-->
		<img src="<c:url value="/resource/img/partner1.jpg" />"/>
		
	     <label style="color:#990099">Sharer's Name:</label>&nbsp;&nbsp;
		 <label style="size:6px">Fred<label>
		
      </div>
    </div>
    <div id="table" name="table_div">
      <table style="text-align:left">
       <tr>
         <th width="300">Filename</th>
         <th width="150">size</th>
         <th width="100">Date</th>
         <th width="100">Action</th>
         <th width="150">Action</th>		 
       </tr>
       
       
       <tr>
         <td>row 1, cell 1</td>
         <td>row 1, cell 1</td>
         <td>row 1, cell 1</td>
         <!--  
         <td>
         	<form:form action="shareDown/${file_id}" method="get">
         	<input type="submit" style="height:30px; background:#32CD32; color:white" class="btn btn-danger btn-mini" value="share"/>
         	</form:form>
         </td>
		 <td>
		 	<form:form action="shareDown/${file_id}" method="get">
		 	<button type="button" style="height:30px; background:#32CD32; color:white">save to my page</button>
		 	</form:form>
		 </td>-->
		 <td>
         	<form:form action="shareDown/${file_id}" method="get">
         	<input type="submit" class="btn btn-danger btn-mini" value="download"/>
         	</form:form>
         </td>
		 <td>
		 	<form:form action="shareSaveToMe/${file_id}" method="get">
		 	<input type="submit" class="btn btn-danger btn-mini" value="save to my page"/>
		 	</form:form>
		 </td>
       </tr>
      </table>
	  
    </div>
	<div id="nextlast">
	  <a><img src="<c:url value="/resource/img/last.jpg" /> "/></a>&nbsp;&nbsp;&nbsp;
	  <a><img src="<c:url value="/resource/img/next.jpg" />"/></a>
	</div>
 </div>
 
</body>

</html>