/**
 * OrderService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package db;

public interface OrderService extends javax.xml.rpc.Service {
    public java.lang.String getOrderPortAddress();

    public interfaces.OrderInt getOrderPort() throws javax.xml.rpc.ServiceException;

    public interfaces.OrderInt getOrderPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
