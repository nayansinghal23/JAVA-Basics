import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private InMemoryDatabase database;

    public UserRepositoryImpl(InMemoryDatabase database) {
        this.database = database;
    }

    @Override
    public List<String> findUsers(int limit, int offset) {
        if(limit <= 0 || offset <= 0) {
            throw new IllegalArgumentException("Limit and offset must be greater than 0");
        }

        List<String> users = database.getUsers();
        int start = (offset - 1) * limit;
        int end = Math.min(start + limit, users.size());
        return users.subList(start, end);
    }
}
