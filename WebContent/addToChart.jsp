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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%
	int product_id = Integer.parseInt(request.getParameter("product_id"));
	int quantity = Integer.parseInt(request.getParameter("quantity"));
	int category_id = Integer.parseInt(request.getParameter("category_id"));
	CartIntProxy cip = new CartIntProxy();
	ProductIntProxy pip = new ProductIntProxy();

	if (quantity > pip.findProduct(product_id).getQuantity()) {
		response.sendRedirect(
				String.format("%s%s", request.getContextPath(), "/ProductPage.jsp?productId="+product_id+"&message=Quantity for product "
						+ pip.findProduct(product_id).getTitle() + " not available in stock!"));

	}
	
	Cookie[] cookies = request.getCookies();
	Cookie myCookie = null;
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("cart")) {
				myCookie = cookie;
			}
		}
	}
	if (myCookie == null) {
		String cart_id = cip.getGUUID();
		myCookie = new Cookie("cart", cart_id);
		myCookie.setMaxAge(60 * 60 * 24 * 30);
		response.addCookie(myCookie);

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		System.out.println(quantity + "\n " + pip.findProduct(product_id).getQuantity() + "\n "
				+ pip.findProduct(product_id));
		if (quantity > pip.findProduct(product_id).getQuantity()) {
			response.sendRedirect(String.format("%s%s", request.getContextPath(),
					"/GridPage.jsp?category_id=" + category_id + "&message=Quantity not available in stock"));
		} else {
			cip.addCartEntry(new interfaces.CartEntryObject(Integer.parseInt(cart_id), product_id, quantity,
					reportDate));
			response.sendRedirect(String.format("%s%s", request.getContextPath(),
					"/cart.jsp"));

		}

	} else {

		String cart_id = myCookie.getValue();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		System.out.println(quantity + "\n " + pip.findProduct(product_id).getQuantity() + "\n "
				+ pip.findProduct(product_id));
		if (quantity > pip.findProduct(product_id).getQuantity()) {
			response.sendRedirect(String.format("%s%s", request.getContextPath(),
					"/GridPage.jsp?category_id=" + category_id + "&message=Quantity not available in stock"));
		} else {
			cip.addCartEntry(new interfaces.CartEntryObject(Integer.parseInt(cart_id), product_id, quantity,
					reportDate));
			response.sendRedirect(String.format("%s%s", request.getContextPath(),
					"/GridPage.jsp?category_id=" + category_id + "&message=Added to cart"));

		}

		//
	}
%>


