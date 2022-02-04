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
<title>Customize mobile case</title>
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

/*  table img {
	width: 150px;
	height: 150px;
	
}  */

table{
margin-top:50px;
}
.car {

	border-style: solid;
	border-color: goldenrod;
     width: 100%;
	background-color: white;
	margin-top:-60px;
	margin-bottom: 70px;
	padding: 20px;
	border-radius:3px;
	
	
	
}

/* .button1 {
	margin-top: 180px;
	margin-left: -140px;
} */

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
.button1 {
	position: absolute;
	top:449px;
	left:100px;
}
.button2 {
	position: absolute;
	top:449px;
	left:430px;
}
.button3 {
	position: absolute;
	top:448px;
	left:760px;
}
.button4 {
	position: absolute;
	top:450px;
	left:1080px;
}
.button5 {
	position: absolute;
	top:825px;
	left:1080px;
}
.button6 {
	position: absolute;
	top:825px;
	left:760px;
}
.button7 {
	position: absolute;
	top:825px;
	left:430px;
}
.button8 {
	position: absolute;
	top:825px;
	left:100px;
}
#myImg {
  border-radius: 5px;
  width: 150px;
	height: 150px;
	
  cursor: pointer;
  transition: 0.3s;
}

#myImg:hover {opacity: 0.7;}

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
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
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

@-webkit-keyframes zoom {
  from {-webkit-transform:scale(0)} 
  to {-webkit-transform:scale(1)}
}

@keyframes zoom {
  from {transform:scale(0)} 
  to {transform:scale(1)}
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

.close:hover,
.close:focus {
  color: #bbb;
  text-decoration: none;
  cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px){
  .modal-content {
    width: 100%;
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
	 <table>
		<tbody>
			<td>
			<tr>
				<c:set var="count" value="1" />
				<c:forEach items="${mensmobilecase}" var="menscase">
				
				
				<td>

                            <div class="car">
								<img id="myImg" src="${menscase.image}" alt="image">
								<div id="myModal" class="modal">
									<span class="close">&times;</span> <img class="modal-content"
										id="img01">
									<div id="caption"></div>
								</div>
								<br>
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
	     
					<%-- <div><img src="${menscase.image}"></center></div>  --%>
					<br>
					<div><center>${menscase.productId}</center></div>
					<c:set var="pid" value="${menscase.productId}" scope="session" />
					<div><center>${menscase.productName}</center></div> 
					<div><center>${menscase.type}</center></div> 
					<div><center><b>Rs:${menscase.standardCost}</center></b></div> 
				
				<br>
				
		<center><a href="addtocartmobile?
		pid=${menscase.productId}
		&image=${menscase.image}
		&productName=${menscase.productName}
		&type=${menscase.type}
		&cost=${menscase.standardCost}"><button type="button"
				class="btn btn-default">Add to cart</button></a></center>
	
					</div>
	</td>
					<c:choose>
						<c:when test="${count==6}">
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
			</td>
		</tbody>
	</table>  
                     
	</form>

</body>
</html>
