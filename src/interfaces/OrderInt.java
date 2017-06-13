/**
 * OrderInt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package interfaces;

public interface OrderInt extends java.rmi.Remote {
    public boolean deleteOrder(int arg0) throws java.rmi.RemoteException;
    public java.lang.String getGUUID() throws java.rmi.RemoteException;
    public interfaces.OrderObject[] getOrders(int arg0) throws java.rmi.RemoteException;
    public boolean changeOrderStatus(int arg0, int arg1) throws java.rmi.RemoteException;
    public boolean addOrder(int arg0, int arg1, int arg2, int arg3) throws java.rmi.RemoteException;
}
