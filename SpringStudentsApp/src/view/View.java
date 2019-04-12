package view;

import model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface View {
    String showStudent(Student student);
    String showStudents(List<Student> students);
}
