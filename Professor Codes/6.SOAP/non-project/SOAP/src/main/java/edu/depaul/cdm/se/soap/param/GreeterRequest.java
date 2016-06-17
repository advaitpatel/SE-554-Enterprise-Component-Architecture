package edu.depaul.cdm.se.soap.param;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "greetRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GreeterRequest implements Serializable {

    @XmlAttribute
    private String name;

    public GreeterRequest() {
        super();
    }

    public GreeterRequest(String name) {
        super();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
