<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.CartEntryObject"%>
<%@page import="interfaces.CartIntProxy"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%  
   if (!(boolean)session.getAttribute("logged"))
	   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/cart.jsp?message=You are not logged in!"));
   else
	   
 
 
 %>