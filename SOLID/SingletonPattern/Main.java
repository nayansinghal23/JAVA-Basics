// Whenever you want to share 1 single object across the application, you can use the Singleton pattern.
// To make a class Singleton, you need to make the constructor private and provide a public static method that returns the instance of the class.

package SOLID.SingletonPattern;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            DBConnection.getInstance("Connection 1");
        });

        Thread t2 = new Thread(() -> {
            DBConnection.getInstance("Connection 2");
        });

        t1.start();
        t2.start();
    }
}
