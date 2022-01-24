<%@page import="com.chainsys.giftshop.model.UserPojo"%>
<%@page import="com.chainsys.giftshop.model.ProductPojo"%>
<%@page import="com.chainsys.giftshop.impl.*"%>
<%@page import="java.util.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Users</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
	background-image: url("images/plain-yellow-wall-product-background.jpg");
	background-repeat: no-repeat;
	background-size: 1370px 620px;
	/* background-size: cover; */
	background-attachment: fixed;
}

 table img {
	width: 150px;
	height: 150px;
	border-style: solid;
	border-radius: 5%;
	border: 5px solid #daa520;
} 
.button1 {
	margin-top: 15px;
	margin-left: 3px;
}

.navbar {
  overflow: hidden;
  background-color:seashell;
  width:100%;
  margin-top:1px;
  height:55px;
 
 
  
}
.navbar a {
	float: left;
	font-size: 16px;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	float: right;
	font-style: italic;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	font-size: 18px;
	margin-right: 25px;
	margin-right: 5px;
}

.dropdown {
	float: right;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 18px;
	border: none;
	outline: none;
	color: black;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
	font-style: italic;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: goldenrod;
}

.dropdown-content {
	display: none;
	position: fixed;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}


th, td {
  padding: 26px;
  
}
.car {
	/* border: 100px;
	width: 5000px;
	background-color:white ;
	border-radius:5px;
	padding:20px;
	border-color: coral;
 */	
  border-style: solid;
  border-color: goldenrod;
  width: 5000px;
  background-color:white ;
 padding:20px;
}
.back{
position:fixed;
left:150px;
}
</style>

</head>

<body>
	<div class="navbar">
		<a href="index.jsp">Logout</a> 
		<div class="dropdown">
			<button class="dropbtn">
				actions <i class="fa fa-caret-down"></i>
			</button>

			<div class="dropdown-content">
				<a href="insertproduct.jsp">Insert</a>
				 <a href="update.jsp">Update</a> 
				 <a href="delete.jsp">Delete</a> 
				  <a href="showusers.jsp">Users</a>
			</div>

		</div>
		<div class="back">
      <a href="adminlogin.jsp">Back</a>
      </div>

	</div>


	
	<form>
		<%
		

		UserImpl dao=new UserImpl();
       UserPojo us = new UserPojo();
		List<UserPojo> show;
		show=dao.showusers();
		%>

	</form>
	<center><h2 class="Products">Users</h2></center>
	<br>
	<div class="recently added list">
		<table>
			<tbody>
				<tr>
					<%
					
					int count=0;
					                for(UserPojo showProduct: show){
					%>
					<td>
						<table id="carproduct">
							<tbody>
									
									
									<td class="car">
									
									<div>User Id: <%=showProduct.getUserid()%></div>
									<div>Name: <%=showProduct.getUsername()%></div>
									<div> Email:<%=showProduct.getEmail()%></div> 
									 <div>Mobile number: <%=showProduct.getMobilenumber()%></div>
									  <div>Address: <%=showProduct.getAddress()%></div>
									 
										
										
										</td>
								</tr>
							</tbody>
						</table>

					</td>
					<% count ++;
                       if(count==4){ %>
				</tr>
				<tr>
					<%count=0; }}%>

				</tr>
			</tbody>
		</table>

	</div>
	</div>
	</div>

</body>
</html>