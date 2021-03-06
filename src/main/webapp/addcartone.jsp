<%@page import="java.sql.SQLException"%>
<%@page import="com.chainsys.giftshop.impl.ViewCartDaoImpl"%>
<%@page import="com.chainsys.giftshop.model.ViewCartPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add to cart</title>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">


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
	background-attachment: fixed;
}

img {
	width: 350px;
	height: 350px;
	border-radius: 20px;
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
	position: relative;
	color: black;
	text-decoration: none;
	font-style: italic;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	font-size: 18px;
	text-align: center;
	padding: 14px 16px;
	float: right;
}

.dropdown {
	float: right;
	overflow: hidden;
	left: 870px;
	top: -7px;
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

.qty .count {
	color: #000;
	display: inline-block;
	vertical-align: top;
	font-size: 25px;
	font-weight: 700;
	line-height: 30px;
	padding: 0 2px;
	min-width: 35px;
	text-align: center;
}

.qty .plus {
	cursor: pointer;
	display: inline-block;
	vertical-align: top;
	color: white;
	width: 30px;
	height: 30px;
	font: 30px/1 Arial, sans-serif;
	text-align: center;
	border-radius: 50%;
}

.qty .minus {
	cursor: pointer;
	display: inline-block;
	vertical-align: top;
	color: white;
	width: 30px;
	height: 30px;
	font: 30px/1 Arial, sans-serif;
	text-align: center;
	border-radius: 50%;
	background-clip: padding-box;
}

div {
	text-align: center;
}

.minus:hover {
	background-color: #717fe0 !important;
}

.plus:hover {
	background-color: #717fe0 !important;
}
/*Prevent text selection*/
span {
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
}

input {
	border: 0;
	width: 2%;
}

nput::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

input:disabled {
	background-color: white;
}

.counter {
	margin-top: -40px;
}

th, td {
	position: relative;
	left: 170px;
	top: 110px;
	background-color: white;
	padding: 50px;
}

.back {
	position: absolute;
	left: 100px;
	top: 1px;
}

.logout {
	position: absolute;
	left: 1200px;
	top: 1px;
}

.orders {
	position: absolute;
	left: 1100px;
	top: 1px;
}

.home {
	position: absolute;
	left: 650px;
	top: 1px;
}

.products {
	position: absolute;
	left: 750px;
	top: 1px;
}

.cart {
	position: absolute;
	left: 1000px;
	top: 1px;
}
</style>
</head>
<body>
	<form action="viewcart" method="get">
		<div class="navbar">
			<div class="home">
				<a href="homepage.jsp">Home</a>
			</div>
			<div class="products">
				<a href="userallproducts">All collections</a>
			</div>
			<div class="dropdown">
				<button class="dropbtn">
					categories <em class="fa fa-caret-down"></em>
				</button>
				<div class="dropdown-content">
					<a href="mensproducts">mens</a> <a href="womensshowproducts">womens</a>
					<a href="kidsshowproducts">kids</a> <a href="occasionsshowproducts">occasions</a>
				</div>
			</div>
			<div class="cart">
				<a href="cart">My cart</a>
			</div>
			<div class="orders">
				<a href="orders">My orders</a>
			</div>
			<div class="logout">
				<a href="index.jsp">Logout</a>
			</div>
			<div class="back">
				<a href="homepage.jsp">Back</a>
			</div>
		</div>

		<table>
			<caption></caption>
			<tr>
				<th></th>
				<td><img src="${cartitems.getImage()}" alt="show image"></td>
				<td>
					<h1>${cartitems.getProductname()}</h1>
					<h3>${cartitems.getType()}</h3>
					<h3>
						<strong>RS:${cartitems.getStandardcost()}</strong>
					</h3>
					<div class="counter">
						<div class="qty mt-5">
							<label for="count" class="minus bg-dark" onclick="minus()">-</label>
							<input type="number" class="count" id="count" name="qty"
								value="1"> <label for="count" class="plus bg-dark"
								onclick="plus()">+</label>
						</div>
					</div> <br>
					<div class="button">
						<button type="submit" class="bbtn btn-dark">Add to cart</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
<script>
	function minus() {
		var count = document.getElementById('count');
		count.value--;
		if (count.value == 0) {
			count.value = 1;
		}
	}
	function plus() {
		var count = document.getElementById('count');

		count.value++;
	}
</script>
</html>