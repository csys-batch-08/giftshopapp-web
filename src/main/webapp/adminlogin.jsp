<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<style>
body {
	background-image: url("images/bg.jpg");
	background-repeat: no-repeat;
	background-size: 1370px 620px;
	background-attachment: fixed;
}

form .button1 {
	height: 45px;
	margin: 35px 0;
}

form .button1 input {
	height: 100%;
	width: 20%;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 18px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: rgba(165, 110, 9, 0.863);
	position: relative;
	left: 505px;
	top: 180px;
}

form .button1 input:hover {
	transform: scale(0.99);
	background: rgb(0, 162, 255);
}

form .button2 {
	height: 45px;
	margin: 35px 0;
}

form .button2 input {
	height: 100%;
	width: 20%;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 18px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: rgba(165, 110, 9, 0.863);
	position: relative;
	left: 505px;
	top: 180px;
}

form .button2 input:hover {
	transform: scale(0.99);
	background: rgb(0, 255, 13);
}

form .button3 {
	height: 45px;
	margin: 35px 0;
}

form .button3 input {
	height: 100%;
	width: 20%;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 18px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: rgba(165, 110, 9, 0.863);
	position: relative;
	left: 505px;
	top: 180px;
}

form .button3 input:hover {
	transform: scale(0.99);
	background: rgb(255, 230, 0);
}

form .button4 {
	height: 45px;
	margin: 35px 0;
}

form .button4 input {
	height: 100%;
	width: 20%;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 18px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: rgba(165, 110, 9, 0.863);
	position: relative;
	left: 505px;
	top: 180px;
}

form .button4 input:hover {
	transform: scale(0.99);
	background: rgb(241, 7, 7);
}

form .button5 {
	height: 45px;
	margin: 35px 0;
}

form .button5 input {
	height: 100%;
	width: 20%;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 18px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: rgba(165, 110, 9, 0.863);
	position: relative;
	left: 505px;
	top: 180px;
}

form .button5 input:hover {
	transform: scale(0.99);
	background: rgb(255, 230, 0);
}
.admin{
position: relative;
	left: 20px;
	top: -70px;
}

        .content form .user-details{
  display: ruby;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 20px 0 12px 0;
}
form .user-details .input-box{
  margin-bottom: 10px;
}
form .input-box span.details{
  display: block;
  font-weight: 500;
  margin-bottom: -20px;
}
.user-details .input-box input{
  height: 40px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 0.15px solid #ccc;
  border-bottom-width: 3px;
  transition: all 0.3s ease;
}
.user-details .input-box input:focus,
.user-details .input-box input:valid{
  border-color: goldenrod;
}
form .button{
   height: 45px;
   margin: 2px 0;
 }
 form .button input{
   height: 100%;
   width: 40%;
   border-radius: 1px;
   border: none;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background:rgba(165, 110, 9, 0.863);
   position: relative;left: 162px;top: 7px;
 }
 form .button input:hover{
  transform: scale(0.99);
  background:rgb(241, 175, 7);
  }
  .btn-info{
background-color: goldenrod;
  width:20%;
  position:absolute;
  left:500px;
 top:180px;
 
}
  .btn-primary{
  background-color: goldenrod;
  width:20%;
  position:absolute;
  left:500px;
  top:230px;
  }
.btn-success{
background-color: goldenrod;
  width:20%;
  position:absolute;
  left:500px;
  top:280px;
}
.btn-danger{
background-color: goldenrod;
  width:20%;
  position:absolute;
  left:500px;
  top:330px;
}

.btn-warning{
background-color: goldenrod;
  width:20%;
  position:absolute;
  left:500px;
  top:380px;
}

</style>

</head>

<body>


	<a href="adminshowproducts"><button type="button" class="btn btn-info">Show products</button></a>
	
		<!-- insert -->
	<div class="container">
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Insert product</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h1 class="modal-title">Insert</h1>
        </div>
        <div class="modal-body">
         
        
    <form action="insert" method="post">
        <div class="user-details">
            <div class="input-box">
                <label class="details">Product id</label>
                <input type="text"id="productid" name="productid"pattern="[1-9]{1}[0-9]+" title="Negative values not allowd" placeholder="Enter product id" required>
              </div>
            <div class="input-box">
                <label class="details">Product name</label>
                <input type="text" id="productname" name ="productname"placeholder="Enter product name" required>
              </div>
              <div class="input-box">
                <label class="details">Description</label>
                <input type="text" id="productdescription" name ="productdescription"placeholder="Enter product Decription" required>
              </div>
              <div class="input-box">
                <label class="details">price</label>
                <input type="text" id="productprice" name ="productprice"pattern="[1-9]{1}[0-9]+" title="Negative values not allowd"placeholder="Enter product price" required>
              </div>
              <div class="input-box">
                <label class="details">category</label>
                <input type="text" id="productcategory" name ="productcategory" placeholder="Enter product category" required>
              </div>
              <div class="input-box">
                <label class="details">quantity</label>
                <input type="text" id="productquantity" name ="productquantity" pattern="[1-9]{1}[0-9]+" title="Negative values not allowd"placeholder="Enter product quantity" required>
              </div>
               <div class="input-box">
                <label class="details">Image</label>
                <input type="text" id="image" name ="image" placeholder="Insert product image" required>
              </div>
               <div class="input-box">
                <label class="details">Type</label>
                <input type="text" id="type" name ="type"placeholder="enter product type" required>
              </div>
            </div>
            <div class="button">
                <input type="submit" value="Insert product">
              </div>

       </form>
    </div>
        
   <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    
        </div>
       
      </div>
      
    </div>
  </div>
  

<br>
	
	<!-- update -->
	<div class="container">
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal1">Update product</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h1 class="modal-title">Update</h1>
        </div>
        <div class="modal-body">
         
        
    <form action="update" method="post">
			<div class="user-details">
				<div class="input-box">
					<label class="details">Product id</label> <input type="text"
						name="productid"id="productsid"pattern="[1-9]{1}[0-9]+" title="Negative values not allowd" placeholder="Enter product id" required>
				</div>
				<div class="input-box">
					<label class="details">price</label> <input type="text" name="price"id="price"pattern="[1-9]{1}[0-9]+" title="Negative values not allowd"
						placeholder="Enter product price to update" required>
				</div>
				<div class="input-box">
					<label class="details">quantity</label> <input type="number"
						name="quantity"id="number"pattern="[1-9]{1}[0-9]+" title="Negative values not allowd" placeholder="Enter product quantity to update"
						required>
				</div>
			</div>
			<div class="button">
				<input type="submit" value="Update product">
			</div>
    
        
   <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    </form>
        </div>
       
      </div>
      
    </div>
  </div>
  
</div>

 
                 
               
                    <a href="delete"><button type="button" class="btn btn-danger">Delete product</button></a>
              
    
   
<a href="showusers"><button type="button" class="btn btn-warning">Users</button></a>

</body>
</html>


