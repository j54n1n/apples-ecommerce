package interfaces;

public class CartIntProxy implements interfaces.CartInt {
  private String _endpoint = null;
  private interfaces.CartInt cartInt = null;
  
  public CartIntProxy() {
    _initCartIntProxy();
  }
  
  public CartIntProxy(String endpoint) {
    _endpoint = endpoint;
    _initCartIntProxy();
  }
  
  private void _initCartIntProxy() {
    try {
      cartInt = (new db.CartServiceLocator()).getCartPort();
      if (cartInt != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cartInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cartInt)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cartInt != null)
      ((javax.xml.rpc.Stub)cartInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public interfaces.CartInt getCartInt() {
    if (cartInt == null)
      _initCartIntProxy();
    return cartInt;
  }
  
  public interfaces.CartEntryObject[] getCartContent(int arg0) throws java.rmi.RemoteException{
    if (cartInt == null)
      _initCartIntProxy();
    return cartInt.getCartContent(arg0);
  }
  
  public void minusOne(int arg0, int arg1) throws java.rmi.RemoteException{
    if (cartInt == null)
      _initCartIntProxy();
    cartInt.minusOne(arg0, arg1);
  }
  
  public java.lang.String getGUUID() throws java.rmi.RemoteException{
    if (cartInt == null)
      _initCartIntProxy();
    return cartInt.getGUUID();
  }
  
  public boolean addCartEntry(interfaces.CartEntryObject arg0) throws java.rmi.RemoteException{
    if (cartInt == null)
      _initCartIntProxy();
    return cartInt.addCartEntry(arg0);
  }
  
  public void addOne(int arg0, int arg1) throws java.rmi.RemoteException{
    if (cartInt == null)
      _initCartIntProxy();
    cartInt.addOne(arg0, arg1);
  }
  
  
}