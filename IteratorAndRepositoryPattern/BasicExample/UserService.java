import java.util.List;

public class UserService {
    private final UserRepository repository;
    private final UserIterator iterator;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.iterator = new UserIterator(repository, 10, 0);
    }

    public List<String> fetchUsers(int limit, int offset) {
        if (iterator.hasNext()) return iterator.next();
        return null;
    }
}
