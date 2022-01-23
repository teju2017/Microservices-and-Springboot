package com.tejas.generatedcode;

public class StudentDetailsPortProxy implements com.tejas.generatedcode.StudentDetailsPort {
  private String _endpoint = null;
  private com.tejas.generatedcode.StudentDetailsPort studentDetailsPort = null;
  
  public StudentDetailsPortProxy() {
    _initStudentDetailsPortProxy();
  }
  
  public StudentDetailsPortProxy(String endpoint) {
    _endpoint = endpoint;
    _initStudentDetailsPortProxy();
  }
  
  private void _initStudentDetailsPortProxy() {
    try {
      studentDetailsPort = (new com.tejas.generatedcode.StudentDetailsPortServiceLocator()).getStudentDetailsPortSoap11();
      if (studentDetailsPort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)studentDetailsPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)studentDetailsPort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (studentDetailsPort != null)
      ((javax.xml.rpc.Stub)studentDetailsPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.tejas.generatedcode.StudentDetailsPort getStudentDetailsPort() {
    if (studentDetailsPort == null)
      _initStudentDetailsPortProxy();
    return studentDetailsPort;
  }
  
  public com.tejas.generatedcode.StudentDetailsResponse studentDetails(com.tejas.generatedcode.StudentDetailsRequest studentDetailsRequest) throws java.rmi.RemoteException{
    if (studentDetailsPort == null)
      _initStudentDetailsPortProxy();
    return studentDetailsPort.studentDetails(studentDetailsRequest);
  }
  
  
}