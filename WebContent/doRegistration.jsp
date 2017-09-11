<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.CardIntProxy"%>
<%@page import="interfaces.LoginServiceIntProxy"%>
<%@page import="interfaces.CustomerObject"%>
<%@page import="interfaces.CardObject"%>
<%@page import="interfaces.CustomerIntProxy"%>
<%@page import="interfaces.OrderIntProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <%
   
   String name = request.getParameter("name");
   String surname = request.getParameter("surname");
   String email = request.getParameter("email");
   long phonesignup = Long.parseLong(request.getParameter("phonesignup"));
   String organization = request.getParameter("organization");
   String address = request.getParameter("address");
   String city = request.getParameter("city");
   String zipCode = request.getParameter("zipCode");
   String deliverymethod = request.getParameter("deliverymethod");
   String owner = request.getParameter("owner");
   String cvv = request.getParameter("cvv");
   String password = request.getParameter("password");
   String cardNumber = request.getParameter("cardNumber");
   String month = request.getParameter("month");
   String year = request.getParameter("year");
   CustomerIntProxy ccip = new CustomerIntProxy();
   OrderIntProxy oip = new OrderIntProxy();
   LoginServiceIntProxy lsi = new LoginServiceIntProxy();
   CardIntProxy cip = new CardIntProxy();
   
   String publicK = lsi.getPublicKey();
   KeyHelper kh = new KeyHelper(publicK);
   CardObject co = new CardObject(email,Integer.parseInt(month),Integer.parseInt(year),"0",kh.encryptString(cardNumber),kh.encryptString(cvv),name + " " +surname, Integer.parseInt(cardNumber.subSequence(12, 16).toString()));
   cip.addCard(co);
   boolean ct = lsi.createNewUser(name, surname, email, (int)phonesignup, organization, city, address, zipCode);
   int id = ccip.findByEmail(email);
   
   Cookie[] cookies = request.getCookies();
   Cookie myCookie = null;
   if (cookies != null) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("cart")) {
         myCookie = cookie;
       }
     }
   }
   int cartId = Integer.parseInt(myCookie.getValue());
   oip.addOrder(Integer.parseInt(oip.getGUUID()), cartId, id, Integer.parseInt(cardNumber.subSequence(12, 16).toString()));
  
   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp?message=Order sent!"));
   	   		

  %>
 
  
