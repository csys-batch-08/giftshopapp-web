<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome giftshop</title>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;

}

body {
	background-image: url("images/plain-yellow-wall-product-background.jpg");
	background-repeat: no-repeat;
	background-size: 1370px 620px;
	/* background-size: cover; */
	background-attachment: fixed;
}
.btn-success {
	position:fixed;
	left:500px;
	top:530px;
	width:10%;
}
.btn-info {
	position:fixed;
	left:680px;
	top:530px;
	width:10%;
}

h2{
 font-style: italic;
    font-family:serif;
  font-size: 40px;
  left: 460px;
  top: 450px;
  position: fixed;
  letter-spacing: 2px
  
     color: black; 
  margin: 10px 0 0 10px;
  white-space: nowrap;
  overflow: hidden;
  width: 100%;
  animation: animtext 10s steps(80, end); 
   transition: all cubic-bezier(0.1, 0.7, 1.0, 0.1);
}
@keyframes animtext { 
  from {
      width: 0;
     transition: all 2s ease-in-out;
  } 
}
</style>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body> 


  <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="d-block w-60" src="https://www.createngift.com/wp-content/uploads/2019/06/Personalized-Gifts-Banner-2.jpg" alt="First slide"width="1370" height="400">
          </div>
          <div class="carousel-item">
            <img class="d-block w-60" src="https://www.createngift.com/wp-content/uploads/2019/06/Customized-gifts-banner.jpg" alt="Second slide"width="1370" height="400">
          </div>
          <div class="carousel-item">
            <img class="d-block w-60" src="https://www.createngift.com/wp-content/uploads/2020/09/banner-2-1400x482.jpg" alt="Third slide"width="1370" height="400">
          </div>
        </div>
      </div>
      
  
  <div class="container">
	<div class="row">
		<h2>Open Gift With your smile...</h2>
	</div>
</div>
  
									<a href="registration.jsp"><button type="button" class="btn btn-success">Signup</button></a>
										
									<a href="login.jsp"><button type="button" class="btn btn-info">login</button></a>
</body>
</html>