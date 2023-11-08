package fr.pollux.katarpn;

import java.lang.Math;
import java.util.EmptyStackException;
import java.util.Stack;

public class Operation
{
    public static double addition(double num1, double num2)
    {
        return num1 + num2;
    }

    public static double substraction(double num1, double num2)
    {
        return num2 - num1;
    }

    public static double multiplication(double num1, double num2) { return num1 * num2; }

    public static double division(double num1, double num2)
    {
        if (num1 == 0) {
            throw new ArithmeticException(); // Dividing a double by zero returns Infinity and doesn't throw an exception
        }
        return num2 / num1;
    }

    public static double squareRoot(double num) { return Math.sqrt(num); }

    public static double maximum(Stack<Double> stack)
    {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.stream().max(Double::compareTo).get();
    }

    public static double minimum(Stack<Double> stack)
    {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.stream().min(Double::compareTo).get();
    }
}
