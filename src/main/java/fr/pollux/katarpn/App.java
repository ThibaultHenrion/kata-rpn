package fr.pollux.katarpn;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Enter your operation : " );

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        RPNHandler rpnHandler = new RPNHandler(input);
        System.out.println( "The result is : " + rpnHandler.operations());

    }
}
