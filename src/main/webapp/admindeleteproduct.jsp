<%@page import="com.chainsys.giftshop.model.ProductPojo"%>
<%@page import="com.chainsys.giftshop.impl.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />

<title>All products</title>
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
	background-size: cover;
	background-attachment: fixed;
	
	 
}

 table img {
	width: 150px;
	height: 150px;
	border-style: solid;
	border-radius: 5%;
	border: 5px solid #daa520;
} 
.navbar {
  overflow: hidden;
  background-color:seashell;
  width:100%;
  margin-top:1px;
  height:55px;
  position:fixed;
 
 
  
}
.navbar a {
	
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
padding: 20px; 
padding-right:43px;
} 
.back{
position:relative;
left:-1000px;
}
.car{
margin-top:60px;
} 

</style>

</head>

<body>
<body>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    <script>$('#invokesToastMessage').click(function deleteproduct() { toastr.success('message', 'title'); });</script>
</body>

<div class="navbar">
		<a href="index.jsp">Logout</a> 
		<a href="adminlogin.jsp">Home</a> 
		
 <div class="back">
      <a href="adminlogin.jsp">Back</a>
      </div>
	</div>
	
 <table>
	    <tr>
				<c:set var="count" value="1" />
				<c:forEach items="${deleteproduct}" var="deletepro">
       <td>
					<div class="car">
					<img src="${deletepro.image}"alt="show image"> 
					<div>Product id:${deletepro.productId}</div> 
					<div>${deletepro.productName}</div>
					<div class="button">
				     <a href="delproduct?pid=${deletepro.productId}"><button onclick="deleteproduct()">Delete product</button></a>
					 </div>
				     </div>			
	  <td>
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
</body>
<script type="text/javascript">
function deleteproduct() {
	var result = confirm("Are you sure want to delete?");
	if (result == false) {
		event.preventDefault();
	}
}
</script>
</html>
