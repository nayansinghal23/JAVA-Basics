package SOLID.RepositoryPattern;

import java.util.List;

import SOLID.RepositoryPattern.iterator.UserIterator;
import SOLID.RepositoryPattern.repositories.UserRepository;
import SOLID.RepositoryPattern.repositories.UserRepositoryImpl;
import SOLID.RepositoryPattern.service.UserService;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        UserRepository userRepository = new UserRepositoryImpl(db);
        UserIterator userIterator = new UserIterator(1910, 100, userRepository);
        UserService consumer = new UserService(userIterator);

        List<String> users = consumer.fetchUsers(100, 1980);
        System.out.println("Users : " + users);
    }
}
