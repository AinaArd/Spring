package db;

import model.Student;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface DBStudents {
    Student getStudent(int id) throws IOException;
    List<Student> getStudents() throws IOException;
}
