/**
 * DgieWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.j4guanatos.banxico.stub.ws;

public interface DgieWS extends javax.xml.rpc.Service {
    public String getDgieWSPortAddress();

    public DgieWSPort_PortType getDgieWSPort() throws javax.xml.rpc.ServiceException;

    public DgieWSPort_PortType getDgieWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
