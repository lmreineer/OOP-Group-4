/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.ui;

import com.mycompany.motorph.security.PasswordManager;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class UpdateCredentialsPage extends JFrame {

    private JTextField txtNewUsername;
    private JPasswordField txtNewPassword;
    private JButton btnUpdate;
    private JLabel lblSelectedUser;
    private int employeeNumber;
    private String currentUsername;
    private String division;
    private static final String HASHED_FILE_PATH = "src/main/resources/data/login_credentials_hashed.csv";
    private static final String PLAIN_FILE_PATH = "src/main/resources/data/login_credentials.csv";

    public UpdateCredentialsPage(int employeeNumber, String currentUsername, String division) {
        this.employeeNumber = employeeNumber;
        this.currentUsername = currentUsername;
        this.division = division;
        initComponents();
    }

    private void initComponents() {
        setTitle("Update Employee Credentials (IT Only)");
        setSize(350, 250);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblSelectedUser = new JLabel("Selected User: " + currentUsername);
        JLabel lblUsername = new JLabel("New Username:");
        JLabel lblPassword = new JLabel("New Password:");
        txtNewUsername = new JTextField(currentUsername);
        txtNewPassword = new JPasswordField();
        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(e -> updateCredentials());

        add(lblSelectedUser);
        add(new JLabel()); // Empty placeholder
        add(lblUsername);
        add(txtNewUsername);
        add(lblPassword);
        add(txtNewPassword);
        add(new JLabel()); // Empty placeholder
        add(btnUpdate);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateCredentials() {
        String newUsername = txtNewUsername.getText().trim();
        String newPassword = new String(txtNewPassword.getPassword()).trim();

        if (newUsername.isEmpty() || newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fields cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            List<String> hashedLines = Files.readAllLines(Paths.get(HASHED_FILE_PATH));
            List<String> plainLines = Files.readAllLines(Paths.get(PLAIN_FILE_PATH));
            List<String> updatedHashedLines = new ArrayList<>();
            List<String> updatedPlainLines = new ArrayList<>();
            boolean updated = false;
            boolean usernameTaken = false;

            for (String line : hashedLines) {
                String[] credentials = line.split(",");
                if (credentials.length == 3) {
                    String existingUsername = credentials[0];
                    if (existingUsername.equals(newUsername) && !existingUsername.equals(currentUsername)) {
                        usernameTaken = true;
                        break;
                    }
                }
            }

            if (usernameTaken) {
                JOptionPane.showMessageDialog(this, "Username is already taken!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (String line : hashedLines) {
                String[] credentials = line.split(",");
                if (credentials.length == 3 && credentials[0].equals(currentUsername)) {
                    String hashedPassword = PasswordManager.hashPassword(newPassword);
                    updatedHashedLines.add(newUsername + "," + hashedPassword + "," + division);
                    updated = true;
                } else {
                    updatedHashedLines.add(line);
                }
            }

            for (String line : plainLines) {
                String[] credentials = line.split(",");
                if (credentials.length == 3 && credentials[0].equals(currentUsername)) {
                    updatedPlainLines.add(newUsername + "," + newPassword + "," + division);
                } else {
                    updatedPlainLines.add(line);
                }
            }

            if (updated) {
                Files.write(Paths.get(HASHED_FILE_PATH), updatedHashedLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                Files.write(Paths.get(PLAIN_FILE_PATH), updatedPlainLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                JOptionPane.showMessageDialog(this, "Credentials updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error updating credentials: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
