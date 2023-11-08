package fr.pollux.katarpn;

import fr.pollux.katarpn.exception.InvalidFormatException;
import fr.pollux.katarpn.Operation;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RPNHandler {
    private List<String> tokens;
    private Stack<Integer> stack;

    public RPNHandler(String rpn) {
        tokens = Arrays.asList(rpn.split(" "));
        stack = new Stack<>();
    }

     public int operations() throws InvalidFormatException {
        try {
            for (String el : tokens) {
                switch (el) {
                    case "+":
                        stack.add(Operation.addition(stack.pop(), stack.pop()));
                        break;
                    case "-":
                        stack.add(Operation.substraction(stack.pop(), stack.pop()));
                        break;
                    default:
                        stack.add(Double.parseDouble(el));
                }
            }
        }
        catch (NumberFormatException|EmptyStackException e){
            throw new InvalidFormatException();
        }

        if(stack.size() == 1) {
            return stack.pop();
        }
        throw new InvalidFormatException();
    }
}
