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
	href="css/header.css" media="screen" />
	
<link rel="stylesheet" rev="stylesheet" type="text/css"
	href="css/cart.css" media="screen" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>

<title>Apples e-commerce Cart</title>
</head>

<%
 
  
  Cookie[] cookies = request.getCookies();
  Cookie myCookie = null;
  if (cookies != null) {
   for (Cookie cookie : cookies) {
     if (cookie.getName().equals("cart")) {
        myCookie = cookie;
      }
    }
  }
  
 
  if (myCookie == null)
	  response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp?message=Cart is empty"));
  
  
  if (myCookie != null){
  String st =  "";
  CartIntProxy cip = new CartIntProxy();
  CartEntryObject[] ceos = cip.getCartContent(Integer.parseInt(myCookie.getValue()));

  if (ceos == null)
	  response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp?message=Cart is empty"));
  
  int c = 0;
  for (CartEntryObject ceo : ceos){
	  st += ceo.getProduct_id();
	c++;}
  
  
  int attribute =0;
  try{
  	attribute = (int)session.getAttribute("customer_id");
  }
  catch (Exception e){
  	attribute = 0;}
  
  
  %>
<body onload="total('<%out.print(st);%>')">
	<div id="page">

		<c:import url="include/header.inc.jsp" />
		<c:import url="include/navigation.inc.jsp" />

<div type="hidden" class="attribute" id="attribute" value="<%out.print(attribute); %>"><%out.print(attribute);%></div>


		<div class="shopping-cart">
			<!-- Product #1 -->

			<% 
  for (CartEntryObject ceo : ceos){
  	ProductObject product = new ProductIntProxy().findProduct(ceo.getProduct_id());
  	double total = ((((double)product.getPrice())/100))*ceo.getQuantity();
  %>
			<script> total('<%out.print(st);%>'); </script>


			<div class="item" id="<%out.print(product.getProduct_id());%>"
				onload="total('<%out.print(st);%>')">
				<div class="title">
					<span>
						<%out.println(product.getTitle() ); %>
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
						onclick="plusFunction(<%out.print(product.getProduct_id());%>, <%out.print(product.getPrice());%>,'<%out.print(st);%>')"
						name="<%out.print(product.getPrice());%>">+</button>
					<input type="text" id="<%out.print("i"+product.getProduct_id());%>"
						value="<%out.println(ceo.getQuantity() + kg);%>"></input>
					<button class="minus-btn" type="button"
						onclick="minusFunction(<%out.print(product.getProduct_id());%>, <%out.print(product.getPrice());%>,'<%out.print(st);%>')"
						name="<%out.print(product.getPrice());%>">-</button>
					<br></br>
					<button class="buttonDelete" type="button"
						onclick="remove('<%out.print(product.getProduct_id());%>')">
						Delete Item</button>
				</div>

				<div class="total-price"
					id="<%out.print("t"+product.getProduct_id());%>">
					<%out.print(total + " €"); %>
				</div>

			</div>
			<%

  }
  %>
			<div class="total-order" id="total-order">Total:</div>
			<button class="btn-order" type="button" onclick="confirmOrder('<%out.print(myCookie.getValue());%>')">Confirm Order</button>
			<button class="btn-order" type="button"
				onclick="save('<%out.print(myCookie.getValue());%>')">Save
				Cart</button>
			<% 
  } else{%>

			<h1>Cart Empty!</h1>
			<% 
  } %>

		</div>

		<script type="text/javascript">
    	 var array = null;
    	 var changed=1;
    	 
    
    	   function plusFunction(product,price,array1) {
    		 if (this.array == null)
    			 this.array=array1;
    		 var quantity = document.getElementById("i"+product).value;
    		 document.getElementById("i"+product).value = (parseInt(quantity) + 1) + " kg";
    		 document.getElementById("t"+product).innerHTML = ((parseFloat(quantity) + 1) * parseFloat(price) / 100) + " €";	
    		 changed=0;
    		 total(array);
    	   } 
    	   
    	   function minusFunction(product,price,array1) {
    			 if (this.array == null)
        			 this.array=array1;
    		 var quantity = document.getElementById("i"+product).value;
    		 var quantityInt = quantity.replace(" kg", "");
    		 if (parseInt(quantityInt) > 0){
      		 document.getElementById("i"+product).value = parseInt(quantity) - 1 + " kg";;
      		 document.getElementById("t"+product).innerHTML = ((parseFloat(quantity) - 1) * parseFloat(price) / 100) + " €";
      		 changed=0;
      		 total(this.array);}
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
    	   
    	   function remove(id) {
    		   var total    = (document.getElementById("total-order").innerHTML);
    		   total = total.replace("Total ", "");
    		   total = total.replace("<b>","");
    		   total = total.replace("</b>","");
    		   total = total.replace("€","");
    		   total = total.replace(" ","");
    		   total = parseFloat(total);
    		   changed=0;
    		   var toRemove = parseFloat(document.getElementById("t"+id).innerHTML);
    		   var test = "";
    		  for(var i = array.length - 1; i >= 0; i--) {
    		     if(array[i] !== id) {
    	     		test = test + array[i];
    		   }}
    		    this.array = test;
     		   document.getElementById("total-order").innerHTML = "<b>Total " + (total - toRemove) + "  €</b>";
    		   document.getElementById(id).remove();
     	   } 
    	   
    	   function save(cartId) {
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
    		    window.location = ("saveCart.jsp?cart_id="+cartId+"&order=false");
    	   }
    	   
    	   
    	   function confirmOrder(cartId) {
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
       		    if (changed == 1){
       		    	window.location = ("doOrder.jsp?cart_id="+cartId);}
       		    else{
       		    	window.location = ("saveCart.jsp?cart_id="+cartId+"&order=true");}
    		   
   	   }
    	 
    	   
    </script>
	</div>
	<div id="id05" class="modal">
		<form class="modal-content animate">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id05').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label><b> <%out.print(request.getParameter("message")); %>
				</b></label>
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('id05').style.display='none'"
					class="cancelbtn">Close</button>
			</div>
		</form>
	</div>

	<c:if test="${not empty param.message}">
		<script>
    		document.getElementById('id05').style.display='block'
	</script>
	</c:if>


	<c:import url="include/footer.inc.jsp" />

</body>
</html>