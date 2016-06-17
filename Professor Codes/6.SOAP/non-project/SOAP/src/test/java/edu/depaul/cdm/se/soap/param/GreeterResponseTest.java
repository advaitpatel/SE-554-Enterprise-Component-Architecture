package edu.depaul.cdm.se.soap.param;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.junit.Test;
import static org.junit.Assert.*;

public class GreeterResponseTest {
    @Test
    public void testGreeterResponseInXml() throws JAXBException {
        GreeterResponse c = new GreeterResponse("Dave");

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(GreeterResponse.class);
        Marshaller m = context.createMarshaller();
        m.marshal(c, writer);

        String xml = writer.toString();
        String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><greetResponse message=\"Hello, \" name=\"Dave\"><greeting>Hello, Dave</greeting></greetResponse>";
        assertEquals(expectedXml, xml);
    }
}
