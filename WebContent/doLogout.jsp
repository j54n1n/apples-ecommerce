<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.LoginServiceIntProxy"%>
<%@page import="interfaces.CustomerObject"%>
<%@page import="interfaces.CustomerIntProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <%  
   String email =   (String)session.getAttribute("email");
   session.setAttribute("logged", false);
   session.setAttribute("customer_id", null);
   session.setAttribute("email",null);
   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp?message=You logged out succesfully"));  
  %>
 
  
