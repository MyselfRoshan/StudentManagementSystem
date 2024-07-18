package Components.View;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioComponent extends JPanel {
    private JLabel label;
    private ButtonGroup buttonGroup;
    private List<JRadioButton> radioButtons;

    public RadioComponent(String label, String[] buttonLabels) {
        this.label = new JLabel(label);
        buttonGroup = new ButtonGroup();
        radioButtons = new ArrayList<>();

        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Add label to the panel
        add(this.label);

        // Create and add radio buttons to the panel and button group
        for (String buttonLabel : buttonLabels) {
            JRadioButton radioButton = new JRadioButton(buttonLabel);
            radioButtons.add(radioButton);
            buttonGroup.add(radioButton);
            add(radioButton);
        }

        // Select the first radio button by default
        if (!radioButtons.isEmpty()) {
            radioButtons.get(0).setSelected(true);
        }
    }

    public JLabel getLabel() {
        return label;
    }

    public String getSelectedBtnText() {
        for (JRadioButton radioButton : radioButtons) {
            if (radioButton.isSelected()) {
                return radioButton.getText();
            }
        }
        return null;
    }

    public void setSelectedBtnText(String item) {
        for (JRadioButton radioButton : radioButtons) {
            if (radioButton.getText().equals(item)) {
                radioButton.setSelected(true);
                return;
            }
        }
    }
}
