package edu.depaul.se.calculator.data;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "calculatorData")
public class CalculatorData {
    private float lhs;
    
    private float rhs;
    
    private float result;

    public CalculatorData() {        
    }
    
    public CalculatorData(float lhs, float rhs, float result) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.result = result;
    }

    /**
     * @return the lhs
     */
    @XmlAttribute
    public float getLhs() {
        return lhs;
    }

    /**
     * @param lhs the lhs to set
     */
    public void setLhs(float lhs) {
        this.lhs = lhs;
    }

    /**
     * @return the rhs
     */
    @XmlAttribute
    public float getRhs() {
        return rhs;
    }

    /**
     * @param rhs the rhs to set
     */
    public void setRhs(float rhs) {
        this.rhs = rhs;
    }

    /**
     * @return the result
     */
    @XmlElement
    public float getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(float result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CalculatorData{" + "lhs=" + lhs + ", rhs=" + rhs + ", result=" + result + '}';
    }
    
    
}
