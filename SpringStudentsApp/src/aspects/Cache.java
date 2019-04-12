package aspects;

import model.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class Cache {
    private Map<Integer, Student> studentsInCache = new HashMap<>();

    @Around("execution(* *..*.getStudent(*))")
    public Student getStudentFromCache(ProceedingJoinPoint jp) throws Throwable {
        int id = (int) jp.getArgs()[0];
        if (studentsInCache.containsKey(id)) {
            System.out.println(1);
            return studentsInCache.get(id);
        } else {
            Student student = (Student) jp.proceed(jp.getArgs());
            studentsInCache.put(student.getId(), student);
            return student;
        }
    }
}
