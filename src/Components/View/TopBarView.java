package Components.View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TopBarView extends JPanel {
    private JButton minMaxBtn;
    private JButton closeBtn;

    public TopBarView() {
        // JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setSize(400, 16);
        minMaxBtn = new JButton("󰖯");
        minMaxBtn.setFont(new Font("Symbols-1000-em Nerd Font Complete", 0, 15));
        minMaxBtn.setBackground(Color.WHITE);

        closeBtn = new JButton("X");
        closeBtn.setSize(10, 10);
        closeBtn.setBackground(Color.RED);
        closeBtn.setForeground(Color.WHITE);
        add(minMaxBtn);
        add(closeBtn);
    }

    public JButton getMinMaxBtn() {
        return minMaxBtn;
    }

    public JButton getCloseBtn() {
        return closeBtn;
    }

    public JPanel getTopBar() {
        return this;
    }
}
