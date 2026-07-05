import java.util.List;

public class UserRepository implements Repository<Student> {
    private final InMemoryDB inMemoryDB;

    public UserRepository(InMemoryDB inMemoryDB) {
        this.inMemoryDB = inMemoryDB;
    }

    @Override
    public List<Student> findAll() {
        return inMemoryDB.findAll();
    }

    @Override
    public List<Student> findByDepartment(Department department) {
        return inMemoryDB.findByDepartment(department);
    }

    @Override
    public Student findById(int id) {
        return inMemoryDB.findById(id);
    }
}
