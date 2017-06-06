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
  <!-- Product #1 -->
  <%
  CartIntProxy cip = new CartIntProxy();
  CartEntryObject[] ceos = cip.getCartContent(1);
  for (CartEntryObject ceo : ceos){
  	ProductObject product = new ProductIntProxy().findProduct(ceo.getProduct_id());
  	double total = ((((double)product.getPrice())/100))*ceo.getQuantity();
  %>
   <div class="shopping-cart">
 
      <div class="item">
        <div class="buttons">
          <span class="delete-btn"></span>
        </div>

        <div class="image">
          <img src=<%out.println(product.getImgLink()); %> alt="" />
        </div>

        <div class="description">
          <span><%out.println(product.getTitle() ); %></span>
        </div>

        <div class="quantity">
          <button class="plus-btn" type="button" name="button">
            <img src="plus.svg" alt="" />
          </button>
          <h1><%out.println(ceo.getQuantity());%></h1>
          <button class="minus-btn" type="button" name="button">
            <img src="minus.svg" alt="" />
          </button>
        </div>

        <div class="total-price"><%out.println(total); %></div>
      </div>
</div>
<%

  } %>

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

        $input.val(value);

    	});

    	$('.plus-btn').on('click', function(e) {
    		e.preventDefault();
    		var $this = $(this);
    		var $input = $this.closest('div').find('input');
    		var value = parseInt($input.val());

    		if (value < 100) {
      		value = value + 1;
    		} else {
    			value =100;
    		}

    		$input.val(value);
    	});

      $('.like-btn').on('click', function() {
        $(this).toggleClass('is-active');
      });
    </script>
</div>
<c:import url="include/footer.inc.jsp"/>

</body>
</html>