/**
 * CartService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package db;

public interface CartService extends javax.xml.rpc.Service {
    public java.lang.String getCartPortAddress();

    public interfaces.CartInt getCartPort() throws javax.xml.rpc.ServiceException;

    public interfaces.CartInt getCartPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
