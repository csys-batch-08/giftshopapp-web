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
<title>Offer for kids</title>
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
	width: 300px;
	height: 300px;
}

table {
	padding: 30px;
	padding-left: 330px;
}

.button {
	margin-top: 170px;
	margin-left: 33px;
}

.car {
	border-style: solid;
	border-color: goldenrod;
	width: 100%;
	background-color: white;
	padding: 5px;
	border-radius: 3px;
}

.abc {
	font-size: 60px;
	color: maroon;
}

.qwerty {
	font-size: 40px;
	color: maroon;
	margin-top: -500px;
	margin-left: 170px;
}

.qwertyyy {
	font-size: 40px;
	color: maroon;
	margin-top: -400px;
	margin-left: 1000px;
}
</
head
>
</style>
<body>
	<div class="abc">
		<marquee width="100%" direction="left" height="100px">
			offers of the day !!! </marquee>
	</div>




	<table>

		<tr>
			<c:set var="count" value="1" />
			<c:forEach items="${offerskids}" var="offerskid">

				<td>
					<div class="car">
						<div>
							<img src="${offerskid.image}" alt="show image">
						</div>
						<div>${offerskid.productName}</div>
						<div>${offerskid.type}</div>
						<div>
							<strong>Offer price:Rs:${offerskid.standardCost}</strong>
						</div>



						<a
							href="addtocartmobile?
		pid=${offerskid.productId}
		&image=${offerskid.image}
		&productName=${offerskid.productName}
		&type=${offerskid.type}
		&cost=${offerskid.standardCost}"><button
								type="button" class="btn btn-default">Add to cart</button></a>

					</div>
				</td>
				<c:choose>
					<c:when test="${count==6}">
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

	<div class="qwerty">
		<marquee width="100%" direction="down" height="400px">
			<p>
				Normal<br>price<br>
				<del>$1605</del>
			</p>
		</marquee>
	</div>

	<div class="qwertyyy">
		<marquee width="100%" direction="down" height="400px">
			<p>
				Normal<br>price<br>
				<del>$885</del>
			</p>
		</marquee>
	</div>
</body>
</html>