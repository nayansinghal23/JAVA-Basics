import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryDB {
    private final List<Student> students;

    public InMemoryDB() {
        students = new ArrayList<>();
        seedStudents();
    }

    private void seedStudents() {
        students.add(new Student(1, "John Doe", Department.IT, 3.5));
        students.add(new Student(2, "Jane Smith", Department.HR, 3.8));
        students.add(new Student(3, "Jim Beam", Department.SALES, 3.2));
        students.add(new Student(4, "Jill Johnson", Department.MARKETING, 3.9));
        students.add(new Student(5, "Jack Johnson", Department.IT, 3.7));
        students.add(new Student(6, "Jill Smith", Department.HR, 3.6));
        students.add(new Student(7, "Jim Johnson", Department.SALES, 3.3));
        students.add(new Student(8, "Jill Johnson", Department.MARKETING, 3.8));
        students.add(new Student(9, "Jack Johnson", Department.IT, 3.9));
        students.add(new Student(10, "Jill Smith", Department.HR, 3.5));
        students.add(new Student(11, "Jim Johnson", Department.SALES, 3.2));
        students.add(new Student(12, "Jill Johnson", Department.MARKETING, 3.9));
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        return students.stream()
            .filter(student -> student.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public List<Student> findByDepartment(Department department) {
        return students.stream()
            .filter(student -> student.getDepartment() == department)
            .collect(Collectors.toList());
    }
}
