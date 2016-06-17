package edu.depaul.se.xml;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test XML format
 */
public class CalculatorRequestTest {
    
    @Test
    public void testAdd() throws JAXBException {
        CalculatorRequest c = new CalculatorRequest(10, 10, CalculatorRequest.CalculatorOperation.ADD);

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(CalculatorRequest.class);
        Marshaller m = context.createMarshaller();
        m.marshal(c, writer);

        String xml = writer.toString();
        String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CalculatorRequest Operator=\"ADD\"><LHS>10</LHS><RHS>10</RHS></CalculatorRequest>";
        assertEquals(expectedXml, xml);
    }
    
    @Test
    public void testSubtract() throws JAXBException {
        CalculatorRequest c = new CalculatorRequest(10, 10, CalculatorRequest.CalculatorOperation.SUBTRACT);

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(CalculatorRequest.class);
        Marshaller m = context.createMarshaller();
        m.marshal(c, writer);

        String xml = writer.toString();
        String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CalculatorRequest Operator=\"SUBTRACT\"><LHS>10</LHS><RHS>10</RHS></CalculatorRequest>";
        assertEquals(expectedXml, xml);
    }
    
    @Test
    public void testMultiply() throws JAXBException {
        CalculatorRequest c = new CalculatorRequest(10, 10, CalculatorRequest.CalculatorOperation.MULTIPLY);

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(CalculatorRequest.class);
        Marshaller m = context.createMarshaller();
        m.marshal(c, writer);

        String xml = writer.toString();
        String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CalculatorRequest Operator=\"MULTIPLY\"><LHS>10</LHS><RHS>10</RHS></CalculatorRequest>";
        assertEquals(expectedXml, xml);
    }

    @Test
    public void testDivide() throws JAXBException {
        CalculatorRequest c = new CalculatorRequest(10, 10, CalculatorRequest.CalculatorOperation.DIVIDE);

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(CalculatorRequest.class);
        Marshaller m = context.createMarshaller();
        m.marshal(c, writer);

        String xml = writer.toString();
        String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CalculatorRequest Operator=\"DIVIDE\"><LHS>10</LHS><RHS>10</RHS></CalculatorRequest>";
        assertEquals(expectedXml, xml);
    }
    
    
}
