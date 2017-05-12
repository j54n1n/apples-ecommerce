package db;

public class CustomerIntProxy implements db.CustomerInt {
  private String _endpoint = null;
  private db.CustomerInt customerInt = null;
  
  public CustomerIntProxy() {
    _initCustomerIntProxy();
  }
  
  public CustomerIntProxy(String endpoint) {
    _endpoint = endpoint;
    _initCustomerIntProxy();
  }
  
  private void _initCustomerIntProxy() {
    try {
      customerInt = (new db.CustomerServiceLocator()).getCustomerPort();
      if (customerInt != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)customerInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)customerInt)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (customerInt != null)
      ((javax.xml.rpc.Stub)customerInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public db.CustomerInt getCustomerInt() {
    if (customerInt == null)
      _initCustomerIntProxy();
    return customerInt;
  }
  
  public db.CustomerObject find(int arg0) throws java.rmi.RemoteException{
    if (customerInt == null)
      _initCustomerIntProxy();
    return customerInt.find(arg0);
  }
  
  public boolean delete() throws java.rmi.RemoteException{
    if (customerInt == null)
      _initCustomerIntProxy();
    return customerInt.delete();
  }
  
  public boolean login(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (customerInt == null)
      _initCustomerIntProxy();
    return customerInt.login(arg0, arg1);
  }
  
  public db.CustomerObject create(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7, java.lang.String arg8, int arg9, java.lang.String arg10, java.lang.String arg11) throws java.rmi.RemoteException{
    if (customerInt == null)
      _initCustomerIntProxy();
    return customerInt.create(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
  }
  
  public db.CustomerObject modify(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7, java.lang.String arg8, java.lang.String arg9, java.lang.String arg10) throws java.rmi.RemoteException{
    if (customerInt == null)
      _initCustomerIntProxy();
    return customerInt.modify(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }
  
  
}