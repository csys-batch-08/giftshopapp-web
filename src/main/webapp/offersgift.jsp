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
<title>Gift offers</title>
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
	padding-left:330px;
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
	border-radius:3px;
	
	
}
 .abc{

            font-size: 60px;
               color:maroon; 
                          
               
        }
          .qwerty{
        
        font-size: 40px;
               color:maroon; 
               margin-top:-500px;
                margin-left:170px;
        }
        .qwertyyy{
        
         font-size: 40px;
               color:maroon; 
               margin-top:-400px;
                margin-left:1000px;
        }
</head>
</style>
<body>

	<div class="abc">
 <marquee width="100%" direction="left" height="100px">
       offers of the day !!!
        </marquee>
        </div>
 
	 

    
                       <table>
		<tbody>
			<td>
			<tr>
			 <c:set var="count" value="1" />
				<c:forEach items="${offersgift}" var="offersgif">
				<td>
                            <div class="car">
					<div><img src="${offersgif.image}"></center></div> 
					
					<%-- <div><center>${offerstee.productId}</center></div>  --%>
					<div><center>${offersgif.productName}</center></div> 
					<div><center>${offersgif.type}</center></div> 
					<div><center><b>Offer price:Rs:${offersgif.standardCost}</center></b></div> 
				
			
				
		<center><a href="addtocartmobile?
		pid=${offersgif.productId}
		&image=${offersgif.image}
		&productName=${offersgif.productName}
		&type=${offersgif.type}
		&cost=${offersgif.standardCost}"><button type="button"
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
       
        <div class="qwerty">
 <marquee width="100%" direction="down" height="400px">
      <p>Normal<br>&nbsp price<br><del>&nbsp&nbsp$950</del></p>
        </marquee>
	</div>
	
	   <div class="qwertyyy">
 <marquee width="100%"direction="down" height="400px">
     <p>Normal<br>&nbspprice<br><del>&nbsp&nbsp$700</del></p>
        </marquee>
	</div>
</body>
</html>