package db;

import model.Student;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBTxt implements DBStudents {
    private BufferedReader reader;

    @Override
    public Student getStudent(int id) throws IOException {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream("resources/students.txt")));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" ");
            if (Integer.parseInt(data[0]) == id) {
                return new Student(data[1], Integer.parseInt(data[2]));
            }
        }
        reader.close();
        System.out.println("Wrong request");
        return null;
    }

    @Override
    public List<Student> getStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream("resources/students.txt")));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" ");
            students.add(new Student(data[1], Integer.parseInt(data[2])));
        }
        return students;
    }
}
