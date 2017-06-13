/**
 * OrderServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package db;

public class OrderServiceLocator extends org.apache.axis.client.Service implements db.OrderService {

    public OrderServiceLocator() {
    }


    public OrderServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OrderServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OrderPort
    private java.lang.String OrderPort_address = "http://54.202.224.165:8080/apples-ecommerce-ws/Order";

    public java.lang.String getOrderPortAddress() {
        return OrderPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OrderPortWSDDServiceName = "OrderPort";

    public java.lang.String getOrderPortWSDDServiceName() {
        return OrderPortWSDDServiceName;
    }

    public void setOrderPortWSDDServiceName(java.lang.String name) {
        OrderPortWSDDServiceName = name;
    }

    public interfaces.OrderInt getOrderPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OrderPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOrderPort(endpoint);
    }

    public interfaces.OrderInt getOrderPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            db.OrderServiceSoapBindingStub _stub = new db.OrderServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getOrderPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOrderPortEndpointAddress(java.lang.String address) {
        OrderPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (interfaces.OrderInt.class.isAssignableFrom(serviceEndpointInterface)) {
                db.OrderServiceSoapBindingStub _stub = new db.OrderServiceSoapBindingStub(new java.net.URL(OrderPort_address), this);
                _stub.setPortName(getOrderPortWSDDServiceName());
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
        if ("OrderPort".equals(inputPortName)) {
            return getOrderPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://db/", "OrderService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://db/", "OrderPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OrderPort".equals(portName)) {
            setOrderPortEndpointAddress(address);
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
