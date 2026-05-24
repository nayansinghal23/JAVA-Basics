package SOLID.RepositoryPattern.repositories;

import java.util.List;
import SOLID.RepositoryPattern.Database;

public class UserRepositoryImpl implements UserRepository {
    private final Database db;

    public UserRepositoryImpl(Database db) {
        this.db = db;
    }

    @Override
    public List<String> findUsers(int limit, int offset) {
        return this.db.getUsers(limit, offset);
    }
}
