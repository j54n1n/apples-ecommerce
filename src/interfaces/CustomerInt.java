package interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import Serializables.CustomerObject;
import db.Customer;

@WebService
public interface CustomerInt {
	@WebMethod
	public CustomerObject modify(String salutation, String name,
			String surname, String country, String province,
			String city, String street,	String streetNo, String zip, String email, String pwd);
	
	@WebMethod
	public CustomerObject create(String salutation, String name,
			String surename, String country, String province,
			String city, String street,	String streetNo, String zip, int customer_id,
			String email, String pwd
			);
	
	@WebMethod
	public boolean delete();
	
	@WebMethod
	public CustomerObject find(int id);
	
	
	
	
	
	
}
