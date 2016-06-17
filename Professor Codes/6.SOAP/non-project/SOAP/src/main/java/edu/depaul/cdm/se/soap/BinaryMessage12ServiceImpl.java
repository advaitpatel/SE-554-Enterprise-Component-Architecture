package edu.depaul.cdm.se.soap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

/**
 * MTOM enabled for files larger than 10k
 */
@MTOM(enabled = true, threshold = 10240)
@WebService(serviceName = "BinaryMessage12Service",
endpointInterface = "edu.depaul.cdm.se.soap.BinaryMessage12Service")
@BindingType(value = SOAPBinding.SOAP12HTTP_MTOM_BINDING)
//"http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")

public class BinaryMessage12ServiceImpl {
    public byte[] get(String fileName) {
        try {
             Path path = Paths.get("\\tmp\\" + fileName);
                return Files.readAllBytes(path);
        } catch (IOException ex) {
            Logger.getLogger(BinaryMessage12ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        }
    }
}
