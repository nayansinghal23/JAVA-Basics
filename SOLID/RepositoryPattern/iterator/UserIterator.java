package SOLID.RepositoryPattern.iterator;

import java.util.ArrayList;
import java.util.List;

import SOLID.RepositoryPattern.repositories.UserRepository;

public class UserIterator implements Iterator {
    private int offset;
    private final int limit;
    private final UserRepository userRepository;
    private List<String> users = new ArrayList<>();

    public UserIterator(int offset, int limit, UserRepository userRepository) {
        this.offset = offset;
        this.limit = limit;
        this.userRepository = userRepository;
        this.users = userRepository.findUsers(limit, offset);
    }

    @Override
    public boolean hasNext() {
        return !this.users.isEmpty();
    }

    @Override
    public List<String> next() {
        List<String> result = users;
        this.offset += this.limit;
        this.users = this.userRepository.findUsers(this.limit, this.offset);
        return result;
    }
}
