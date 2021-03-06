package interfaces;

public class LoginServiceIntProxy implements interfaces.LoginServiceInt {
  private String _endpoint = null;
  private interfaces.LoginServiceInt loginServiceInt = null;
  
  public LoginServiceIntProxy() {
    _initLoginServiceIntProxy();
  }
  
  public LoginServiceIntProxy(String endpoint) {
    _endpoint = endpoint;
    _initLoginServiceIntProxy();
  }
  
  private void _initLoginServiceIntProxy() {
    try {
      loginServiceInt = (new db.LoginServiceServiceLocator()).getLoginServicePort();
      if (loginServiceInt != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)loginServiceInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)loginServiceInt)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (loginServiceInt != null)
      ((javax.xml.rpc.Stub)loginServiceInt)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public interfaces.LoginServiceInt getLoginServiceInt() {
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt;
  }
  
  public boolean createNewUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7) throws java.rmi.RemoteException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.createNewUser(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public int login(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.login(arg0, arg1);
  }
  
  public boolean insertNewToken(int arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.insertNewToken(arg0, arg1);
  }
  
  public java.lang.String getPublicKey() throws java.rmi.RemoteException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.getPublicKey();
  }
  
  public int loginCookie(java.lang.String arg0) throws java.rmi.RemoteException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.loginCookie(arg0);
  }
  
  public boolean updateToken(int arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.updateToken(arg0, arg1);
  }
  
  public java.lang.String getPublicKeyFromEmail(java.lang.String arg0) throws java.rmi.RemoteException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.getPublicKeyFromEmail(arg0);
  }
  
  public java.lang.String getCookieToken() throws java.rmi.RemoteException, interfaces.SQLException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.getCookieToken();
  }
  
  public boolean logout(java.lang.String arg0) throws java.rmi.RemoteException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.logout(arg0);
  }
  
  public java.lang.String updateCookieToken(int arg0, java.lang.String arg1) throws java.rmi.RemoteException, interfaces.SQLException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.updateCookieToken(arg0, arg1);
  }
  
  public java.lang.String getError() throws java.rmi.RemoteException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.getError();
  }
  
  public int getCustomerIdFromToken(java.lang.String arg0) throws java.rmi.RemoteException, interfaces.SQLException{
    if (loginServiceInt == null)
      _initLoginServiceIntProxy();
    return loginServiceInt.getCustomerIdFromToken(arg0);
  }
  
  
}