package se.ec.loffe;

import java.util.Arrays;
import java.util.Scanner;

public class App
{
    public static Scanner scan = new Scanner(System.in);
    public static int arrayIndex = 0;

    private static void msg1() {
        System.out.print("### Calculator by Loffe ### (X to exit)\nEnter first number: ");
    }
    private static void msg2() {
        System.out.print("Enter an operator [+-*/%]: ");
    }
    private static void msg3() {
        System.out.print("Enter another number: ");
    }
    private static void msg4() {
        System.out.println("Invalid input. Please only use integers and decimals.");
    }
    private static void msg5() {
        System.out.println("Invalid input. Please only use +, -, *, / or % (modulus).");
    }

    public static double addition(double num1, double num2, double num3){
        return num1 + num2 + num3;
    }
    public static double subtraction(double num1, double num2, double num3){
        return num1 - num2 - num3;
    }
    public static double multiplication(double num1, double num2){
        return num1 * num2;
    }
    public static double division(double num1, double num2){
        return num1 / num2;
    }
    public static double modulus(double num1, double num2){
        return num1 % num2;
    }

    public static double addFromArray(double[] numbers){
        double sum = 0;
        for (Double number: numbers) {
            sum += number;
        }
        return sum;
    }

    private static boolean askForMoreNumbers(){
        if(arrayIndex < 5) {
            System.out.print("Additional numbers? (Y/y for yes, any key for no): ");
            String answerMoreNumbers = scan.nextLine();
            return answerMoreNumbers.equalsIgnoreCase("y");
        }else {
            System.out.println("Max index reached. No more input possible.");
            return false;
        }
    }

    public static void main( String[] args ) {
        boolean isRunning = true;
        double num1 = 0;
        double num2 = 0;
        double[] arrayOfDoubles = {0, 0, 0, 0, 0};

        while(isRunning){
            // Get first number
            String input1;
            boolean running = true;
            while(running) {
                msg1(); // calculator main menu
                input1 = scan.nextLine();
                if(input1.equalsIgnoreCase("x")){
                    isRunning = false;
                    System.out.println("Hope you had a good time!");
                    scan.close();
                    System.exit(0);
                }if(!input1.equalsIgnoreCase("x")){
                    try {
                        num1 = Double.parseDouble(input1);
                        running = false;
                    } catch (Exception e) {
                        msg4(); // invalid input message
                    }
                }
            }

            // Get operator
            msg2(); // ask for operator
            String oper = scan.nextLine();
            while(!(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/") || oper.equals("%"))){
                msg5(); // invalid input message
                msg2(); // ask for operator
                oper = scan.nextLine();
            }

            // Get second number
            String input2;
            running = true;
            do {
                msg3(); // ask for another number
                input2 = scan.nextLine();
                try {
                    num2 = Double.parseDouble(input2);
                    running = false;
                }catch (Exception e){
                    msg4(); // invalid input message
                }
            }while(running);

            // If addition or subtraction is chosen the user can
            // add additional numbers.
            if(oper.equals("+") || oper.equals("-")) {
                arrayIndex = 0;
                running = true;
                while (askForMoreNumbers()){
                    msg3(); // ask for another number
                    String input3 = scan.nextLine();
                    do {
                        try {
                            arrayOfDoubles[arrayIndex] = Double.parseDouble(input3);
                            running = false;
                            }catch (Exception e){
                            msg4(); // invalid input message
                            running = false;
                        }
                    }while(running);
                    arrayIndex++;
                }
            }

            // Print results, depending on operator
            switch (oper){
                case "+":
                    System.out.println("Result: " + addition(addFromArray(arrayOfDoubles), num1, num2));
                    Arrays.fill(arrayOfDoubles, 0);
                    break;
                case "-":
                    System.out.println("Result: " + subtraction(num1, num2, addFromArray(arrayOfDoubles)));
                    Arrays.fill(arrayOfDoubles, 0);
                    break;
                case "*":
                    System.out.println("Result: " + multiplication(num1, num2));
                    break;
                case "/":
                    System.out.println("Result: " + division(num1, num2));
                    break;
                case "%":
                    System.out.println("Result: " + modulus(num1, num2));
                    break;
                default:
                    System.out.println("Unknown error. What happened?");
                    break;
            }
        }
        scan.close();
    }
}
