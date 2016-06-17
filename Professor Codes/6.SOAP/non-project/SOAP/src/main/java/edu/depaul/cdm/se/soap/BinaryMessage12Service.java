package edu.depaul.cdm.se.soap;

import java.awt.Image;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface BinaryMessage12Service {

    @WebMethod
    Image get(String fileName);
    
}
