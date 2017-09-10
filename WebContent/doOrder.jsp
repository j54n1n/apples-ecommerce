<%@page import="interfaces.OrderIntProxy"%>
<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.CartEntryObject"%>
<%@page import="interfaces.CartIntProxy"%>
<%@page import="interfaces.ProductIntProxy"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%  
 

 CartIntProxy cip = new CartIntProxy();
	   String cart_id       =  (String)(request.getParameter("cart_id"));	  
	   System.out.println(cart_id);
	   CartEntryObject[] c = cip.getCartContent(Integer.parseInt(cart_id));
	   for (CartEntryObject obj : c) {
		   
		   int quantity = obj.getQuantity();
		   
			ProductIntProxy pip = new ProductIntProxy();

		   if(quantity > pip.findProduct(obj.getProduct_id()).getQuantity()){
				response.sendRedirect(String.format("%s%s", request.getContextPath(), "/cart.jsp?message=Quantity for product "  +
		    	pip.findProduct(obj.getProduct_id()).getTitle() + " not available in stock!"));
			   
		   }

	   //OrderIntProxy oip = new OrderIntProxy();
	   //oip.addOrder(Integer.parseInt(oip.getGUUID()), cart_id, customer_id, Integer.parseInt(card));
	   //response.sendRedirect(String.format("%s%s", request.getContextPath(), "/order.jsp"));  

   }
	 
 %>