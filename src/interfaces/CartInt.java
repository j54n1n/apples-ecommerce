/**
 * CartInt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package interfaces;

public interface CartInt extends java.rmi.Remote {
    public interfaces.CartEntryObject[] getCartContent(int arg0) throws java.rmi.RemoteException;
    public java.lang.String getGUUID() throws java.rmi.RemoteException;
    public boolean updateCart(int arg0, int arg1, int arg2) throws java.rmi.RemoteException;
    public boolean addCartEntry(interfaces.CartEntryObject arg0) throws java.rmi.RemoteException;
}
