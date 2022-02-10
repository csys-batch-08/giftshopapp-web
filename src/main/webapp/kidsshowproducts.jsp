<%@page import="com.chainsys.giftshop.model.ProductPojo"%>
<%@page import="com.chainsys.giftshop.impl.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Kids products</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"></script>
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

table {
	margin-top: 20px;
}

h2 {
	margin-left: 600px;
}

.car {
	border-style: solid;
	border-color: goldenrod;
	width: 100%;
	background-color: white;
	margin-top: -60px;
	margin-bottom: 70px;
	padding: 20px;
	border-radius: 3px;
}

.navbar {
	overflow: hidden;
	background-color: seashell;
	width: 100%;
	margin-top: 1px;
	height: 55px;
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
	padding: 55px;
	padding-top: 10px;
}

.button1 {
	position: absolute;
	top: 449px;
	left: 100px;
}

.button2 {
	position: absolute;
	top: 449px;
	left: 430px;
}

.button3 {
	position: absolute;
	top: 448px;
	left: 760px;
}

.button4 {
	position: absolute;
	top: 450px;
	left: 1080px;
}

.button5 {
	position: absolute;
	top: 825px;
	left: 1080px;
}

.button6 {
	position: absolute;
	top: 825px;
	left: 760px;
}

.button7 {
	position: absolute;
	top: 825px;
	left: 430px;
}

.button8 {
	position: absolute;
	top: 825px;
	left: 100px;
}

#myImg {
	border-radius: 5px;
	width: 150px;
	height: 150px;
	cursor: pointer;
	transition: 0.3s;
}

#myImg:hover {
	opacity: 0.7;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal-content {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
}

/* Caption of Modal Image */
#caption {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
	text-align: center;
	color: #ccc;
	padding: 10px 0;
	height: 150px;
}

/* Add Animation */
.modal-content, #caption {
	-webkit-animation-name: zoom;
	-webkit-animation-duration: 0.6s;
	animation-name: zoom;
	animation-duration: 0.6s;
}

@
-webkit-keyframes zoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes zoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* The Close Button */
.close {
	position: absolute;
	top: 15px;
	right: 35px;
	color: #f1f1f1;
	font-size: 40px;
	font-weight: bold;
	transition: 0.3s;
}

.close:hover, .close:focus {
	color: #bbb;
	text-decoration: none;
	cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px) {
	.modal-content {
		width: 100%;
	}
	.back {
		position: absolute;
		left: 50px;
	}
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
	<h2 class="Products">Kids products</h2>

	<table>
		<caption></caption>
		<th></th>
		<tr>

			<c:set var="count" value="1" />
			<c:forEach items="${kids}" var="kidsproducts">

				<td>
					<div class="car">
						<img id="myImg" src="${kidsproducts.image}" alt="image">
						<div id="myModal" class="modal">
							<span class="close">&times;</span> <img class="modal-content"
								id="img01" alt="show image">
							<div id="caption"></div>
						</div>
						<br> <br> ${kidsproducts.productName}<br>
						${kidsproducts.description} <strong>Starts from
							RS:${kidsproducts.standardCost}</strong> <br>
					</div>

				</td>

				<c:choose>
					<c:when test="${count==4}">
						<c:set var="count" value="1" />
						<tr></tr>
					</c:when>
					<c:otherwise>
						<c:set var="count" value="${count+1}" />
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
	</table>
	<div class="button1">
		<a href="kidsmugs"><button type="button" class="btn btn-success">View
				product</button> </a>
	</div>
	<div class="button2">
		<a href="kidstshirts"><button type="button"
				class="btn btn-success">View product</button> </a>
	</div>
	<div class="button3">
		<a href="viewtshirt.jsp"><button type="button"
				class="btn btn-success">View product</button> </a>
	</div>
	<div class="button4">
		<a href="viewtshirt.jsp"><button type="button"
				class="btn btn-success">View product</button> </a>
	</div>
	<div class="button5">
		<a href="viewtshirt.jsp"><button type="button"
				class="btn btn-success">View product</button> </a>
	</div>
	<div class="button6">
		<a href="viewtshirt.jsp"><button type="button"
				class="btn btn-success">View product</button> </a>
	</div>
	<div class="button7">
		<a href="viewtshirt.jsp"><button type="button"
				class="btn btn-success">View product</button> </a>
	</div>
	<div class="button8">
		<a href="viewtshirt.jsp"><button type="button"
				class="btn btn-success">View product</button> </a>
	</div>

	<script>
		var modal = document.getElementById("myModal");
		var img = document.getElementById("myImg");
		var modalImg = document.getElementById("img01");
		var captionText = document.getElementById("caption");
		img.onclick = function() {
			modal.style.display = "block";
			modalImg.src = this.src;
			captionText.innerHTML = this.alt;
		}
		var span = document.getElementsByClassName("close")[0];
		span.onclick = function() {
			modal.style.display = "none";
		}
	</script>

</body>
</html>