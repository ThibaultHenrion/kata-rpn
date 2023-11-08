package fr.pollux.katarpn;

import fr.pollux.katarpn.exception.InvalidFormatException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTestU {

    @Test
    public void operationAdditionWorks() {
        double num1 = 1, num2 = 2;

        double result = Operation.addition(num1, num2);

        assertEquals(3, result, 0);
    }

    @Test
    public void operationSubstractionWorks() {
        double num1 = 2, num2 = 1;

        double result = Operation.substraction(num1, num2);

        assertEquals(-1, result, 0);
    }

    @Test
    public void operationMultiplicationWorks() {
        double num1 = 2, num2 = 3;

        double result = Operation.multiplication(num1, num2);

        assertEquals(6, result, 0);
    }

    @Test
    public void operationDivisionWorks() {
        double num1 = 2, num2 = 1;

        double result = Operation.division(num1, num2);

        assertEquals(0.5, result, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void DivideByZero() {
        double num1 = 0, num2 = 2;

        double val = Operation.division(num1,num2);
    }
}
