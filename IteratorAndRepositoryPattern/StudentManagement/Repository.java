import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findById(int id);
    List<T> findByDepartment(Department department);
}
