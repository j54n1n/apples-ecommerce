<%@page import="helpers.KeyHelper"%>
<%@page import="interfaces.LoginServiceIntProxy"%>
<%@page import="interfaces.CustomerObject"%>
<%@page import="interfaces.CustomerIntProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <%  
   String email = request.getParameter("uname");
   String pwd = request.getParameter("psw");
   LoginServiceIntProxy lsi = new LoginServiceIntProxy();
   String publicKey = lsi.getPublicKeyFromEmail(email);
   KeyHelper kh = new KeyHelper(publicKey);
   pwd = kh.encryptString(pwd);
   int result =  lsi.login(email, pwd);
   if (result <= 0){
       session.setAttribute("logged", false);
	   response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp?message=Your login credentials are incorrect"));
   }
	  
   else{
	   // Workaround: Reread new keys.
	   pwd = request.getParameter("psw");
	   publicKey = lsi.getPublicKeyFromEmail(email);
	   kh = new KeyHelper(publicKey);
	   pwd = kh.encryptString(pwd);
	   //
	   String token = lsi.getCookieToken();
	   Cookie cookie = new Cookie("token", token);
	   cookie.setMaxAge(3600 * 24* 30);
	   cookie.setPath("/");
	   lsi.insertNewToken(result, token);
       session.setAttribute("customer_id", result);
       CustomerIntProxy cip = new CustomerIntProxy();
       session.setAttribute("logged", true);
       session.setAttribute("email",cip.find(result, pwd).getEmail());
	   response.addCookie(cookie);
       response.sendRedirect(String.format("%s%s", request.getContextPath(), "/index.jsp?message=You logged in succesfully"));
   }
     
  %>
 
  
