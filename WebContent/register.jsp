<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="interfaces.OrderIntProxy"%>
<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.CartEntryObject"%>
<%@page import="interfaces.CartIntProxy"%>
<%@page import="interfaces.ProductIntProxy"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" rev="stylesheet" type="text/css"
	href="css/header.css" media="screen" />
	<link rel="stylesheet" rev="stylesheet" type="text/css"
	href="css/register.css" media="screen" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>

<title>AST - Registration</title>
</head>
<body>
	<div id="page">
	
			<% 		
					
	CartIntProxy cip = new CartIntProxy();
	String cart_id = (String) (request.getParameter("cart_id"));
	System.out.println(cart_id);
	CartEntryObject[] c = cip.getCartContent(Integer.parseInt(cart_id));
	for (CartEntryObject obj : c) {

		int quantity = obj.getQuantity();

		ProductIntProxy pip = new ProductIntProxy();

		if (quantity > pip.findProduct(obj.getProduct_id()).getQuantity()) {
			response.sendRedirect(
					String.format("%s%s", request.getContextPath(), "/cart.jsp?message=Quantity for product "
							+ pip.findProduct(obj.getProduct_id()).getTitle() + " not available in stock!"));

		}
	}
					
		%>		

		<c:import url="include/header.inc.jsp" />

		<c:import url="include/navigation.inc.jsp" />

		<div id="content">

			<c:choose>
				<c:when test="${!empty param.success && param.success == true}">

					<p class="msg">Registration successful!</p>

				</c:when>
				<c:otherwise>

					<c:out value="${param.success}"></c:out>
					

					
					
					

					<form action="doRegistration.jsp" method="POST">
						<label for="name">Name *: </label> <input type="text" value=""
							id="name" name="name" required="required" placeholder="Mario" />

						<label for="surname">Surname *: </label> <input type="text"
							value="" id="surname" name="surname" required="required"
							placeholder="Rossi" /><br />
							
							 <label for="email">Email*:
						</label> <input type="email" value="" id="email" name="email"
							required="required"
							placeholder="mario.rossi@gmail.com" /><br /> 
							
							
							
							
							
					<label for="phonesignup"> Phone *</label>
					<input id="phonesignup" name="phonesignup" required="required"
						type="tel" placeholder="3331234555" />

					<label for="organization"> Organization</label>
					<input id="organization" type="text" name="organization" placeholder="Unibz" />

					<label for="address"> Address *</label>
					<input id="address" name="address" required="required" type="text"
						placeholder="Via druso 45" />


					<label for="city"> City *</label>
					<input id="city" name="city" type="text" required="required"
						placeholder="Bolzano" />

					<Label for="zipCode"> ZIP Code * </Label>
					<input id="zipCode" name="zipCode" required="required" type="number"
						pattern="[0-9]{5}" placeholder="39100" />

					<label for="deliverymethod"> Delivery Method *</label>
					<select id="deliverymethod" name="deliverymethod" required="required">

						<option value="standard"> Standard </option>
						<option value="fast delivery"> Fast Delivery </option>
						<option value="fast tracked delivery"> Fast Tracked Delivery </option>
					</select>
							
							
							
							     <br></br><br></br>
							
							
							     <label><br>Credit Card Information </br></label>
     <label for="owner">Owner *</label>
     <input type="text" required="required" name="owner">
                <label for="cvv">CVV *</label>
                <input type="password" required="required" name="cvv"  id="cvv" pattern="[0-9]{3}" maxlength="3">
                <label for="cardNumber">Card Number *</label>
                <input type="text" required="required" name="cardNumber" pattern="[0-9]{16}" maxlength="16">
                <label>Expiration Date</label>
                <select name="month">
                    <option value="01">January</option>
                    <option value="02">February </option>
                    <option value="03">March</option>
                    <option value="04">April</option>
                    <option value="05">May</option>
                    <option value="06">June</option>
                    <option value="07">July</option>
                    <option value="08">August</option>
                    <option value="09">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select>
                <select name="year">
                    <option value="17"> 2017</option>
                    <option value="18"> 2018</option>
                    <option value="19"> 2019</option>
                    <option value="20"> 2020</option>
                    <option value="21"> 2021</option>
                </select>
                 <br></br>
                <img src="img/visa.jpg" id="visa">
                <img src="img/mastercard.jpg" id="mastercard">
                <img src="img/amex.jpg" id="amex">         
                 <br></br>   
                <button type="submit" class="btn btn-default" id="confirm-purchase">Confirm</button>
							
							
													
																									
					</form>


				</c:otherwise>
			</c:choose>

		</div>

		<c:import url="include/footer.inc.jsp" />

	</div>
</body>
</html>