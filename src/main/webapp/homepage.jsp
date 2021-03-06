<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Welcome gift shop</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
body {
	background-image: url("images/bg.jpg");
	background-repeat: no-repeat;
	background-size: 1370px 620px;
	/* background-size: cover; */
	background-attachment: fixed;
}

#logo {
	position: relative;
	left: 110px;
	top: 1px;
	position: fixed;
}

#title {
	font-style: italic;
	font-size: 100px;
	color: black;
	text-align: left;
	line-height: 85px;
	position: fixed;
	font-family: serif;
	left: 340px;
	top: 65px;
	position: fixed;
}

#slogan {
	font-family: Verdana, Geneva, Tahoma, sans-serif;
	position: relative;
	left: 320px;
	top: 350px;
	letter-spacing: 4px;
	text-align: left;
	position: fixed;
}

.Buynow {
	position: relative;
	left: 570px;
	top: 480px;
	background-color: goldenrod;
	border: none;
	color: black;
	padding: 5px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 25pX;
	position: fixed;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

.navbar {
	overflow: hidden;
	background-color: seashell;
	width: 100%;
	margin-top: -7px;
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

#logo {
	position: relative;
	left: 100px;
	top: 2px;
	position: fixed;
}

.blink_me {
	animation: blinker 1s linear infinite;
}

@
keyframes blinker { 50% {
	opacity: 0;
}
}
</style>

</head>
<body>


	<div class="navbar">
		<a href="offersflip.jsp">
			<div class="blink_me">$ Offers of the day $</div>
		</a> <a href="index.jsp">Logout</a> <a href="orders">My orders</a> <a
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

	</div>


	<div id="logo">
		<img src="images/pngwing.com (2).png" height="45px" width="150px"
			alt="show image">
	</div>

	<div id="title">
		<P>
			Awesome gifts<br> for your loved one..
		</P>
	</div>

	<div id="slogan">
		<P>Make your loved ones happy with one of our personalized gifts !</P>
	</div>

	<a href="userallproducts.jsp" class="Buynow">Buy now</a>

</body>
</html>