<%@page import="java.sql.SQLException"%>
<%@page import="com.chainsys.giftshop.impl.viewCartImpl"%>
<%@page import="com.chainsys.giftshop.model.viewcartPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

img {
	width: 200px;
	height: 200px;
	
}
.navbar {
  overflow: hidden;
  background-color:seashell;
  width:100%;
  margin-top:1px;
  height:55px;
  position: FIXED;
  
 
  
}

.navbar a {
  float: left;
  font-size: 16px;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  float:right;
  font-style: italic;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
		 font-size: 18px;
		margin-right:25px;
		margin-right:5px;
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
  background-color:goldenrod;
}

.dropdown-content {
  display: none;
  position: fixed;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
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
.car {
position:relative;
left:-30px;
top:100px;
	border-style: solid;
	border-color: goldenrod;
width: 20%;
	background-color: white;
	padding: 20px;
	border-radius:3px;
	
	
}
.abcd{

position:fixed;
left:100px;
}
th, td {
  padding: 7px;
  
}
.back{
position:absolute;
left:50px;
}

</style>
</head>
<body>
<div class="navbar">
<a href="index.jsp">Logout</a>
<a href="userallproducts.jsp">My orders</a>
<a href="cart.jsp">My cart</a>


  <div class="dropdown">
    <button class="dropbtn">categories 
      <i class="fa fa-caret-down"></i>
    </button>
    
    <div class="dropdown-content">
      <a href="mensshowproducts.jsp">mens</a>
      <a href="#">womens</a>
      <a href="#">kids</a>
      <a href="#">occasions</a>
      
    </div>
 
  </div> 
        
    <a href="userallproducts.jsp">All collections</a>
      <a href="homepage.jsp">Home</a>
       <div class="back">
      <a href="viewtshirt.jsp">Back</a>
      </div>
  
</div>
	<form action="viewcart1" method="post">	 
				
                      <center> <div class="car">
					<img src="${sessionScope.cartitmes.getImage()}">
					<br>
					Id:${sessionScope.cartitmes.getProductid()}
					<br>
					Name:${sessionScope.cartitmes.getProductname()}
					<br> 
					Type:${sessionScope.cartitmes.getType()}
					<br>
					<b>Rs:${sessionScope.cartitmes.getStandardcost()}</b>
					
<br>
		<label for="quantity">choose quantity:</label> 
		<select name="qqq">
			<option value=1>1</option>
			<option value=2>2</option>
			<option value=3>3</option>
			<option value=4>4</option>
			<option value=5>5</option>
			<option value=6>6</option>
			<option value=7>7</option>
			<option value=8>8</option>
			<option value=9>9</option>
			<option value=10>10</option>
			<option value=11>11</option>
			<option value=12>12</option>
		</select> <br><br><input type="submit">

					</div></center>
	</form>
		
</body>
</html>