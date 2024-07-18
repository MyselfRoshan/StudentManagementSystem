package Model;

// import java.util.ArrayList;
// import java.util.List;

// public class StudentsModel {
//     private List<Student> students;

//     public StudentsModel() {
//         students = new ArrayList<>();
//     }

//     public void addStudent(Student student) {
//         students.add(student);
//     }

//     public void removeStudent(Student student) {
//         students.remove(student);
//     }

//     public boolean searchStudent(Student student) {
//         return students.contains(student);
//     }

//     public List<Student> getStudents() {
//         return students;
//     }
// }
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    private List<Student> students;
    private final String[] columnNames = { "Username", "Name", "Address", "Phone Number", "Gender", "Faculty" };

    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getUsername();
            case 1:
                return student.getName();
            case 2:
                return student.getAddress();
            case 3:
                return student.getPhoneNumber();
            case 4:
                return student.getGender();
            case 5:
                return student.getFaculty();
            default:
                return null;
        }
    }
}
