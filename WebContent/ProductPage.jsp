<%@page import="interfaces.ProductIntProxy"%>
<%@page import="interfaces.ProductObject"%>
<%@page import="interfaces.CartEntryObject"%>
<%@page import="interfaces.CartIntProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" rev="stylesheet" type="text/css"
	href="css/productPage.css" media="screen" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>

<title>Apples e-commerce Product</title>
</head>
<body>
	<div id="page">
		<c:import url="include/header.inc.jsp" />
		<c:import url="include/navigation.inc.jsp" />
		<div class="productPage">
			<% 
    int productId = Integer.parseInt(request.getParameter("productId"));
  	ProductObject product = new ProductIntProxy().findProduct(productId);
  	double total = (double)(product.getPrice())/100;
  %>
			<div class="item" id="<%out.print(product.getProduct_id());%>">
				<div class="title">
					<span> <%out.println(product.getTitle() ); %>
					</span>
				</div>
				<div class="image">
					<img
						src=<%
          String kg = "";
          if (product.getCategory_id() == 1)
        	  kg = " kg";
          out.println(product.getImgLink()); 
          
          %>
						alt="" />
				</div>
				<div class="quantity" id="<%out.print(product.getProduct_id());%>">
					<button class="plus-btn" type="button"
						onclick="plusFunction(<%out.print(product.getProduct_id());%>, <%out.print(product.getPrice());%>,'<%out.print(product.getProduct_id());%>')"
						name="<%out.print(product.getPrice());%>">+</button>
					<input type="text" readonly
						id="<%out.print("i"+product.getProduct_id());%>" value="1 kg"></input>
					<button class="minus-btn" type="button"
						onclick="minusFunction(<%out.print(product.getProduct_id());%>, <%out.print(product.getPrice());%>,'<%out.print(product.getProduct_id());%>')"
						name="<%out.print(product.getPrice());%>">-</button>
					<br></br>
					<button class="cart-btn" type="button"
						onclick=""
						name="<%out.print(product.getPrice());%>">Add to Cart</button>
					<br></br>

				</div>

				<div class="total-price"
					id="<%out.print("t"+product.getProduct_id());%>">
					<%out.print(total + " €"); %>
				</div>

				
			



			</div>
			
			<div class="summary">
					<%out.print(product.getSummary()); %>
				</div>
				<br><br>
				
					<div class="description">
					<%out.print(product.getDescription()); %>
				</div>
			<%

  
  %>


		</div>

		<script type="text/javascript">
    	 var array = null;
    
    	   function plusFunction(product,price,array1) {
    		 if (this.array == null)
    			 this.array=array1;
    		 var quantity = document.getElementById("i"+product).value;
    		 document.getElementById("i"+product).value = (parseInt(quantity) + 1) + " kg";
    		 document.getElementById("t"+product).innerHTML = ((parseFloat(quantity) + 1) * parseFloat(price) / 100) + " €";	
    		 total(array);
    	   } 
    	   
    	   function minusFunction(product,price,array1) {
    			 if (this.array == null)
        			 this.array=array1;
    		 var quantity = document.getElementById("i"+product).value;
    		 var quantityInt = quantity.replace(" kg", "");
    		 if (parseInt(quantityInt) > 0){
      		 document.getElementById("i"+product).value = parseInt(quantity) - 1 + " kg";;
      		 document.getElementById("t"+product).innerHTML = ((parseFloat(quantity) - 1) * parseFloat(price) / 100) + " €";}
      		 total(this.array);
   	   		}  
    	   
    	   function total(array) {
    		   this.array = array;
    		   var total =  0;
    		   for (var i = 0, len = array.length; i < len; i++) {
    			   var test1 = parseFloat(document.getElementById("t"+array[i]).innerHTML);
    			   total = total + test1;
    			 }
    		   document.getElementById("total-order").innerHTML = "<b>Total " + total + " €</b>";
     	   }  
    	  
    	   
    	   
    	   function confirmOrder(cartId) {
    		   var id=document.getElementById("attribute").innerHTML;
    		   if (id==0)
    			   window.location = ("cart.jsp?message=You are not LOGGED!");
    		   else{
    			   document.cookie = "products=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
       		    var date = new Date();
       		    date.setTime(date.getTime() + (30*24*60*60*1000));
       	        expires = "; expires=" + date.toUTCString();
       		    var name = "products";
       		    var value = "";
       			  for(var i = array.length - 1; i >= 0; i--) {
       				     var product = array[i];
       				     product.replace("kg", "").replace(" ","");
       		    		 var quantity = document.getElementById("i"+product).value;
       		    		 quantity.replace("kg", "").replace(" ","");
       		      		 value=value+product+","+quantity+".";
       		      		 
       			  }
       		    document.cookie = name + "=" + value + expires + "; path=/";
       		    window.location = ("payment.jsp?cart_id="+cartId);
    		   }
   	   }
    	 
    	   
    </script>
	</div>

	<c:import url="include/footer.inc.jsp" />

</body>
</html>