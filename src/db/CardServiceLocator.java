/**
 * CardServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package db;

public class CardServiceLocator extends org.apache.axis.client.Service implements db.CardService {

    public CardServiceLocator() {
    }
        
 
    public CardServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CardServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CardPort
    private java.lang.String CardPort_address = "http://34.211.54.69:8081/apples-ecommerce-ws/Card";

    public java.lang.String getCardPortAddress() {
        return CardPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CardPortWSDDServiceName = "CardPort";

    public java.lang.String getCardPortWSDDServiceName() {
        return CardPortWSDDServiceName;
    }

    public void setCardPortWSDDServiceName(java.lang.String name) {
        CardPortWSDDServiceName = name;
    }

    public interfaces.CardInt getCardPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CardPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCardPort(endpoint);
    }

    public interfaces.CardInt getCardPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            db.CardServiceSoapBindingStub _stub = new db.CardServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCardPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCardPortEndpointAddress(java.lang.String address) {
        CardPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (interfaces.CardInt.class.isAssignableFrom(serviceEndpointInterface)) {
                db.CardServiceSoapBindingStub _stub = new db.CardServiceSoapBindingStub(new java.net.URL(CardPort_address), this);
                _stub.setPortName(getCardPortWSDDServiceName());
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
        if ("CardPort".equals(inputPortName)) {
            return getCardPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://db/", "CardService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://db/", "CardPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CardPort".equals(portName)) {
            setCardPortEndpointAddress(address);
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
