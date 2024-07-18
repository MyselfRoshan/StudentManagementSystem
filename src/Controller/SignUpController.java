package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.JOptionPane;

import Model.LoginModel;
import Model.SignUpModel;
import Model.Student;
import Utils.Database;
import View.LoginView;
import View.SignUpView;

public class SignUpController {
    private SignUpView view;
    private SignUpModel model;

    public SignUpController(SignUpView view, SignUpModel model) {
        this.view = view;
        this.model = model;

        view.getSignUpBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = view.getStudent();
                // System.out.println(
                // s.getUsername() + "\n" +
                // s.getPassword() + "\n" +
                // s.getName() + "\n" +
                // s.getAddress() + "\n" +
                // s.getPhoneNumber() + "\n" +
                // s.getFaculty() + "\n" +
                // s.getGender() + "\n");

                try {
                    if (isValidForm(view, s)) {
                        (new Database())
                                .insert("INSERT INTO student(username, password, name, address, phone_number, faculty, gender) VALUES(?, ?, ?, ?, ?, ?, ?)",
                                        Map.of(
                                                1, s.getUsername(),
                                                2, s.getPassword(),
                                                3, s.getName(),
                                                4, s.getAddress(),
                                                5, s.getPhoneNumber(),
                                                7, s.getGender().getValue(),
                                                6, s.getFaculty().getValue()));
                    }
                } catch (SQLException err) {
                    System.out.println("Error while inserting students: " + err);
                }
            }
        });

        view.getLoginBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.getFrame().dispose();
                new LoginController(new LoginView(), new LoginModel());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                view.getLoginBtn().setText("<html><u>Login</u></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                view.getLoginBtn().setText("Login");
            }
        });
    }

    // Student SignUp Validation
    private static boolean isValidNumber(long phoneNumber) {
        return phoneNumber >= 9_000_000_000L && phoneNumber <= 9_999_999_999L;
    }

    private static boolean isValidName(String name) {
        String n = name.trim();
        return n.matches("^[A-Za-z ]+$");
    }

    private static boolean isValidUsername(String username) {
        String u = username.trim();
        return u.matches("^[A-Za-z]+[0-9]*$");
    }

    private static boolean usernameExists(String username) {
        boolean exists = false;
        try {
            ResultSet rs = (new Database()).select("SELECT username FROM Student WHERE username = ?",
                    Map.of(1, username));
            exists = rs.next();
        } catch (SQLException e) {
            System.err.println("Error while checking for duplicate username: " + e);
            return true;
        }
        return exists;
    }

    private static boolean phoneNumberExists(long phoneNumber) {
        boolean exists = false;
        try {
            ResultSet rs = (new Database()).select("SELECT phone_number FROM Student WHERE phone_number = ?",
                    Map.of(1, phoneNumber));
            exists = rs.next();
        } catch (SQLException e) {
            System.err.println("Error while checking for duplicate phonenumber: " + e);
            return true;
        }
        return exists;
    }

    public boolean isValidForm(SignUpView v, Student s) {
        StringBuilder errMsg = new StringBuilder();
        if (s.getUsername().isEmpty())
            errMsg.append("Username should not be empty\n");
        else if (!isValidUsername(s.getUsername()))
            errMsg.append("Username must be alphanumeric\n");
        else if (usernameExists(s.getUsername()))
            errMsg.append("Username already exists\n");

        if (s.getPassword().isEmpty())
            errMsg.append("Password not be empty\n");

        if (s.getName().isEmpty())
            errMsg.append("Name should not be empty\n");
        else if (!isValidName(s.getName()))
            errMsg.append("Name must contain only letters and spaces.\n");

        if (s.getAddress().isEmpty())
            errMsg.append("Address not be empty\n");

        if (s.getPhoneNumber() == 0)
            errMsg.append("Phone number should not be empty\n");
        else if (!isValidNumber(s.getPhoneNumber()))
            errMsg.append("Phone number should be 10 digit long\n");
        else if (phoneNumberExists(s.getPhoneNumber()))
            errMsg.append("Phone number already exists\n");

        if (!errMsg.isEmpty()) {
            showError(errMsg.toString());
        }

        return errMsg.isEmpty();
    }

    public void showError(String msg) {
        JOptionPane.showMessageDialog(view,
                msg,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
