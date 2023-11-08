package fr.pollux.katarpn;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class OperationTestU {

    /**
     * Trying the addition
     */
    @Test
    public void operationAdditionWorks() {
        double num1 = 1, num2 = 2;

        double result = Operation.addition(num1, num2);

        assertEquals(3, result, 0);
    }

    /**
     * Trying the substraction
     */
    @Test
    public void operationSubstractionWorks() {
        double num1 = 2, num2 = 1;

        double result = Operation.substraction(num1, num2);

        assertEquals(-1, result, 0);
    }

    /**
     * Trying the multiplication
     */
    @Test
    public void operationMultiplicationWorks() {
        double num1 = 2, num2 = 3;

        double result = Operation.multiplication(num1, num2);

        assertEquals(6, result, 0);
    }

    /**
     * Trying the division
     */
    @Test
    public void operationDivisionWorks() {
        double num1 = 2, num2 = 1;

        double result = Operation.division(num1, num2);

        assertEquals(0.5, result, 0);
    }

    /**
     * Trying the division by zero
     */
    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        double num1 = 0, num2 = 2;

        double val = Operation.division(num1,num2);
    }

    /**
     * Test the square root operation with 9
     */
    @Test
    public void squareRoot() {
        double num1 = 9;

        double val = Operation.squareRoot(num1);

        assertEquals(3, val, 0);
    }

    /**
     * Trying to get the maximum
     */
    @Test
    public void maximumWorks() {
        Stack<Double> stack = new Stack<>();
        double maxValue = 10;
        stack.add(1.);
        stack.add(maxValue);

        double val = Operation.maximum(stack);

        assertEquals(maxValue, val,0);
    }

    /**
     * Find the minimum value in the stack
     */
    @Test
    public void findMinimum() {
        Stack<Double> stack = new Stack<>();
        double minValue = .6;
        stack.add(1.0);
        stack.add(2.8);
        stack.add(minValue);

        double val = Operation.minimum(stack);

        assertEquals(minValue, val,0);

    }

    @Test
    public void power() {
        double num1 = 2, num2 = 3;

        double val = Operation.power(num1, num2);

        assertEquals(9, val, 0);
    }
}
