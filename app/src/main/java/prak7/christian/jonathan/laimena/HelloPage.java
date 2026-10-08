package prak7.christian.jonathan.laimena;

import java.awt.*;
import javax.swing.*;

public class HelloPage extends JPanel {
    private JLabel labelWelcome;

    public HelloPage(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new BorderLayout(10, 20));
        setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));
        labelWelcome = new JLabel("Hello, User!", SwingConstants.CENTER);
        labelWelcome.setFont(new Font("Arial", Font.BOLD, 18));
        JButton btnLogout = new JButton("Logout");

        add(labelWelcome, BorderLayout.CENTER);
        add(btnLogout, BorderLayout.SOUTH);

        // Logout kembali ke halaman Login
        btnLogout.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
    }

    public void setWelcomeText(String username) {
        labelWelcome.setText("Hello, " + username + "! Selamat datang!");
    }
}