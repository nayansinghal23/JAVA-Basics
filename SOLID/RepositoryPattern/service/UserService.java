package SOLID.RepositoryPattern.service;

import java.util.ArrayList;
import java.util.List;

import SOLID.RepositoryPattern.iterator.Iterator;

public class UserService {
    private final Iterator userIterator;

    public UserService(Iterator userIterator) {
        this.userIterator = userIterator;
    }

    public List<String> fetchUsers(int limit, int offset) {
        if(!this.userIterator.hasNext()) return new ArrayList<>();

        return this.userIterator.next();
    }
}
