package View;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Components.Controller.TopBarController;
import Components.View.TopBarView;
import Enums.Faculty;
import Enums.Gender;
import Interface.View;
import Model.Student;

public class SignUpView extends JFrame implements View {
        public static final int DISPLAY_WIDTH = 1920;
        public static final int DISPLAY_HEIGHT = 1024;
        public static final int WINDOW_WIDTH = 400;
        public static final int WINDOW_HEIGHT = 400;
        public static final int TEXTFIELD_COLUMNS = 30;

        private JLabel usernameLabel;
        private JLabel passwordLabel;
        private JLabel nameLabel;
        private JLabel addressLabel;
        private JLabel phoneLabel;
        private JLabel facultyLabel;
        private JLabel genderLabel;
        private JLabel loginLabel;
        // private JLabel loginLabel;

        private JTextField usernameField;
        private JPasswordField passwordField;
        private JTextField nameField;
        private JTextField addressField;
        private JTextField phoneField;
        private JComboBox<Faculty> faculty;
        private JRadioButton maleRadioBtn;
        private JRadioButton femaleRadioBtn;

        private JButton signUpBtn;
        private JButton cancelBtn;

        public SignUpView() {
                setTitle("Sign Up");
                setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
                // center the frame
                int x = (DISPLAY_WIDTH - WINDOW_WIDTH) / 2;
                int y = (DISPLAY_HEIGHT - WINDOW_HEIGHT) / 2;
                setLocation(x, y);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                usernameLabel = new JLabel("Username:");
                passwordLabel = new JLabel("Password:");
                nameLabel = new JLabel("Name:");
                addressLabel = new JLabel("Address:");
                phoneLabel = new JLabel("Phone Number:");
                facultyLabel = new JLabel("Faculty:");
                genderLabel = new JLabel("Gender:");

                Panel loginPanel = new Panel(new FlowLayout(FlowLayout.LEADING));
                loginPanel.add(new JLabel("Already have an account?"));
                loginLabel = new JLabel("Sign in");
                loginPanel.add(loginLabel);

                usernameField = new JTextField(TEXTFIELD_COLUMNS);
                passwordField = new JPasswordField(TEXTFIELD_COLUMNS);
                nameField = new JTextField(TEXTFIELD_COLUMNS);
                addressField = new JTextField(TEXTFIELD_COLUMNS);
                phoneField = new JTextField(TEXTFIELD_COLUMNS);
                faculty = new JComboBox<>(Faculty.values());
                maleRadioBtn = new JRadioButton(Gender.MALE.getValue(), true);
                femaleRadioBtn = new JRadioButton(Gender.FEMALE.getValue());
                ButtonGroup genderGroup = new ButtonGroup();
                genderGroup.add(maleRadioBtn);
                genderGroup.add(femaleRadioBtn);

                signUpBtn = new JButton("Sign Up");
                cancelBtn = new JButton("Cancel");

                // Assuming TopBarView and TopBarController are defined elsewhere
                TopBarView topBar = new TopBarView();
                new TopBarController(topBar, this);

                // Set GroupLayout as the layout manager for the frame's content pane
                Container contentPane = getContentPane();
                GroupLayout layout = new GroupLayout(contentPane);
                contentPane.setLayout(layout);
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true);

                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(topBar)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(usernameLabel)
                                                                                .addComponent(passwordLabel)
                                                                                .addComponent(nameLabel)
                                                                                .addComponent(addressLabel)
                                                                                .addComponent(phoneLabel)
                                                                                .addComponent(facultyLabel)
                                                                                .addComponent(genderLabel)
                                                                                .addComponent(signUpBtn))
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(usernameField)
                                                                                .addComponent(passwordField)
                                                                                .addComponent(nameField)
                                                                                .addComponent(addressField)
                                                                                .addComponent(phoneField)
                                                                                .addComponent(faculty)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(maleRadioBtn)
                                                                                                .addComponent(femaleRadioBtn))
                                                                                .addComponent(cancelBtn)))
                                                .addComponent(loginPanel));

                layout.setVerticalGroup(
                                layout.createSequentialGroup()
                                                .addComponent(topBar)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(usernameLabel)
                                                                .addComponent(usernameField))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(passwordLabel)
                                                                .addComponent(passwordField))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(nameLabel)
                                                                .addComponent(nameField))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(addressLabel)
                                                                .addComponent(addressField))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(phoneLabel)
                                                                .addComponent(phoneField))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(facultyLabel)
                                                                .addComponent(faculty))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(genderLabel)
                                                                .addComponent(maleRadioBtn)
                                                                .addComponent(femaleRadioBtn))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(signUpBtn)
                                                                .addComponent(cancelBtn))
                                                .addComponent(loginPanel));

                setVisible(true);
        }

        public void addComponents(Component... components) {
                for (Component component : components) {
                        add(component);
                }
        }

        public JButton getSignUpBtn() {
                return signUpBtn;
        }

        public JButton getCancelBtn() {
                return cancelBtn;
        }

        public String getUsername() {
                return usernameField.getText().trim();
        }

        public String getPassword() {
                return new String(passwordField.getPassword());
        }

        public String getName() {
                return nameField.getText().trim();
        }

        public String getAddress() {
                return addressField.getText().trim();
        }

        public long getPhoneNumber() {
                if (!phoneField.getText().trim().isEmpty()) {
                        return Long.parseLong(phoneField.getText().trim());
                }
                return 0;
        }

        public String getGender() {
                if (maleRadioBtn.isSelected()) {
                        return maleRadioBtn.getText();
                } else if (femaleRadioBtn.isSelected()) {
                        return femaleRadioBtn.getText();
                }
                return "";

        }

        public Faculty getFaculty() {
                return ((Faculty) faculty.getSelectedItem());
        }

        public JLabel getLoginBtn() {
                return loginLabel;
        }

        // public void setUsername(String u) {
        // usernameField.setText(u);
        // }

        // public void setPassword(String p) {
        // passwordField.setText(p);
        // }

        public Student getStudent() {
                return new Student(getUsername(),
                                getPassword(),
                                getName(),
                                getAddress(),
                                getPhoneNumber(),
                                Gender.fromString(getGender()),
                                getFaculty());
        }

        public JFrame getFrame() {
                return this;
        }
}
