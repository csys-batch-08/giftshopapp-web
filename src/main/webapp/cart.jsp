<%@page import="com.chainsys.giftshop.model.viewcartPojo"%>
<%@page import="com.chainsys.giftshop.model.ProductPojo"%>
<%@page import="com.chainsys.giftshop.impl.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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

table img {
	width: 150px;
	height: 150px;
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
  padding: 15px;
  
  
}
.total{
 position:fixed;left: 1070px;top: 150px; text-align: justify;
            border: 3px solid goldenrod;
            width: 200px;
            background-color: white;
            
}
form .button{
   height: 45px;
   margin: 35px 0;
   
 }
  form .button input{
   height: 7%;
   width: 10%;
   border-radius: 5px;
   border: none;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background:rgba(165, 110, 9, 0.863);
   position: fixed;left: 1100px;top: 195px;
 }
 form .button input:hover{
  transform: scale(0.99);
  background:rgb(241, 175, 7);
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
<a href="gorders.jsp">My orders</a>
<a href="cart.jsp">My cart</a>


  <div class="dropdown">
    <button class="dropbtn">categories 
      <i class="fa fa-caret-down"></i>
    </button>
    
    <div class="dropdown-content">
      <a href="mensshowproducts.jsp">mens</a>
      <a href="womensshowproducts.jsp">womens</a>
      <a href="kidsshowproducts.jsp">kids</a>
      <a href="occasionsshowproducts.jsp">occasions</a>
      
    </div>
 
  </div> 
        
    <a href="userallproducts.jsp">All collections</a>
      <a href="homepage.jsp">Home</a>
      
      <div class="back">
      <a href="addcart.jsp">Back</a>
      </div>
      
  
</div>
		<form action="buynow"method="post">
		<center><h2 class="Products">your cart</h2></center>
		
		<table>
		<tbody>
			<th>
			<tr>

				<c:set var="count" value="1" />
				<c:forEach items="${car}" var="cartproducts">
				 <c:set var="sum" value="${cartproducts.standardcost*cartproducts.quantity}" />
	             <c:set var="sum1" value="${sum1+sum}"/>
											
				<td>
				
				
                     <div class="car">
					<div><img src="${cartproducts.image}"></center></div> 
					<br>
					<center>${cartproducts.productname}</center>
					<center>${cartproducts.type}</center>
					<center>Rs:${cartproducts.standardcost}</center>
					<center><b>Size:${cartproducts.size}</center></b>
					<center><b>qty:${cartproducts.quantity}</center></b> 
					<center><b>Purchase amount:${sum}</center></b> 
				
				<br>
					<td>
					<c:choose>

						<c:when test="${count==4}">
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
                  <div class="button">
                    <input type="submit" value="Buy now">
                  </div>				
</form>
			<div class="total">Total amount Rs:${sum1}</div>	 	
</body>
</html>