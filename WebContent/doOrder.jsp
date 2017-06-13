<%@page import="interfaces.OrderIntProxy"%>
<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.CartEntryObject"%>
<%@page import="interfaces.CartIntProxy"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%  
 
 
  
   if (!(boolean)session.getAttribute("logged")){
	   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/cart.jsp?message=You are not logged in!"));
   }
   else{
	   int customer_id   = (int)session.getAttribute("customer_id");   
	   int cart_id       =  Integer.parseInt((String)(session.getAttribute("cart_id")));
	   String card        = request.getParameter("card");
	   OrderIntProxy oip = new OrderIntProxy();
	   oip.addOrder(Integer.parseInt(oip.getGUUID()), cart_id, customer_id, Integer.parseInt(card));
	   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/order.jsp"));  

   }
	 
 %>