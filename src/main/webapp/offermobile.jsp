<%@page import="com.chainsys.giftshop.model.ProductPojo"%>
<%@page import="com.chainsys.giftshop.impl.*"%>
<%@page import="java.util.*"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Offer of the day</title>
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
	border-style: solid;
	border-radius: 5%;
	border: 5px solid #daa520;
	/* border: 1px solid #ddd;
  border-radius: 4px;
  padding: 5px;
  width: 150px; */
}
table {
	width: 2%;
	float: left;
}
.button {
	margin-top: 170px;
	margin-left: 33px;
}
 .abc{

            font-size: 60px;
               color:maroon; 
                          
               
        }
        .abcd{
        margin-top: 100px;
        margin-left: 230px;
        
        }
        .p{
       position:absolute;left:310px;top:40px;
        }
        .p1{
       position:absolute;left:730px;top:40px;
        }
</head>
</style>
<body>
		<div class="p">
<p>Nomral price:<del>Rs:180</del></p>
</div>
<div class="p1">
<p>Nomral price:<del>Rs:420</del></p>
</div>
		<%
		ProductsImpl dao=new ProductsImpl();
		List<ProductPojo>offers;
		offers=dao.offermobile();
		%>

	<%
	
				for (ProductPojo showPrice : offers) {
					
	%>
	<form>



		<div class="abcd">
			<table>
				<tbody>
					<tr>
						<td>

							<table id="product">
								<tbody>
									<tr>
										<div id="item1">

											<td><img src=<%=showPrice.getImage()%> alt="Show image"></td>
										<td class="car">



											<div>

												<%=showPrice.getProductName()%>
											</div>
											<div>
												Type:<%=showPrice.getType()%>
											</div>
											<div>
												<b>Offer price:Rs:<%=showPrice.getStandardCost()%></b>

											</div>


										</td>
									</tr>
								</tbody>
							</table> <a
							href="addcart1.jsp?
							&pid=<%=showPrice.getProductId()%>
							&pname=<%=showPrice.getProductName()%>
							&img=<%=showPrice.getImage()%>
							&type=<%=showPrice.getType()%>
							&price=<%=showPrice.getStandardCost()%>">
								<div class="button">
									<button type="button" class="btn btn-default">Add to
										cart</button>
								</div>
						</a>
							</div>


							</div>
						</td>

					</tr>
					<tr>

						<%
										
										
										
										}
										%>

					</tr>
				</tbody>
			</table>
	</form>
<div class="abc">
 <marquee width="100%" direction="left" height="100px">
       offers of the day !!!
        </marquee>
	</div>
	</div>
	</div>
	</div>




	</div>

</body>
</html>