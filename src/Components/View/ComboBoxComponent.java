package Components.View;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxComponent<T> extends JPanel {
    private JLabel label;
    private JComboBox<T> comboBox;

    public ComboBoxComponent(String label, T[] items) {
        this.label = new JLabel(label);
        comboBox = new JComboBox<>(items);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(this.label);
        add(comboBox);
    }

    public ComboBoxComponent(String label, T[] items, T selectedItem) {
        this(label, items);
        comboBox.setSelectedItem(selectedItem);
    }

    public JLabel getLabel() {
        return label;
    }

    public JComboBox<T> getComboBox() {
        return comboBox;
    }

    public T getSelectedItem() {
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }

    public void setText(T selectedItem) {
        comboBox.setSelectedItem(selectedItem);
    }

}
