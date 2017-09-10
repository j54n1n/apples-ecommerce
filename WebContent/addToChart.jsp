<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.CartIntProxy"%>
<%@page import="interfaces.ProductIntProxy"%>

<%@page import="interfaces.CustomerObject"%>
<%@page import="interfaces.CustomerIntProxy"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%  
   int product_id = Integer.parseInt(request.getParameter("product_id"));
   int quantity = Integer.parseInt(request.getParameter("quantity"));
   int category_id = Integer.parseInt(request.getParameter("category_id"));
   CartIntProxy cip = new CartIntProxy();
 	
   ProductIntProxy pip = new ProductIntProxy();

   
   Cookie[] cookies = request.getCookies();
   Cookie myCookie = null;
   if (cookies != null) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("cart")) {
         myCookie = cookie;
       }
     }
   }
   if (myCookie == null){
	   String cart_id = cip.getGUUID();
	   myCookie = new Cookie("cart", cart_id);
	   myCookie.setMaxAge(60*60*24*30);
	   response.addCookie(myCookie);
	   
	   DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		if(quantity > pip.findProduct(product_id).getQuantity()) {
			   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/GridPage.jsp?category_id="+category_id+"&message=Quantity not available in stock"));
		}
		else {
	  		cip.addCartEntry(new interfaces.CartEntryObject(Integer.parseInt(cart_id), product_id,quantity,reportDate));
		}
	  
	   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/GridPage.jsp?category_id="+category_id+"&message=Added to cart"));
   }
   else{

	   String cart_id = myCookie.getValue();
	   DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);

	   cip.addCartEntry(new interfaces.CartEntryObject(Integer.parseInt(cart_id), product_id,quantity,reportDate));
	   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/GridPage.jsp?category_id="+category_id+"&message=Added to cart"));
	   //
   }     
  %>


