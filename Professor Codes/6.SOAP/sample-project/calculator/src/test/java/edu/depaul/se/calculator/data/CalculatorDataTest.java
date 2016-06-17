package edu.depaul.se.calculator.data;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorDataTest {

    @Test
    public void testCalcDataMsg() throws JAXBException {
        CalculatorData c = new CalculatorData();
        c.setLhs(10);
        c.setRhs(20);

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(CalculatorData.class);
        Marshaller m = context.createMarshaller();
        m.marshal(c, writer);

        String xml = writer.toString();
        String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><calculatorData lhs=\"10.0\" rhs=\"20.0\"><result>0.0</result></calculatorData>";
        assertEquals(expectedXml, xml);
    }
}
