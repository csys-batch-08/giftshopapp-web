<%@page import="com.chainsys.giftshop.model.*"%>
<%@page import="com.chainsys.giftshop.impl.*"%>
<%@page import="java.util.* "%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
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
}

table {
	width: 20%;
	float: left;
	margin-top: 80px;
}

.button {
	margin-top: 170px;
	margin-left: 33px;
}

.navbar {
	overflow: hidden;
	background-color: seashell;
	width: 100%;
	margin-top: 1px;
	height: 55px;
	position: relative;
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
	position: absolute;
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
	padding: 30px;
}

.total {
	position: fixed;
	left: 500px;
	top: 80px;
	text-align: justify;
	border: 3px solid goldenrod;
	width: 200px;
	background-color: white;
}

.car {
	border-style: solid;
	border-color: goldenrod;
	width: 100%;
	background-color: white;
	width: 100%;
	padding: 20px;
	border-radius: 3px;
}

.back {
	position: absolute;
	left: 50px;
}

.button {
	position: fixed;
	left: 700px;
	top: -90px;
}
</style>
</head>
<body>
	<div class="navbar">
		<a href="index.jsp">Logout</a> <a href="orders">My orders</a> <a
			href="cart">My cart</a>
		<div class="dropdown">
			<button class="dropbtn">
				categories <em class="fa fa-caret-down"></em>
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
	<c:set var="orderdetailsid" value="${sessionScope.order}"
		scope="session" />
	<form action="cancel" method="get">
		<table>
			<caption></caption>
			<th></th>
			<tr>

				<c:set var="count" value="1" />
				<c:forEach items="${orderdetails}" var="orddetails">
					<c:set var="totals"
						value="${orddetails.totalprice*orddetails.quantityordered}" />
					<c:set var="total" value="${total+totals}" />

					<td>
						<div class="car">
							<div>
								<img src="${orddetails.image}" alt="show image">
							</div>
							<div>${orddetails.productname}</div>
							<div>Quantity:${orddetails.quantityordered}</div>
							<c:choose>
								<c:when test="${orddetails.size =='ra'}">
								</c:when>
								<c:otherwise>  
      size:${orddetails.size} 
    </c:otherwise>
							</c:choose>
							RS:${orddetails.totalprice}
							<div>
								<strong>Purchase
									amount:Rs:${orddetails.totalprice*orddetails.quantityordered}</strong>
							</div>

						</div>
					<td><c:choose>
							<c:when test="${count==4}">
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

		<c:set var="String" value="${status}" />
		<c:if test="${fn:containsIgnoreCase(String, 'ordered')}">

			<div class="button">
				<input type="submit" value="cancel order">
			</div>

		</c:if>
	</form>
	<div class="total">Total amount:Rs:${total}</div>
</body>
</html>