
package com.robilife.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PersonneService", targetNamespace = "http://service.robilife.com/", wsdlLocation = "http://localhost:48130/TpWebService/PersonneService?WSDL")
public class PersonneService_Service
    extends Service
{

    private final static URL PERSONNESERVICE_WSDL_LOCATION;
    private final static WebServiceException PERSONNESERVICE_EXCEPTION;
    private final static QName PERSONNESERVICE_QNAME = new QName("http://service.robilife.com/", "PersonneService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:48130/TpWebService/PersonneService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PERSONNESERVICE_WSDL_LOCATION = url;
        PERSONNESERVICE_EXCEPTION = e;
    }

    public PersonneService_Service() {
        super(__getWsdlLocation(), PERSONNESERVICE_QNAME);
    }

    public PersonneService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), PERSONNESERVICE_QNAME, features);
    }

    public PersonneService_Service(URL wsdlLocation) {
        super(wsdlLocation, PERSONNESERVICE_QNAME);
    }

    public PersonneService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PERSONNESERVICE_QNAME, features);
    }

    public PersonneService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PersonneService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PersonneService
     */
    @WebEndpoint(name = "PersonneServicePort")
    public PersonneService getPersonneServicePort() {
        return super.getPort(new QName("http://service.robilife.com/", "PersonneServicePort"), PersonneService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PersonneService
     */
    @WebEndpoint(name = "PersonneServicePort")
    public PersonneService getPersonneServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.robilife.com/", "PersonneServicePort"), PersonneService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PERSONNESERVICE_EXCEPTION!= null) {
            throw PERSONNESERVICE_EXCEPTION;
        }
        return PERSONNESERVICE_WSDL_LOCATION;
    }

}
