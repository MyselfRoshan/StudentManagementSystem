package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.LoginModel;
import View.LoginView;

public class LoginController {
    private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;

        view.getLoginBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (view.getUsername().equals("Hello") && view.getPassword().equals("Hello")) {
                    System.out.println("Login Sucess");
                }
            }
        });

        view.getCancelBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.setUsername(null);
                view.setPassword(null);
            }
        });

    }
}
