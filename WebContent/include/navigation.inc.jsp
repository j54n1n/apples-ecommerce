<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="category" class="beans.NavigationBean" scope="session"></jsp:useBean>
<c:set var="categoryId" value="${param.cat_id}" />

<div id="nav">
 <ul>
  <c:forEach items="${category.allCategories}" var="item" varStatus="vs">
   <li>
    <c:choose>
	 <c:when test="${categoryId == item.id}">
	  <a class="active" href="overview.jsp?cat_id=${item.id}">${item.name}</a>
	 </c:when>
	 <c:otherwise>
	  <a href="overview.jsp?cat_id=${item.id}">${item.name}</a>
	 </c:otherwise>
	</c:choose>

	<c:choose>
	 <c:when test="${!empty item.children}">
	  <c:set var="recurse_message" value="${item}" scope="request"/>
	  <c:set var="catId" value="${categoryId}" scope="request"/>
	  <c:import url="include/recurse.jsp"/>
	  <c:remove var="recurse_message" scope="request"/>
	 </c:when>
	</c:choose>
   </li>
  </c:forEach>
 </ul>
</div>