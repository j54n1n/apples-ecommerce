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
  CartIntProxy cip = new CartIntProxy();
  CartEntryObject[] ceos = cip.getCartContent(1);
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
        <div class="quantity">
          <button class="plus-btn" type="button"  id="<%out.print(product.getProduct_id());%>" name="<%out.print(product.getPrice());%>">+ </button>
          <input type="text"  value="<%out.println(ceo.getQuantity() + kg);%>"></input>
           <button class="minus-btn" type="button" id="<%out.print(product.getProduct_id());%>" name="<%out.print(product.getPrice());%>">- </button>
        </div>

        <div class="total-price" id="test"><%out.print(total + " €"); %></div>
      </div>
<%

  } %>
  
  </div>

    <script type="text/javascript">
      $('.minus-btn').on('click', function(e) {
    		e.preventDefault();
    		var $this = $(this);
    		var $input = $this.closest('div').find('input');
 	
    		var value = parseInt($input.val());

    		if (value > 1) {
    			value = value - 1;
    		} else {
    			value = 0;
    		}
    		
   
    
    		document.getElementById("test").innerHTML = String(e.name) + "" + "e";
    		
        $input.val(value + " kg");
        

    	});

    	$('.plus-btn').on('click', function(e) {
    		 e = e || window.event;
    		    e = e.target || e.srcElement;
    		    if (e.nodeName === 'BUTTON') {
    		  
    		    }
    	
    		e.preventDefault();
    		var $this = $(this);
    		var $input = $this.closest('div').find('input');
    		var value = parseInt($input.val());
    		if (value < 100) {
      		value = value + 1;
    		} else {
    			value =100;
    		}
    		 document.getElementById("test").innerHTML = String(e.name) + "" + "e";
    		$input.val(value + " kg");
    		 document.getElementById("test").innerHTML = e.id + "" + "e";
    	});


    </script>
</div>
<c:import url="include/footer.inc.jsp"/>

</body>
</html>