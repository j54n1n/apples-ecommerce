<%@page import="interfaces.CustomerInt"%>
<%@page import="interfaces.CustomerIntProxy"%>
<%@page import="interfaces.CustomerObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="logo" style="width: 100px; height: 118px; "><img src="https://preview.ibb.co/geOCLk/18555206_10155315010508236_977846558_n.png" style="height: 105px; width="200" height="40" "/></div>

<div id="top"><ul>
  <li><a href="<% out.print(request.getContextPath() + "/index.jsp"); %>">Home</a></li>
  <li><a href="#news">News</a></li>
  <li><a href="<% out.print(request.getContextPath() + "/cart.jsp"); %>">Your Cart</a></li>
</ul>
</div>

<!-- 
  <li style="float:right"><a class="active" href="#" onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Sign Up!</a></li>
  <div id="id02" class="modal">
   <form class="modal-content animate" action="/apples-ecommerce/doRegistration.jsp">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Suedtirolerapfel.svg/1200px-Suedtirolerapfel.svg.png" alt="Avatar" class="avatar">
    </div>
    <div class="container">
    <label><b>Salutation</b></label>
      <select id="salutation" name="salutation">
  <option value="Mr">Mr.</option>
  <option value="Mrs">Mrs.</option>
  <option value="Miss">Miss.</option>
     </select>
      <br><label><b>Name</b></label></br>
      <input type="text" placeholder="Enter Name" name="name" required>
      <label><b>Surname</b></label>
      <input type="text" placeholder="Enter Surname" name="sname" required>
      <label><b>Street</b></label>
      <input type="text" placeholder="Enter Street" name="street" required>
      <label><b>City</b></label>
      <input type="text" placeholder="Enter City" name="city" required>
       <label><b>Province</b></label>
      <input type="text" placeholder="Enter Province" name="province" required>
      <label><b>Zip</b></label>
      <input type="text" placeholder="Enter zip" name="zip" required>
      <label><b>Country</b></label>
      <input type="text" placeholder="Enter Country" name="country" required>
      <label><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email" required>
      <label><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
      <label><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" required>
      <button type="submit" id="btnSubmit" name="btnSubmit">Sign Up</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button"  id="btnSubmit" name="btnSubmit" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>
</ul>
</div>
-->

<div class="clear"></div>