package FacadeDesignPattern.BasicExample;

public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.withdraw("1234567890", 100, "1234");
    }
}
