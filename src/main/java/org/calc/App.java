package org.calc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int op, flag = 0;
        double num, exp;
        int num_int;
        System.out.println("------------Scientific Calculator--------------");
        do {
            System.out.println("List of Possible Operations:");
            logger.info("A user has entered!");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Logarithm");
            System.out.println("4. Power");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice (number): ");
            op = reader.nextInt();

            if (op == 5) flag = 1;
            else {
                switch (op) {
                    case 1:  // Square Root
                        System.out.println("You have chosen Square Root!!");
                        System.out.println();
                        System.out.print("Enter number: ");
                        num = reader.nextDouble();
                        squareRoot(num);
                        break;

                    case 2: // Factorial
                        System.out.println("You have chosen Factorial!!");
                        System.out.println();
                        System.out.print("Enter number: ");
                        num_int = reader.nextInt();
                        factorial(num_int);
                        break;

                    case 3: // Natural Logarithm
                        System.out.println("You have chosen Natural Logarithm!!");
                        System.out.println();
                        System.out.print("Enter number: ");
                        num = reader.nextDouble();
                        naturalLog(num);
                        break;

                    case 4: // Power
                        System.out.println("You have chosen Power!!");
                        System.out.println();
                        System.out.print("Enter number: ");
                        num = reader.nextDouble();
                        System.out.print("Enter exponent: ");
                        exp = reader.nextDouble();
                        power(num, exp);
                        break;

                    default: // Invalid
                        System.out.println("Exiting due to invalid input!!");
                        flag = 1;
                }
            }
        } while (flag == 0);
    }

    public static double squareRoot(double num) {
        double c = Math.sqrt(num);
        logger.info("Square root of " + num + " = " + c);
        System.out.println();
        System.out.println("The result is " + c);
        System.out.println();
        return c;
    }

    public static int factorial(int num) {
        int c = num;
        for (int i = num - 1; i >= 1; i--) c = c * i;
        logger.info("Factorial of " + num);
        logger.info(num + "!" + " = " + c);
        System.out.println();
        System.out.println("The result is " + c);
        System.out.println();
        return c;
    }

    public static double naturalLog(double num) {
        double c = Math.log(num);
        logger.info("Natural logarithm of " + num);
        logger.info("log(" + num + ") = " + c);
        System.out.println();
        System.out.println("The result is " + c);
        System.out.println();
        return c;
    }

    public static double power(double num, double exp) {
        double c = Math.pow(num, exp);
        logger.info(num + " to the power of " + exp);
        logger.info(num + "^" + exp + " = " + c);
        System.out.println();
        System.out.println("The result is " + c);
        System.out.println();
        return c;
    }
}
