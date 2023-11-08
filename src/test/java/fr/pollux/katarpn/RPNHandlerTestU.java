package fr.pollux.katarpn;


import fr.pollux.katarpn.exception.InvalidFormatException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for RPN Handler.
 */
public class RPNHandlerTestU {

    /**
     * Testing 1 + 2
     * @throws InvalidFormatException
     */
    @Test
    public void additionWorks() throws InvalidFormatException {
        String rpn = "1 2 +";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(3, result, 0);
    }

    /**
     *  Testing 3 - 2
     * @throws InvalidFormatException
     */
    @Test
    public void substractionWorks() throws InvalidFormatException {
        String rpn = "3 2 -";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(1, result, 0);
    }

    /**
     * Testing a single number (should return itself)
     * @throws InvalidFormatException
     */
    @Test
    public void singleNumberWorks() throws InvalidFormatException {
        String rpn = "1";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(1, result, 0);
    }

    /**
     * Testing a single negative number (should return itself)
     * @throws InvalidFormatException
     */
    @Test
    public void singleNegativeNumberWorks() throws InvalidFormatException {
        String rpn = "-1";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(-1, result, 0);
    }

    /**
     * Trying starting with an operator (should throw an exception because there is no number to operate)
     * @throws InvalidFormatException   Should be thrown
     */
    @Test(expected = InvalidFormatException.class)
    public void InvalidOperationOrder() throws InvalidFormatException {
        String rpn = "- 1 6";

        var rpnHandler = new RPNHandler(rpn);
        var result = rpnHandler.operations();
    }

    /**
     * Trying with an operator that does not exist ("?")
     * @throws InvalidFormatException   Should be
     */
    @Test(expected = InvalidFormatException.class)
    public void InvalidOperationType() throws InvalidFormatException {
        String rpn = "3 4 ?";

        var handler = new RPNHandler(rpn);
        var result = handler.operations();
    }

    /**
     * Trying with too many numbers at the end (2 instead of 1)
     * @throws InvalidFormatException   Should be thrown
     */
    @Test(expected = InvalidFormatException.class)
    public void InvalidOperationNumber() throws InvalidFormatException {
        String rpn = "3 4 1 +";

        var handler = new RPNHandler(rpn);
        var result = handler.operations();
    }

    /**
     * Trying the order of priority with two operators
     * @throws InvalidFormatException
     */
    @Test
    public void priorityOperationWorks() throws InvalidFormatException {
        String rpn = "4 2 1 + -";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(1, result, 0);
    }

    /**
     * Trying an addition with double variables
     * @throws InvalidFormatException
     */
    @Test
    public void doubleOperationWorks() throws InvalidFormatException {
        String rpn = "0.5 1 +";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(1.5, result, 0);
    }

    /**
     * Trying an addition with multiple double numbers
     * @throws InvalidFormatException
     */
    @Test
    public void multipleDoubleOperationWorks() throws InvalidFormatException {
        String rpn = "0.5 1.5 -";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(-1, result, 0);
    }

    /**
     * Trying the multiplication
     * @throws InvalidFormatException
     */
    @Test
    public void multiplicationWorks() throws InvalidFormatException {
        String rpn = "2 3 *";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(6, result, 0);
    }

    /**
     * Trying the division
     * @throws InvalidFormatException
     */
    @Test
    public void divisionWorks() throws InvalidFormatException {
        String rpn = "15 3 /";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(5, result, 0);
    }

    /**
     * Trying the sqrt
     * @throws InvalidFormatException
     */
    @Test
    public void squareRootWorks() throws InvalidFormatException {
        String rpn = "9 sqrt";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(3, result, 0);
    }

    /**
     * Trying to calculate sqrt with no number
     * @throws InvalidFormatException
     */
    @Test(expected = InvalidFormatException.class)
    public void InvalidSquareRootExpression() throws InvalidFormatException {
        String rpn = "sqrt";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();
    }

    /**
     * Checking if the maximum works
     * @throws InvalidFormatException
     */
    @Test
    public void maximumWorks() throws InvalidFormatException {
        String rpn = "5 11 14 10 max";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(14, result, 0);
    }

    /**
     * Checking if the minimum works
     * @throws InvalidFormatException
     */
    @Test
    public void minimumWorks() throws InvalidFormatException {
        String rpn = "5 11 14 10 min";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(5, result, 0);
    }

    @Test
    public void powerWorks() throws InvalidFormatException {
        String rpn = "2 3 ^";

        var rpnHandler = new RPNHandler(rpn);

        var result = rpnHandler.operations();

        assertEquals(8, result, 0);
    }
}
