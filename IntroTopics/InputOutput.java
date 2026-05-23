package IntroTopics;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        // creating an object of Scanner class
        Scanner input = new Scanner(System.in);

        // taking input from user
        System.out.print("Enter your age : ");
        int age = input.nextInt();
        System.out.println("Age : " + age);

        System.out.print("Enter your float value : ");
        float floatValue = input.nextFloat();
        System.out.println("Float Value : " + floatValue);

        System.out.print("Enter your double value : ");
        double doubleValue = input.nextDouble();
        System.out.println("Double Value : " + doubleValue);

        System.out.print("Enter your name : ");
        String name = input.nextLine();
        System.out.println("Name : " + name);

        input.close(); // Releases the resources used by the Scanner.
    }
}
