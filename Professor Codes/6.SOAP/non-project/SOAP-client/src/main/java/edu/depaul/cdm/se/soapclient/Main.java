package edu.depaul.cdm.se.soapclient;

import edu.depaul.cdm.se.addressedgreetings.AddressedGreeterService;
import edu.depaul.cdm.se.addressedgreetings.AddressedGreeterService_Service;
import edu.depaul.cdm.se.soap.Greeter;
import edu.depaul.cdm.se.soap.GreeterService;
import javax.xml.ws.BindingProvider;

public class Main {
    public static void main(String[] args) {
        Main client = new Main();
//        client.doGreet();
        client.doAddressedGreet();
    }
    
    public void doGreet() {
        Greeter service = new GreeterService().getGreeterPort();
        // To change the endpoint rather than generated end point        
        // ((BindingProvider) service).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/Hello");
        System.out.println(service.hello("Dave"));
    }
    
    public void doAddressedGreet() {
        AddressedGreeterService service = new AddressedGreeterService_Service().getAddressedGreeterServicePort();
        System.out.println(service.hello("Dave"));
    }
}
