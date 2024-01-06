// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
class HelloWorld {
    
    public static void main(String[] args) {
        System.out.println("--------------------Hello, World! Welcome to my calculator --------------------");
        while(true){
       Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number : ");
        int a = scanner.nextInt();
        System.out.print("Enter second number : ");
        int b = scanner.nextInt();
        System.out.print("Enter the operator you want to perform between +, -, *, and / : ");
        scanner.nextLine(); 
         String op = scanner.nextLine();
       
        switch(op){
            case "+":
                System.out.println("Sum of "+a+ " + " + b + " = " + (a+b));
                break;
            case "-":
                System.out.println("Sum of "+a+ " - " + b + " = " + (a-b));
                break;
            case "*":
                System.out.println("Sum of "+a +" * " + b + " = " + (a*b));
                break;
            case "/":
                System.out.println("Sum of "+a+ " / " + b + " = " + (a/b));
                break;
            default:
                System.out.println("invalid operator ");
               
        }
        }
    }
}
