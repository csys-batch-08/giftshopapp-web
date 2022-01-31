<%@page import="com.chainsys.giftshop.model.ProductPojo"%>
<%@page import="com.chainsys.giftshop.impl.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>caricatures</title>
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
	/* border-style: solid;
	border-radius: 5%;
	border: 5px solid #daa520; */
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
  padding: 10px;
  padding-right: 35px;
  
  
}
.back{
position:absolute;
left:50px;
}
.car {
	border-style: solid;
	border-color: goldenrod;
width: 100%;
	background-color: white;
	padding: 20px;
	border-radius:3px;
	
	
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
      <a href="adminshowproducts">Back</a>
      </div>
	</div>
 <table>
		<tbody>
			<th>
			<tr>
				<c:set var="count" value="1" />
				<c:forEach items="${adminviewcaricature}" var="adminviewcar">

<td>
					<div class="car">
					<center><div><img src="${adminviewcar.image}"></div> </center>
						<center><div>Id:${adminviewcar.productId}</div> </center>
						<center><div>Product name:${adminviewcar.productName}</div></center>
						<center><div>Description:${adminviewcar.description}</div></center>
						<center><div>Price:${adminviewcar.standardCost}</div></center>
						<center><div>category:${adminviewcar.category}</div></center>
						<center><div>Quantity:${adminviewcar.quantityonhand}</div></center>
						<center><div>Type:${adminviewcar.type}</div></center>
					</div>
					<td>
					<c:choose>

						<c:when test="${count==3}">
			</tr>
			<tr>
				<c:set var="count" value="1" />
			</c:when>
			<c:otherwise>
				<c:set var="count" value="${count+1}" />
			</c:otherwise>
			</c:choose>
			</c:forEach>
			</tr>
			</th>
		</tbody>
	</table>

</body>
</html>