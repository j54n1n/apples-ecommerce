<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.CartEntryObject"%>
<%@page import="interfaces.CartIntProxy"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%  
   String cart_id = request.getParameter("cart_id");
   boolean order = Boolean.parseBoolean(request.getParameter("order"));
   CartIntProxy cip = new CartIntProxy();
   CartEntryObject[] ceos = cip.getCartContent(Integer.parseInt(cart_id));
  
   Cookie[] cookies = request.getCookies();
   Cookie myCookie = null;
   if (cookies != null) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("products")) {
         myCookie = cookie;
       }
     }
   }
   
   if (myCookie == null)
       response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp"));

   
   else{
	   String products = myCookie.getValue();
	   if (products.length() > 0){
	   String[] productsArray = products.split("\\.");
	   for (String product : productsArray){
		   int product_id = Integer.parseInt(product.split(",")[0]);
		   int quantity   =  Integer.parseInt(product.split(",")[1].replace("kg", "").replace(" ", ""));
		   cip.updateCart(Integer.parseInt(cart_id), product_id, quantity); 		   
		   for (int i = 0; i < ceos.length; i++){
			   if (ceos[i] != null){
			   if (ceos[i].getProduct_id() == product_id)
				   ceos[i] = null;
			   }
		   }
	   }
	   }
   
	   for (int i = 0; i < ceos.length; i++){
		   if (ceos[i] != null)
			   cip.updateCart(Integer.parseInt(cart_id), ceos[i].getProduct_id(), 0);
	   }
	   myCookie.setMaxAge(0);
	   myCookie.setValue("");
	   response.addCookie(myCookie);
	   if (!order)
	      response.sendRedirect(String.format("%s%s", request.getContextPath(), "/cart.jsp"));
	   else
		  response.sendRedirect(String.format("%s%s", request.getContextPath(), "/doOrder.jsp?cart_id="+cart_id));

   
   }

 
 
 %>