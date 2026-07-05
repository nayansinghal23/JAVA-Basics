import java.util.List;

public class Main {
    public static void main(String[] args) {
        InMemoryDB inMemoryDB = new InMemoryDB();
        UserRepository userRepository = new UserRepository(inMemoryDB);
        StudentService studentService = new StudentService(userRepository);
        List<Student> students = studentService.getAllStudents();
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
