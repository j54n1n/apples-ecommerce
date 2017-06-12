package interfaces;

public class CardIntProxy implements interfaces.CardInt {
  private String _endpoint = null;
  private interfaces.CardInt cardInt = null;
  
  public CardIntProxy() {
    _initCardIntProxy();
  }
  
  public CardIntProxy(String endpoint) {
    _endpoint = endpoint;
    _initCardIntProxy();
  }
  
  private void _initCardIntProxy() {
    try {
      cardInt = (new db.CardServiceLocator()).getCardPort();
      if (cardInt != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cardInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cardInt)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cardInt != null)
      ((javax.xml.rpc.Stub)cardInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public interfaces.CardInt getCardInt() {
    if (cardInt == null)
      _initCardIntProxy();
    return cardInt;
  }
  
  public boolean addCard(interfaces.CardObject arg0) throws java.rmi.RemoteException{
    if (cardInt == null)
      _initCardIntProxy();
    return cardInt.addCard(arg0);
  }
  
  public interfaces.CardObject[] getCards(int arg0) throws java.rmi.RemoteException{
    if (cardInt == null)
      _initCardIntProxy();
    return cardInt.getCards(arg0);
  }
  
  public java.lang.String getPublicKey() throws java.rmi.RemoteException{
    if (cardInt == null)
      _initCardIntProxy();
    return cardInt.getPublicKey();
  }
  
  
}