package View;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.Controller.TopBarController;
import Components.View.ComboBoxComponent;
import Components.View.PasswordComponent;
import Components.View.RadioComponent;
import Components.View.TextComponent;
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

        private JLabel loginLabel;

        private TextComponent usernameComponent;
        private PasswordComponent passwordComponent;
        private TextComponent nameComponent;
        private TextComponent addressComponent;
        private TextComponent phoneComponent;
        private ComboBoxComponent<Faculty> facultyComponent;
        private RadioComponent genderComponent;
        private JButton signUpBtn;
        private JButton cancelBtn;

        public SignUpView() {
                setTitle("Sign Up");
                // setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
                // center the frame
                int x = (DISPLAY_WIDTH - WINDOW_WIDTH) / 2;
                int y = (DISPLAY_HEIGHT - WINDOW_HEIGHT) / 2;
                setLocation(x, y);

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

                // Assuming TopBarView and TopBarController are defined elsewhere
                TopBarView topBar = new TopBarView();
                new TopBarController(topBar, this);

                usernameComponent = new TextComponent("Username:");
                passwordComponent = new PasswordComponent("Password:");
                nameComponent = new TextComponent("Name:");
                addressComponent = new TextComponent("Address:");
                phoneComponent = new TextComponent("Phone Number:");
                facultyComponent = new ComboBoxComponent<>("Faculty", Faculty.values());
                genderComponent = new RadioComponent("Gender:", Gender.getAllValues());
                genderComponent.setSelectedBtnText(Gender.MALE.getValue());

                JPanel btnP = new JPanel();
                btnP.setLayout(new FlowLayout(FlowLayout.CENTER));
                signUpBtn = new JButton("Sign Up");
                cancelBtn = new JButton("Cancel");
                btnP.add(signUpBtn);
                btnP.add(cancelBtn);

                Panel loginP = new Panel(new FlowLayout(FlowLayout.LEADING));
                loginP.add(new JLabel("Already have an account?"));
                loginLabel = new JLabel("Login");
                loginP.add(loginLabel);

                // Set GroupLayout as the layout manager for the frame's content pane
                add(topBar);
                add(usernameComponent);
                add(passwordComponent);
                add(nameComponent);
                add(addressComponent);
                add(phoneComponent);
                add(facultyComponent);
                add(genderComponent);
                add(btnP);
                add(loginP);

                setVisible(true);
                pack();
                // System.out.println(getWidth());
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
                return usernameComponent.getText().trim();
        }

        public String getPassword() {
                return passwordComponent.getPassword();
        }

        public String getName() {
                return nameComponent.getText();
        }

        public String getAddress() {
                return addressComponent.getText().trim();
        }

        public long getPhoneNumber() {
                Long num;
                try {
                        num = phoneComponent.getText().trim().isEmpty()
                                        ? 0
                                        : Long.parseLong(phoneComponent.getText().trim());

                } catch (NumberFormatException e) {
                        num = -1L;
                }
                return num;
        }

        public String getGender() {
                return genderComponent.getSelectedBtnText();
        }

        public Faculty getFaculty() {
                return facultyComponent.getSelectedItem();
        }

        public JLabel getLoginBtn() {
                return loginLabel;
        }

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
