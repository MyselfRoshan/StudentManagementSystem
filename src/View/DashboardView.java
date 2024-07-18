package View;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Components.Controller.TopBarController;
import Components.View.TopBarView;
import Enums.Faculty;
import Enums.Gender;
import Interface.View;
import Model.Student;
import Model.StudentTableModel;
import Utils.Database;

public class DashboardView extends JFrame implements View {

    public static final int DISPLAY_WIDTH = 1920;
    public static final int DISPLAY_HEIGHT = 1024;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 300;
    public static final int TEXTFIELD_COLUMNS = 30;

    // private JLabel usernameLabel;
    // private JTextField
    // private JTextField
    private JTable studenTable;
    private List<Student> students = new ArrayList<>();
    // private List<Student> students;

    public DashboardView() {
        setTitle("Student List");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // center the frame
        int x = (DISPLAY_WIDTH - WINDOW_WIDTH) / 2;
        int y = (DISPLAY_HEIGHT - WINDOW_HEIGHT) / 2;
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Assuming TopBarView and TopBarController are defined elsewhere
        TopBarView topBar = new TopBarView();
        new TopBarController(topBar, this);

        // Get all the Stuents
        getAllStudents();
        StudentTableModel model = new StudentTableModel(students);
        studenTable = new JTable(model);

        add(topBar, BorderLayout.NORTH);
        add(new JScrollPane(studenTable), BorderLayout.CENTER);
        setVisible(true);
    }

    public void getAllStudents() {
        Database d = new Database();
        try {
            ResultSet r = d.select(
                    "SELECT username, name, address, phone_number, gender, faculty FROM student",
                    new HashMap<>());
            while (r.next()) {
                String username = r.getString("username");
                String name = r.getString("name");
                String address = r.getString("address");
                long phoneNumber = r.getLong("phone_number");
                String gender = r.getString("gender");
                int faculty = r.getInt("faculty");
                students.add(new Student(username, name, address, phoneNumber, Gender.fromString(gender),
                        Faculty.fromInt(faculty)));

                // System.out.println(
                // username + "\n" +
                // name + "\n" +
                // address + "\n" +
                // phoneNumber + "\n" +
                // faculty + "\n" +
                // gender + "\n");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public JFrame getFrame() {
        return this;
    }
}
