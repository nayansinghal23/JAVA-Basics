package BuilderDesignPattern.UserProfileBuilder;

public class Main {
    public void main() {
        User user = new UserBuilder(1, "Nayan").setEmail("abc@gmail.com").setPhone("9999999999").setAge(24).build();
        user.display();
    }
}
