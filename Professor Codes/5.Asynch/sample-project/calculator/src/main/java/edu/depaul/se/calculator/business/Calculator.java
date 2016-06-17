package edu.depaul.se.calculator.business;

/**
 * Performs "business" logic
 */
public final class Calculator {
    /**
     * Adds two numbers together
     * @param lhs
     * @param rhs
     * @return
     */
    public float add(float lhs, float rhs) {
        return lhs + rhs;
    }

    /**
     * Multiplies two numbers together
     * @param lhs
     * @param rhs
     * @return
     */
    public float multiply(float lhs, float rhs) {
        return lhs * rhs;
    }

    /**
     * Divide lhs by rhs (lhs/rhs)
     * @param lhs
     * @param rhs
     * @return
     */
    public float divide(float numerator, float denominator) {
        return numerator / denominator;
    }

    /**
     * Subtract rhs from lhs (lhs - rhs)
     * @param lhs
     * @param rhs
     * @return
     */
    public float subtract(float lhs, float rhs) {
        return lhs - rhs;
    }
}
