package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.LoginModel;
import Model.SignUpModel;
import Utils.Database;
import View.DashboardView;
import View.LoginView;
import View.SignUpView;

public class LoginController {
    private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;

        view.getLoginBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsername();
                String password = view.getPassword();

                if (loginUser(username, password)) {
                    view.getFrame().dispose();
                    new DashboardController(new DashboardView());
                } else {
                    showError("Login Failed: Invalid username or password");
                    // System.out.println("Login Failed: Invalid username or password");
                }
            }
        });

        view.getCancelBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.setUsername(null);
                view.setPassword(null);
            }
        });

        view.getSignUpBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.getFrame().dispose();
                new SignUpController(new SignUpView(), new SignUpModel());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                view.getSignUpBtn().setText("<html><u>Sign Up</u></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                view.getSignUpBtn().setText("Sign Up");
            }
        });
    }

    private boolean loginUser(String username, String password) {
        boolean isAuthenticated = false;
        Database db = new Database();

        // Query to retrieve hashed password for the given username
        String sql = "SELECT password FROM student WHERE username = ?";
        ResultSet rs = null;
        PreparedStatement statement = null;

        try {
            statement = db.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            rs = statement.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                // Verify password
                if (verifyPassword(password, storedPassword)) {
                    isAuthenticated = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error authenticating user: " + e.getMessage());
            // Proper logging or exception handling should be implemented here
        } finally {
            // Close resources properly
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            db.close(); // Close database connection
        }

        return isAuthenticated;
    }

    // Method to verify password (for simplicity, assume plain text comparison)
    private boolean verifyPassword(String providedPassword, String storedPassword) {
        // Implement secure password verification here (e.g., using bcrypt)
        return providedPassword.equals(storedPassword);
    }

    public void showError(String msg) {
        JOptionPane.showMessageDialog(view,
                msg,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
