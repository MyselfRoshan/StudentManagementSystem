package Components.Controller;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Components.View.TopBarView;
import Interface.View;

public class TopBarController {
    public TopBarView topBarView;

    public TopBarController(TopBarView topBarView, View window) {
        this.topBarView = topBarView;

        topBarView.getCloseBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.getFrame().dispose();
                System.exit(0);
            }
        });

        topBarView.getMinMaxBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                if (device.getFullScreenWindow() == window) {
                    device.setFullScreenWindow(null);
                    topBarView.getMinMaxBtn().setText("󰖯");
                } else {
                    topBarView.getMinMaxBtn().setText("󰖰");
                    device.setFullScreenWindow(window.getFrame());
                }
            }
        });
    }

    // public static TopBarView getTopBar(TopBarView topBarView, View window) {
    // return (new TopBarController(topBarView, window)).topBarView;
    // }
}
