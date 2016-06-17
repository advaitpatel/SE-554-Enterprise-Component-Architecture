package edu.depaul.se.xml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CalculatorRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class CalculatorRequest implements Serializable {
    public static enum CalculatorOperation { ADD, SUBTRACT, MULTIPLY, DIVIDE};
    
    @XmlElement(name="LHS")
    private int lhs;
    @XmlElement(name="RHS")
    private int rhs;    
    @XmlAttribute(name="Operator")
    private CalculatorOperation operator;

    public CalculatorRequest() {}
    public CalculatorRequest(int lhs, int rhs, CalculatorOperation operator) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.operator = operator;
    }

    
    public void setLhs(int lhs) {
        this.lhs = lhs;
    }

    public void setOperator(CalculatorOperation operator) {
        this.operator = operator;
    }

    public void setRhs(int rhs) {
        this.rhs = rhs;
    }

    public int getLhs() {
        return lhs;
    }

    public CalculatorOperation getOperator() {
        return operator;
    }

    public int getRhs() {
        return rhs;
    }
    
}
