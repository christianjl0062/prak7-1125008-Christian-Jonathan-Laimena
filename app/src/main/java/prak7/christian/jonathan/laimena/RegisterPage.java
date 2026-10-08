package prak7.christian.jonathan.laimena;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class RegisterPage extends JPanel {
    public RegisterPage(CardLayout cardLayout, JPanel mainPanel, ArrayList<User> userList) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel labelUsername = new JLabel("Username Baru:");
        JTextField txtUsername = new JTextField(15);
        JLabel labelPassword = new JLabel("Password Baru:");
        JPasswordField txtPassword = new JPasswordField(15);

        JButton btnRegister = new JButton("Register");
        JButton btnGoToLogin = new JButton("Ke Login");

        formPanel.add(labelUsername);
        formPanel.add(txtUsername);
        formPanel.add(labelPassword);
        formPanel.add(txtPassword);
        formPanel.add(btnRegister);
        formPanel.add(btnGoToLogin);

        add(formPanel);

        // Event Handling (Referensi = dari cheatsheet)
        btnGoToLogin.addActionListener(e -> cardLayout.show(mainPanel, "Login"));

        // Proses Registernya (referensi: dari cheatsheet)
        btnRegister.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username dan Password wajib diisi!", "Error", JOptionPane.ERROR_MESSAGE); //[cite: 2]
                return;
            }

            boolean isUsernameExist = false;
            for (User u : userList) {
                if (u.getUsername().equalsIgnoreCase(username)) {
                    isUsernameExist = true;
                    break;
                }
            }

            if (isUsernameExist) {
                JOptionPane.showMessageDialog(this, "Username sudah digunakan!", "Warning", JOptionPane.WARNING_MESSAGE); //[cite: 2]
            } else {
                userList.add(new User(username, password)); // Simpan ke array of user di memory
                JOptionPane.showMessageDialog(this, "Registrasi Berhasil! Silakan Login.", 
                "Info", JOptionPane.INFORMATION_MESSAGE); //[cite: 2]
                
                txtUsername.setText("");
                txtPassword.setText("");
                cardLayout.show(mainPanel, "Login"); // Otomatis pindah ke login
            }
        });
    }
}
