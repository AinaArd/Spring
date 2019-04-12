package view;

import model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JSONView implements View {
    @Override
    public String showStudent(Student student) {
        return "{\"student_name\": " + student.getName() + "}";
    }

    @Override
    public String showStudents(List<Student> students) {
        String result = "{\n" +
                "    \"students\" : [";

        for(Student student : students) {
            result += "{\n" +
                    "        \"student_name\": " + student.getName() + "\n" +
                    "        \"year\": " + student.getYear() + "\n" +
                    "    },";
        }
        return result + "]\n" +
                "}";
    }
}
