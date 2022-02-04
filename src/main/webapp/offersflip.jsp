<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>your offers</title>
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
.flip-box {
  background-color: transparent;
  width: 300px;
  height: 300px;
  border: 1	px solid #cccccc;
  perspective: 1000px;
  margin-left:120px;
  margin-top:15px;
  
}


.flip-box-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

.flip-box:hover .flip-box-inner {
  transform: rotateY(180deg);
}

.flip-box-front, .flip-box-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
}

.flip-box-front {
  background-color: #bbb;
  color: black;
}

.flip-box-back {
  background-color: dodgerblue;
  color: white;
  transform: rotateY(180deg);
}
/* fjdsifdns */

.flip-box1 {
  background-color: transparent;
  width: 300px;
  height: 300px;
  border: 1px solid #cccccc;
  perspective: 1000px;
  margin-left:515px;
  margin-top:-300px;
  
}


.flip-box1-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

.flip-box1:hover .flip-box1-inner {
  transform: rotateY(180deg);
}

.flip-box1-front, .flip-box1-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
}

.flip-box1-front {
  background-color: #bbb;
  color: black;
}

.flip-box1-back {
  background-color: dodgerblue;
  color: white;
  transform: rotateY(180deg);
}

/* dfjisfdndsjf */

.flip-box2 {
  background-color: transparent;
  width: 300px;
  height: 300px;
  border: 1px solid #cccccc;
  perspective: 1000px;
  margin-left:920px;
  margin-top:-300px;
  
}


.flip-box2-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

.flip-box2:hover .flip-box2-inner {
  transform: rotateY(180deg);
}

.flip-box2-front, .flip-box2-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
}

.flip-box2-front {
  background-color: #bbb;
  color: black;
}

.flip-box2-back {
  background-color: dodgerblue;
  color: white;
  transform: rotateY(180deg);
}
 .abc{

            font-size: 50px;
               color:maroon;            
               
        }
        .flip{
        
       margin-top:-40px;
        
        }
        
       .christmas{
        margin-top:20px;
               margin-left:30px;
       
       } 
       .soon{
        margin-top:-175px;
               margin-left:570px;
       
       } 
        
</style>
</head>
<body>

<div class="abc">
 <marquee width="100%" direction="left" height="100px">
       pick your offers !!!
        </marquee>
        </div>
<div class="flip">
<div class="flip-box">
  <div class="flip-box-inner">
    <div class="flip-box-front">
     <a href="offertshirt"> <img src="images/perfect_pair_burgundy_couple_base_400x533.jpg" alt="show image" width="300" height="300"></a>
    </div>
    <div class="flip-box-back">
      <a href="offertshirt"><img src="images/gtg-tshirt-ads.jpg" alt="show image" width="300" height="300"></a>
    </div>
  </div>
</div>



<div class="flip-box1">
  <div class="flip-box1-inner">
    <div class="flip-box1-front">
     <a href="offersgift"> <img src="images/41vHeuKJWcS-300x300.jpg" alt="show image" width="300" height="300"></a>
    </div>
    <div class="flip-box1-back">
      <a href="offersgift"><img src="images/p-beautiful-memories-personalized-bottle-lamp-111967-m.webp" alt="show image" width="300" height="300"></a>
    </div>
  </div>
</div>


<div class="flip-box2">
  <div class="flip-box2-inner">
    <div class="flip-box2-front">
     <a href="offerskids"> <img src="images/p-personalized-led-rotating-crystal-cube-for-kids-114133-m.webp" alt="show image" width="300" height="300"></a>
    </div>
    <div class="flip-box2-back">
      <a href="offersflip.jsp"><img src="images/p-personalized-led-fur-pillow-for-kids-113964-m.webp" alt="show image" width="300" height="300"></a>
    </div>
  </div>
</div>

</div>
<div class="christmas">
<img src="images/SL-062121-43900-29.jpg"alt="show image"height="200px"width="1300">
</div>
<div class="soon">
<img src="images/Daco_61605.png"alt="show image"height="60px"width="300">
</div>
</body>
</html>