/**
 * ProductService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package db;

public interface ProductService extends javax.xml.rpc.Service {
    public java.lang.String getProductPortAddress();

    public interfaces.ProductInt getProductPort() throws javax.xml.rpc.ServiceException;

    public interfaces.ProductInt getProductPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
