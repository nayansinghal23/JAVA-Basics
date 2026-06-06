package BuilderDesignPattern.UserProfileBuilder;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int age;
    private String company;

    public User(UserBuilder userBuilder) {
        this.id = userBuilder.getId();
        this.name = userBuilder.getName();
        this.email = userBuilder.getEmail();
        this.phone = userBuilder.getPhone();
        this.address = userBuilder.getAddress();
        this.age = userBuilder.getAge();
        this.company = userBuilder.getCompany();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public int getAge() {
        return this.age;
    }

    public String getCompany() {
        return this.company;
    }

    public void display() {
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Email : " + email);
        System.out.println("Phone : " + phone);
        System.out.println("Address : " + address);
        System.out.println("Age : " + age);
        System.out.println("Company : " + company);
    }
}
