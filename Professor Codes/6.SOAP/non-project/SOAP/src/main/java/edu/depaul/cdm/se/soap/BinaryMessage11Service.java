package edu.depaul.cdm.se.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
public interface BinaryMessage11Service {

    @WebMethod
    byte[] get(String fileName);
    
}
