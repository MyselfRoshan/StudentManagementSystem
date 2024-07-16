package Model;

import java.util.ArrayList;
import java.util.List;

public class StudentsModel {
    private List<Student> students;

    public StudentsModel() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public boolean searchStudent(Student student) {
        return students.contains(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
