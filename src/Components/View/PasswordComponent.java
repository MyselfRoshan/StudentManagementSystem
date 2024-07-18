package Components.View;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PasswordComponent extends JPanel {
    private JLabel label;
    private JPasswordField passwordField;

    public PasswordComponent(String label, int columns) {
        this.label = new JLabel(label);
        passwordField = new JPasswordField(columns);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(this.label);
        add(passwordField);
    }

    public PasswordComponent(String label) {
        this(label, 30);
    }

    public JLabel getLabel() {
        return label;
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setPassword(String text) {
        passwordField.setText(text);
    }
}
