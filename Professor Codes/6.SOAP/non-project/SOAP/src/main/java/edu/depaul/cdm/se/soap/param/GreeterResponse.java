package edu.depaul.cdm.se.soap.param;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "greetResponse" )
public class GreeterResponse extends GreeterRequest implements Serializable {
    @XmlAttribute
    private String message;
    @XmlElement
    private String greeting;

    public GreeterResponse() {
        this("anonymous");
    }
    
    public GreeterResponse(String name) {
        this("Hello, ", name);
    }
    
    public GreeterResponse(String message, String name) {
        super(name);
        this.message = message;
        this.greeting = message + name;
    }
}
