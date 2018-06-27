/**
 * DgieWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.j4guanatos.banxico.stub.ws;

public class DgieWSLocator extends org.apache.axis.client.Service implements DgieWS {

    public DgieWSLocator() {
    }


    public DgieWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DgieWSLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DgieWSPort
    private String DgieWSPort_address = "http://www.banxico.org.mx/DgieWSWeb/DgieWS";

    public String getDgieWSPortAddress() {
        return DgieWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String DgieWSPortWSDDServiceName = "DgieWSPort";

    public String getDgieWSPortWSDDServiceName() {
        return DgieWSPortWSDDServiceName;
    }

    public void setDgieWSPortWSDDServiceName(String name) {
        DgieWSPortWSDDServiceName = name;
    }

    public DgieWSPort_PortType getDgieWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DgieWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDgieWSPort(endpoint);
    }

    public DgieWSPort_PortType getDgieWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DgieWSPortSoapBindingStub _stub = new DgieWSPortSoapBindingStub(portAddress, this);
            _stub.setPortName(getDgieWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDgieWSPortEndpointAddress(String address) {
        DgieWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DgieWSPort_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                DgieWSPortSoapBindingStub _stub = new DgieWSPortSoapBindingStub(new java.net.URL(DgieWSPort_address), this);
                _stub.setPortName(getDgieWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("DgieWSPort".equals(inputPortName)) {
            return getDgieWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.dgie.banxico.org.mx", "DgieWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.dgie.banxico.org.mx", "DgieWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("DgieWSPort".equals(portName)) {
            setDgieWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
