package BuilderDesignPattern.UserProfileBuilder;

public class UserBuilder {
    // Required
    private int id;
    private String name;
    // Optional
    private String email;
    private String phone;
    private String address;
    private int age;
    private String company;

    public UserBuilder(int id, String name) {
        this.id = id;
        this.name = name;
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

    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder setCompany(String company) {
        this.company = company;
        return this;
    }

    public User build() {
        return new User(this);
    }
}
