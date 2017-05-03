package NET.webserviceX.www;

public class AccelerationUnitSoapProxy implements NET.webserviceX.www.AccelerationUnitSoap {
  private String _endpoint = null;
  private NET.webserviceX.www.AccelerationUnitSoap accelerationUnitSoap = null;
  
  public AccelerationUnitSoapProxy() {
    _initAccelerationUnitSoapProxy();
  }
  
  public AccelerationUnitSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccelerationUnitSoapProxy();
  }
  
  private void _initAccelerationUnitSoapProxy() {
    try {
      accelerationUnitSoap = (new NET.webserviceX.www.AccelerationUnitLocator()).getAccelerationUnitSoap();
      if (accelerationUnitSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)accelerationUnitSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)accelerationUnitSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (accelerationUnitSoap != null)
      ((javax.xml.rpc.Stub)accelerationUnitSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public NET.webserviceX.www.AccelerationUnitSoap getAccelerationUnitSoap() {
    if (accelerationUnitSoap == null)
      _initAccelerationUnitSoapProxy();
    return accelerationUnitSoap;
  }
  
  public double changeAccelerationUnit(double accelerationValue, NET.webserviceX.www.Accelerations fromAccelerationUnit, NET.webserviceX.www.Accelerations toAccelerationUnit) throws java.rmi.RemoteException{
    if (accelerationUnitSoap == null)
      _initAccelerationUnitSoapProxy();
    return accelerationUnitSoap.changeAccelerationUnit(accelerationValue, fromAccelerationUnit, toAccelerationUnit);
  }
  
  
}