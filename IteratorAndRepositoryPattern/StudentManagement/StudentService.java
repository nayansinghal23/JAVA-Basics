import java.util.List;

public class StudentService {
    private final Repository<Student> studentRepository;

    public StudentService(Repository<Student> studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public List<Student> getStudentsByDepartment(Department department) {
        return studentRepository.findByDepartment(department);
    }
}
