package edu.depaul.cdm.se.soap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;

/**
 * Example showing base64 encoding
 */
@WebService(serviceName = "BinaryMessage11Service",
endpointInterface = "edu.depaul.cdm.se.soap.BinaryMessage11Service")
public class BinaryMessage11ServiceImpl implements BinaryMessage11Service {

    @Override
    public byte[] get(String fileName) {
        try {
             Path path = Paths.get("\\tmp\\" + fileName);
                return Files.readAllBytes(path);
        } catch (IOException ex) {
            Logger.getLogger(BinaryMessage11ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebServiceException(ex);
        }
    }
    
}
