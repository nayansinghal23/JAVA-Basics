import java.util.List;

public interface UserRepository {
    List <String> findUsers(int limit, int offset);
}
