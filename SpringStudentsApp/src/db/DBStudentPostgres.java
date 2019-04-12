package db;

import model.Student;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBStudentPostgres implements DBStudents {

    private static final String GET_STUDENTS = "select * from student ";
    private static final String GET_STUDENT_BY_ID = "select * from student where id = ?";


    @Override
    public Student getStudent(int id) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres",
                    "postgres");
            PreparedStatement st = conn.prepareStatement(GET_STUDENT_BY_ID);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                return new Student(rs.getString("name"), rs.getInt("year"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres",
                    "postgres");
            PreparedStatement st = conn.prepareStatement(GET_STUDENTS);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                students.add(new Student(rs.getString("name"), rs.getInt("year")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
