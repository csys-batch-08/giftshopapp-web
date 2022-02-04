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
table{

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
padding: 25px; 
padding-right:40px;
}
table{
/* border-spacing: 22px; */

}
.button1 {
   position:absolute;
	top: 300px;
	left: 55px;
}
.button2 {
  position:absolute;
	top: 300px;
	left: 335px;
}
.button3 {
   position:absolute;
	top: 300px;
	left: 630px;
}
.button4 {
   position:absolute;
	top: 300px;
	left: 910px;
}
.button5 {
   position:absolute;
	top: 537px;
	left: 55px;
}
.button6 {
   position:absolute;
	top: 537px;
	left: 335px;
}
.button7 {
   position:absolute;
	top: 537px;
	left: 630px;
}
.button8 {
   position:absolute;
	top: 537px;
	left: 910px;
}
.button9 {
   position:absolute;
	top: 770px;
	left: 55px;
}
.button10 {
   position:absolute;
	top: 770px;
	left: 335px;
}
.button11 {
   position:absolute;
	top: 770px;
	left: 630px;
}
.button12 {
   position:absolute;
	top: 770px;
	left: 910px;
}
.buttona {
   position:absolute;
	top: 300px;
	left: 1195px;
}
.buttonb {
   position:absolute;
	top: 537px;
	left: 1195px;
}
.buttonc {
   position:absolute;
	top: 770px;
	left: 1195px;
} 

</style>
</head>
<body>
<div class="navbar">
		<a href="index.jsp">Logout</a> 
		<a href="adminlogin.jsp">Home</a> 

	</div>

 <center><h2 class="Products">All products</h2></center>
 
 <table>
		<tbody>
			<th>
			<tr>
				<c:set var="count" value="1" />
				<c:forEach items="${adminshowproduct}" var="adminshow">

<td>
					<div class="car">
					<div><img src="${adminshow.image}"></div> 
						<div><center><b>${adminshow.productName}</b></center></div> 
					</div>
					<td>
					<c:choose>

						<c:when test="${count==5}">
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
 
	<div class="button1">
<a href="adminviewmenstshirt"><button>view product</button></a> 
		</div>	
		<div class="button2">
<a href="adminviewtshirts.jsp"><button>view product</button></a> 
		</div> 
				<div class="button3">
<a href="adminviewmobilecase"><button>view product</button></a> 
		</div> 
		<div class="button4">
<a href="adminviewcaricature"><button>view product</button></a> 
		</div> 
		<div class="button5">
<a href="adminviewtshirts.jsp"><button>view product</button></a> 
		</div>	
		<div class="button6">
<a href="adminviewtshirts.jsp"><button>view product</button></a> 
		</div> 
				<div class="button7">
<a href="adminviewmobilecase.jsp"><button>view product</button></a> 
		</div> 
		<div class="button8">
<a href="adminviewmobilecase.jsp"><button>view product</button></a> 
		</div>
				<div class="button9">
<a href="adminviewmobilecase.jsp"><button>view product</button></a> 
		</div> 
		<div class="button10">
<a href="adminviewtshirts.jsp"><button>view product</button></a> 
		</div>	
		<div class="button11">
<a href="adminviewtshirts.jsp"><button>view product</button></a> 
		</div> 
				<div class="button12">
<a href="adminviewmobilecase.jsp"><button>view product</button></a> 
		</div> 
		<div class="buttona">
<a href="adminviewmobilecase.jsp"><button>view product</button></a> 
		</div> 
		<div class="buttonb">
<a href="adminviewmobilecase.jsp"><button>view product</button></a> 
		</div> 
		<div class="buttonc">
<a href="adminviewmobilecase.jsp"><button>view product</button></a> 
		</div> 
		
</body>


</html>
