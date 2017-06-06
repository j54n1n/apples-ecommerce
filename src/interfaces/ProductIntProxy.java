package interfaces;

public class ProductIntProxy implements interfaces.ProductInt {
  private String _endpoint = null;
  private interfaces.ProductInt productInt = null;
  
  public ProductIntProxy() {
    _initProductIntProxy();
  }
  
  public ProductIntProxy(String endpoint) {
    _endpoint = endpoint;
    _initProductIntProxy();
  }
  
  private void _initProductIntProxy() {
    try {
      productInt = (new db.ProductServiceLocator()).getProductPort();
      if (productInt != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)productInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)productInt)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (productInt != null)
      ((javax.xml.rpc.Stub)productInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public interfaces.ProductInt getProductInt() {
    if (productInt == null)
      _initProductIntProxy();
    return productInt;
  }
  
  public interfaces.ProductObject findProduct(int arg0) throws java.rmi.RemoteException{
    if (productInt == null)
      _initProductIntProxy();
    return productInt.findProduct(arg0);
  }
  
  
}