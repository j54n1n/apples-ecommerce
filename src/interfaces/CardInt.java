/**
 * CardInt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package interfaces;

public interface CardInt extends java.rmi.Remote {
    public boolean addCard(interfaces.CardObject arg0) throws java.rmi.RemoteException;
    public interfaces.CardObject[] getCards(int arg0) throws java.rmi.RemoteException;
    public java.lang.String getPublicKey() throws java.rmi.RemoteException;
}
