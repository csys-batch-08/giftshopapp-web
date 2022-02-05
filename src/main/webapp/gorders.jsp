<%@page import="java.util.List"%>
<%@page import="com.chainsys.giftshop.impl.OrdersDaoImpl"%>
<%@page import="com.chainsys.giftshop.model.OrdersPojo"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>order details</title>

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
	/* border: 1px solid #ddd;
  border-radius: 4px;
  padding: 5px;
  width: 150px; */
}



th, td {
	padding-left: 35px;
	Padding-top:60px;
}
.car {
	border-style: solid;
	border-color: goldenrod;
     width: 100%;
	background-color: white;
	padding: 20px;
	border-radius:3px;
	
	
	
}
.navbar {
	overflow: hidden;
	background-color: seashell;
	width: 100%;
	margin-top: 1px;
	height: 55px;
	position: FIXED;
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
	position: relative;
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
.back{
position:absolute;
left:50px;
}
</style>
</head>
<body>
		<div class="navbar">
		<a href="index.jsp">Logout</a> <a href="orders">My orders</a> <a
			href="cart">My cart</a>
		<div class="dropdown">
			<button class="dropbtn">
				categories <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="mensproducts">mens</a> <a href="womensshowproducts">womens</a>
				<a href="kidsshowproducts">kids</a> <a href="occasionsshowproducts">occasions</a>
			</div>
		</div>
		<a href="userallproducts">All collections</a> <a href="homepage.jsp">Home</a>
		<div class="back">
			<a href="homepage.jsp">Back</a>
		</div>
	</div>

	<form action="orderdetails"method="post">
	    <table>

			<tr>
				<c:set var="count" value="1" />
				<c:forEach items="${showorders}" var="orders">
				<fmt:parseDate pattern="yyyy-MM-dd" value="${orders.orderdate}"
				var="parsedDate" />
		   <td>
                    <div class="car">
					Order id:${orders.orderid}
				    Order date:<fmt:formatDate pattern="dd-MM-yyyy" value="${parsedDate}" />
					Status:${orders.status}
					<br>
	              <input type="button" value="view details"onclick="window.location='orderdetails?ordid=${orders.orderid}'">
					</div>
	</td>
					<c:choose>
				    <c:when test="${count==5}">
				    <c:set var="count" value="1" />
			<tr>
			</c:when>
			<c:otherwise>
			<c:set var="count" value="${count+1}" />
			</c:otherwise>
			</c:choose>
			</c:forEach>
			</tr>	
	</table>  

</form>
</body>
</html>