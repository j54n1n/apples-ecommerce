package Publisher;

import javax.xml.ws.Endpoint;

import db.Customer;

public class CustomerPublisher {

		public static void main(String[] args) {
			Endpoint.publish("http://localhost:1234/customerws", new Customer());
		}

	}
	

