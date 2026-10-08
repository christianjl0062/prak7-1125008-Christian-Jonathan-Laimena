package prak7.christian.jonathan.laimena;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class LoginPage extends JPanel {
    public LoginPage(CardLayout cardLayout, JPanel mainPanel, ArrayList<User> userList, 
        HelloPage helloPage) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel labelUsername = new JLabel("Username:");
        JTextField txtUsername = new JTextField(15); // lebar: 15 karakter (sesuai cheatsheet)
        JLabel labelPassword = new JLabel("Password:");
        JPasswordField txtPassword = new JPasswordField(15);

        JButton btnLogin = new JButton("Login");
        JButton btnGoToRegister = new JButton("Register");

        formPanel.add(labelUsername);
        formPanel.add(txtUsername);
        formPanel.add(labelPassword);
        formPanel.add(txtPassword);
        formPanel.add(btnLogin);
        formPanel.add(btnGoToRegister);
        add(formPanel);
        
        // Event handling untuk Login user (sumber diambil dari cheatsheet JSwing)
        btnGoToRegister.addActionListener(e -> cardLayout.show(mainPanel, "Register"));
        
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();

            boolean isSuccess = false;
            for (User u : userList) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    isSuccess = true;
                    break;
                }
            }

            if (isSuccess) {
                helloPage.setWelcomeText(username);
                txtUsername.setText("");
                txtPassword.setText("");
                cardLayout.show(mainPanel, "Hello"); 
            } else {
                JOptionPane.showMessageDialog(this, "Username atau Password salah!", 
                "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
