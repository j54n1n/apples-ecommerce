/**
 * CartServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package db;

public class CartServiceLocator extends org.apache.axis.client.Service implements db.CartService {

    public CartServiceLocator() {
    }


    public CartServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CartServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CartPort
    private java.lang.String CartPort_address = "http://localhost:8080/apples-ecommerce-ws/Cart";

    public java.lang.String getCartPortAddress() {
        return CartPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CartPortWSDDServiceName = "CartPort";

    public java.lang.String getCartPortWSDDServiceName() {
        return CartPortWSDDServiceName;
    }

    public void setCartPortWSDDServiceName(java.lang.String name) {
        CartPortWSDDServiceName = name;
    }

    public interfaces.CartInt getCartPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CartPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCartPort(endpoint);
    }

    public interfaces.CartInt getCartPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            db.CartServiceSoapBindingStub _stub = new db.CartServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCartPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCartPortEndpointAddress(java.lang.String address) {
        CartPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (interfaces.CartInt.class.isAssignableFrom(serviceEndpointInterface)) {
                db.CartServiceSoapBindingStub _stub = new db.CartServiceSoapBindingStub(new java.net.URL(CartPort_address), this);
                _stub.setPortName(getCartPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CartPort".equals(inputPortName)) {
            return getCartPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://db/", "CartService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://db/", "CartPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CartPort".equals(portName)) {
            setCartPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}