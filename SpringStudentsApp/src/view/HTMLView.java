package view;

import model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HTMLView implements View {
    @Override
    public String showStudent(Student student) {
        return "<h1>" + student.getName() + "</h1>";
    }

    private String wrapByTd(String x) {
        return "<td>" + x + "</td>";
    }
    @Override
    public String showStudents(List<Student> students) {
        String result = "<table>";
        for (Student student: students) {
            result += "<tr>" + wrapByTd(student.getName())
                    + wrapByTd(String.valueOf(student.getYear()))
                    + "</tr>";
        }
        return result + "</table>";
    }
}