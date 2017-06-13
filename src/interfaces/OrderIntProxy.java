package interfaces;

public class OrderIntProxy implements interfaces.OrderInt {
  private String _endpoint = null;
  private interfaces.OrderInt orderInt = null;
  
  public OrderIntProxy() {
    _initOrderIntProxy();
  }
  
  public OrderIntProxy(String endpoint) {
    _endpoint = endpoint;
    _initOrderIntProxy();
  }
  
  private void _initOrderIntProxy() {
    try {
      orderInt = (new db.OrderServiceLocator()).getOrderPort();
      if (orderInt != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)orderInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)orderInt)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (orderInt != null)
      ((javax.xml.rpc.Stub)orderInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public interfaces.OrderInt getOrderInt() {
    if (orderInt == null)
      _initOrderIntProxy();
    return orderInt;
  }
  
  public boolean deleteOrder(int arg0) throws java.rmi.RemoteException{
    if (orderInt == null)
      _initOrderIntProxy();
    return orderInt.deleteOrder(arg0);
  }
  
  public java.lang.String getGUUID() throws java.rmi.RemoteException{
    if (orderInt == null)
      _initOrderIntProxy();
    return orderInt.getGUUID();
  }
  
  public interfaces.OrderObject[] getOrders(int arg0) throws java.rmi.RemoteException{
    if (orderInt == null)
      _initOrderIntProxy();
    return orderInt.getOrders(arg0);
  }
  
  public boolean changeOrderStatus(int arg0, int arg1) throws java.rmi.RemoteException{
    if (orderInt == null)
      _initOrderIntProxy();
    return orderInt.changeOrderStatus(arg0, arg1);
  }
  
  public boolean addOrder(int arg0, int arg1, int arg2, int arg3) throws java.rmi.RemoteException{
    if (orderInt == null)
      _initOrderIntProxy();
    return orderInt.addOrder(arg0, arg1, arg2, arg3);
  }
  
  
}