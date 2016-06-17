package edu.depaul.cdm.se.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IGreeterService {
    @WebMethod
    String sayHi(String name);
}
