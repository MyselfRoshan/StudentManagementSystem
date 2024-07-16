package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Components.Controller.TopBarController;
import Components.View.TopBarView;
import Interface.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

public class LoginView extends JFrame implements View {
    public static final int DISPLAY_WIDTH = 1920;
    public static final int DISPLAY_HIGHT = 1024;
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HIGHT = 400;

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton cancelBtn;

    public LoginView() {
        setTitle("Login");
        setSize(WINDOW_WIDTH, WINDOW_HIGHT);
        // center the frame
        int x = (DISPLAY_WIDTH - WINDOW_WIDTH) / 2;
        int y = (DISPLAY_HIGHT - WINDOW_HIGHT) / 2;
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        /* Get all the fonts of the system */
        // GraphicsEnvironment ge = GraphicsEnvironment
        // .getLocalGraphicsEnvironment();

        // Font[] allFonts = ge.getAllFonts();

        // for (Font font : allFonts) {
        // System.out.println(font.getFontName(Locale.US));
        // }

        // setLayout(new GridBagLayout());
        // GridBagConstraints grid = new GridBagConstraints();
        // grid.fill = GridBagConstraints.HORIZONTAL;

        usernameLabel = new JLabel("username:");
        passwordLabel = new JLabel("password:");
        usernameField = new JTextField(30);
        passwordField = new JPasswordField(30);
        loginBtn = new JButton("Login");
        cancelBtn = new JButton("Cancel");

        TopBarView topBar = new TopBarView();
        new TopBarController(topBar, this);
        add(topBar, BorderLayout.NORTH);

        JPanel p = new JPanel();
        // p.setLayout(new FlowLayout(FlowLayout.CENTER));
        p.setLayout(new FlowLayout());
        p.add(usernameLabel);
        p.add(usernameField);
        p.add(passwordLabel);
        p.add(passwordField);
        p.add(loginBtn);
        p.add(cancelBtn);

        add(p, BorderLayout.CENTER);
        // addComponents(
        // usernameLabel,
        // usernameField,
        // passwordLabel,
        // passwordField,
        // loginBtn,
        // cancelBtn);
        setVisible(true);
    }

    public void addComponents(Component... components) {
        for (Component component : components) {
            add(component);
        }
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setUsername(String u) {
        usernameField.setText(u);
    }

    public void setPassword(String p) {
        passwordField.setText(p);
    }

    public JFrame getFrame() {
        return this;
    }
}
