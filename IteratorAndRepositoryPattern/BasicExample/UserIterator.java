import java.util.ArrayList;
import java.util.List;

public class UserIterator implements Iterator<String> {
    private final UserRepository repository;
    private int limit = 1;
    private int offset = 0;
    private List<String> currentUsers = new ArrayList<>();

    public UserIterator(UserRepository repository, int limit, int offset) {
        this.repository = repository;
        this.limit = limit;
        this.offset = offset;
        this.currentUsers = repository.findUsers(limit, offset);
    }

    @Override
    public boolean hasNext() {
        return !currentUsers.isEmpty();
    }

    @Override
    public List<String> next() {
        List<String> nextUsers = currentUsers;
        offset += limit;
        currentUsers = repository.findUsers(limit, offset);
        return nextUsers;
    }
}
