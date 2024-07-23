package View;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.Controller.TopBarController;
import Components.View.PasswordComponent;
import Components.View.RadioComponent;
import Components.View.TextComponent;
import Components.View.TopBarView;
import Enums.Role;
import Interface.View;

public class LoginView extends JFrame implements View {
    public static final int DISPLAY_WIDTH = 1920;
    public static final int DISPLAY_HIGHT = 1024;
    public static final int WINDOW_WIDTH = 489;
    public static final int WINDOW_HIGHT = 400;

    private TextComponent usernameComponent;
    private PasswordComponent passwordComponent;
    private RadioComponent roleComponent;
    private JButton loginBtn;
    private JButton cancelBtn;
    private JLabel signUpLabel;

    public LoginView() {
        setTitle("Login");
        // setSize(WINDOW_WIDTH, WINDOW_HIGHT);
        // center the frame
        int x = (DISPLAY_WIDTH - WINDOW_WIDTH) / 2;
        int y = (DISPLAY_HIGHT - WINDOW_HIGHT) / 2;
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        /* Get all the fonts of the system */
        // GraphicsEnvironment ge = GraphicsEnvironment
        // .getLocalGraphicsEnvironment();

        // Font[] allFonts = ge.getAllFonts();

        // for (Font font : allFonts) {
        // System.out.println(font.getFontName(Locale.US));
        // }

        TopBarView topBar = new TopBarView();
        new TopBarController(topBar, this);

        JPanel inputP = new JPanel();
        inputP.setLayout(new BoxLayout(inputP, BoxLayout.Y_AXIS));
        usernameComponent = new TextComponent("Username:");
        passwordComponent = new PasswordComponent("Password:");
        inputP.add(usernameComponent);
        inputP.add(passwordComponent);

        roleComponent = new RadioComponent("Role:", Role.getStringValues());
        roleComponent.setSelectedBtnText(Role.ADMIN.name());

        JPanel btnP = new JPanel();
        btnP.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginBtn = new JButton("Login");
        cancelBtn = new JButton("Cancel");
        btnP.add(loginBtn);
        btnP.add(cancelBtn);

        JPanel signUpP = new JPanel();
        signUpP.setLayout(new FlowLayout(FlowLayout.CENTER));
        signUpP.add(new JLabel("Don't have an account?"));
        signUpLabel = new JLabel("Sign Up");
        signUpP.add(signUpLabel);

        add(topBar);
        add(inputP);
        add(roleComponent);
        add(btnP);
        add(signUpP);
        setVisible(true);
        pack();
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
        return usernameComponent.getText();
    }

    public String getPassword() {
        return passwordComponent.getPassword();
    }

    public void setUsername(String u) {
        usernameComponent.setText(u);
    }

    public void setPassword(String p) {
        passwordComponent.setPassword(p);
    }

    public JLabel getSignUpBtn() {
        return signUpLabel;
    }

    public JFrame getFrame() {
        return this;
    }
}
