package Components.View;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextComponent extends JPanel {
    private JLabel label;
    private JTextField textField;

    public TextComponent(String label, int columns) {
        this.label = new JLabel(label);
        textField = new JTextField(columns);

        setLayout(new BorderLayout());

        add(this.label, BorderLayout.LINE_START);
        add(textField, BorderLayout.LINE_END);
        // setPreferredSize(new Dimension(200, 32));
    }

    public TextComponent(String label) {
        this(label, 30);
    }

    public JLabel getLabel() {
        return label;
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }
}