<%@page import="interfaces.CardIntProxy"%>
<%@page import="interfaces.CardObject"%>
<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.LoginServiceIntProxy"%>
<%@page import="interfaces.CustomerObject"%>
<%@page import="interfaces.CustomerIntProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <%  
   String cname = request.getParameter("owner");
   String ccv = request.getParameter("ccv");
   String number  = request.getParameter("cardNumber");
   String month = request.getParameter("month");
   String year = request.getParameter("year");
   int customer_id = (int)session.getAttribute("customer_id");
   CardIntProxy cip = new CardIntProxy();
   String pKey = cip.getPublicKey();
   KeyHelper kh = new KeyHelper(pKey);
   int test = number.length();
   String lastChars = number.substring(12);
   number = kh.encryptString(number);
   ccv = kh.encryptString(ccv);  
   CardObject co = new CardObject(customer_id,Integer.parseInt(month),Integer.parseInt(year),pKey,number,ccv,cname,Integer.parseInt(lastChars));
   cip.addCard(co);

   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/newCreditCard.jsp?message=Inserted succesfully"));
   %>