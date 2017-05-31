<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.LoginServiceIntProxy"%>
<%@page import="interfaces.CustomerObject"%>
<%@page import="interfaces.CustomerIntProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <%  
  Cookie[] cookies = request.getCookies();
  Cookie myCookie = null;
  if (cookies != null) {
   for (Cookie cookie : cookies) {
     if (cookie.getName().equals("token")) {
        myCookie = cookie;
      }
     else
  	   myCookie = null;
    }
  }
  
  
   String email =   (String)session.getAttribute("email");
   session.setAttribute("logged", false);
   session.setAttribute("customer_id", null);
   session.setAttribute("email",null);
   LoginServiceIntProxy lsip = new LoginServiceIntProxy();
   lsip.logout(myCookie.getValue());
   myCookie.setMaxAge(0);
   myCookie.setValue("");
   response.addCookie(myCookie);
   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp?message=You logged out succesfully"));  
 
   %>
  
  
