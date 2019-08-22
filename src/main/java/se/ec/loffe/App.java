package se.ec.loffe;

import java.util.Scanner;

public class App
{
    public static void menu1() {
        System.out.println("### Calculator ###\n(X for exit)\nEnter a number: ");
    }
    public static void menu2() {
        System.out.println("Enter an operator [+-*/%]: ");
    }
    public static void menu3() {
        System.out.println("Enter another number: ");
    }

    public static double addition(double num1, double num2){
            double addition;
            return addition = num1 + num2;
    }
    public static double subtraction(double num1, double num2){
        double subtraction;
        return subtraction = num1 - num2;
    }
    public static double multiplication(double num1, double num2){
        double multiplication;
        return multiplication = num1 * num2;
    }
    public static double division(double num1, double num2){
        double division;
        return division = num1 / num2;
    }
    public static double modulus(double num1, double num2){
        double modulus;
        return modulus = num1 % num2;
    }
    public static double addFromArray(double[] numbers){
        double sum = 0;
        for (Double number: numbers) {
            sum += number;
        }
        return sum;
    }
    public static boolean askForMoreNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Additional numbers? (y/n) :");
        String answ = scanner.nextLine();
        if(answ.equalsIgnoreCase("y")){
            return true;
        }else{
            return false;
        }
    }

    public static void main( String[] args ) {
        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;
        double[] arrayOfDoubles = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        while(isRunning){
            menu1();
            String input1 = scan.nextLine();
            if(input1.equalsIgnoreCase("x")){
                isRunning = false;
                System.out.println("Hope you had a good time!");
                scan.close();
                break;

            }
            double num1 = Double.parseDouble(input1);

            menu2();
            String oper = scan.nextLine();

            menu3();
            String input2 = scan.nextLine();
            double num2 = Double.parseDouble(input2);

            if(oper.equals("+") || oper.equals("-")) {
                while (askForMoreNumbers()) {
                    menu3();
                    int x = 0;
                    String input3 = scan.nextLine();
                    arrayOfDoubles[x] = Double.parseDouble(input3);
                    x++;
                }
                if(oper.equals("+")){

                    System.out.println("Result: " + addFromArray(arrayOfDoubles));

                }
            }




            switch (oper){
                case "+":
                    System.out.println("Answer: " + num1 + " " + oper + " " + num2 + " = " + addition(num1, num2));
                    break;
                case "-":
                    System.out.println("Answer: " + num1 + " " + oper + " " + num2 + " = " + subtraction(num1, num2));
                    break;
                case "*":
                    System.out.println("Answer: " + num1 + " " + oper + " " + num2 + " = " + multiplication(num1, num2));
                    break;
                case "/":
                    System.out.println("Answer: " + num1 + " " + oper + " " + num2 + " = " + division(num1, num2));
                    break;
                case "%":
                    System.out.println("Answer: " + num1 + " " + oper + " " + num2 + " = " + modulus(num1, num2));
                    break;
                default:
                    System.out.println("Weird operator! Doesn't work. Please try again.");
                    break;
            }
        }
        scan.close();
    }
}
