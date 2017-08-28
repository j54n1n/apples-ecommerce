/**
 * CardService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package db;

public interface CardService extends javax.xml.rpc.Service {
    public java.lang.String getCardPortAddress();

    public interfaces.CardInt getCardPort() throws javax.xml.rpc.ServiceException;
    //sss
    public interfaces.CardInt getCardPort(java.net.URL   portAddress) throws javax.xml.rpc.ServiceException;
}
