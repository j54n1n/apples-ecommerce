<%@page import="interfaces.ProductIntProxy"%>
<%@page import="interfaces.ProductObject"%>
<%@page import="interfaces.CartEntryObject"%>
<%@page import="interfaces.CartIntProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" rev="stylesheet" type="text/css" href="css/style.css" media="screen" /> 
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>

<title>Apples e-commerce Cart</title>
</head>
<body>
<div id="page">

<c:import url="include/header.inc.jsp"/>
<c:import url="include/navigation.inc.jsp"/>
  <div class="shopping-cart">
  <!-- Product #1 -->
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
  
  
  
  if (myCookie != null){
  String st =  "";
  CartIntProxy cip = new CartIntProxy();
  CartEntryObject[] ceos = cip.getCartContent(Integer.parseInt(myCookie.getValue()));

  int c = 0;
  for (CartEntryObject ceo : ceos){
	  st += ceo.getProduct_id();
	c++;}
  for (CartEntryObject ceo : ceos){
  	ProductObject product = new ProductIntProxy().findProduct(ceo.getProduct_id());
  	double total = ((((double)product.getPrice())/100))*ceo.getQuantity();
  %>
      <div class="item">
        <div class="title">
          <span><%out.println(product.getTitle() ); %></span>
        </div>
        <div class="image">
          <img src=<%
          String kg = "";
          if (product.getCategory_id() == 1)
        	  kg = " kg";
          out.println(product.getImgLink()); 
          
          %> alt="" />
        </div>
        <div class="quantity" id="<%out.print(product.getProduct_id());%>">
          <button class="plus-btn" type="button"  onclick="plusFunction(<%out.print(product.getProduct_id());%>, <%out.print(product.getPrice());%>)" name="<%out.print(product.getPrice());%>">+ </button>
          <input type="text" id="<%out.print("i"+product.getProduct_id());%>"  value="<%out.println(ceo.getQuantity() + kg);%>"></input>
          <button class="minus-btn" type="button" onclick="minusFunction(<%out.print(product.getProduct_id());%>, <%out.print(product.getPrice());%>)" name="<%out.print(product.getPrice());%>">- </button>
          <br></br>
          <button class="buttonDelete" type="button" onclick="total('<%out.print(st);%>')"> Delete Item </button>
        </div>

        <div class="total-price" id="<%out.print("t"+product.getProduct_id());%>"><%out.print(total + " €"); %></div>
      </div>
<%

  }
  %>
  <script>total(<%out.print(st);%></script>
  <div class="total-price"> TOTAL: </div>
  <% 
  } else{%>
	  
	  <h1> Cart Empty! </h1>
	  <% 
  } %>
     
  </div>

    <script type="text/javascript">
    	   function plusFunction(product,price) {
    		 var quantity = document.getElementById("i"+product).value;
    		 document.getElementById("i"+product).value = (parseInt(quantity) + 1) + " kg";
    		 document.getElementById("t"+product).innerHTML = ((parseFloat(quantity) + 1) * parseFloat(price) / 100) + " €";		 
    	   } 
    	   
    	   function minusFunction(product,price) {
    		 var quantity = document.getElementById("i"+product).value;
      		 document.getElementById("i"+product).value = parseInt(quantity) - 1 + " kg";;
      		 document.getElementById("t"+product).innerHTML = ((parseFloat(quantity) - 1) * parseFloat(price) / 100) + " €";
   	   		}  
    	   
    	   function total(test) {
    		   alert(test[0]);
     	   }  
    </script>
    	
 
</div>
<c:import url="include/footer.inc.jsp"/>

</body>
</html>