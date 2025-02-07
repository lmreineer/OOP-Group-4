/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.motorph;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * A class that provides the login functionality in the application.
 *
 * @author Lance
 */
public class LoginPage extends javax.swing.JFrame implements EmployeeInformationManager {

    // Constants for button coloring changes
    private static final java.awt.Color LIGHT_BLUE = new java.awt.Color(203, 203, 239);
    private static final java.awt.Color WHITE = new java.awt.Color(255, 255, 255);

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblWelcomeHeader = new javax.swing.JLabel();
        lblLoginHeader = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        chkShowPassword = new javax.swing.JCheckBox();
        txtPassword = new javax.swing.JPasswordField();
        lblUserType = new javax.swing.JLabel();
        cmbUserType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        lblWelcomeHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblWelcomeHeader.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblWelcomeHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcomeHeader.setText("Welcome!");
        lblWelcomeHeader.setOpaque(true);

        lblLoginHeader.setBackground(new java.awt.Color(223, 54, 54));
        lblLoginHeader.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        lblLoginHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginHeader.setText("Login");
        lblLoginHeader.setOpaque(true);

        btnLogin.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusable(false);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblUsername.setBackground(new java.awt.Color(255, 255, 255));
        lblUsername.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("Username:");
        lblUsername.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblUsername.setMaximumSize(new java.awt.Dimension(93, 25));
        lblUsername.setMinimumSize(new java.awt.Dimension(93, 25));
        lblUsername.setOpaque(true);

        lblPassword.setBackground(new java.awt.Color(255, 255, 255));
        lblPassword.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("Password:");
        lblPassword.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPassword.setMaximumSize(new java.awt.Dimension(93, 25));
        lblPassword.setMinimumSize(new java.awt.Dimension(93, 25));
        lblPassword.setOpaque(true);

        txtUsername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        chkShowPassword.setBackground(new java.awt.Color(255, 255, 255));
        chkShowPassword.setText("Show password");
        chkShowPassword.setFocusable(false);
        chkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });

        txtPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        lblUserType.setBackground(new java.awt.Color(255, 255, 255));
        lblUserType.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblUserType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserType.setText("Select User Type:");
        lblUserType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblUserType.setMaximumSize(new java.awt.Dimension(93, 25));
        lblUserType.setMinimumSize(new java.awt.Dimension(93, 25));
        lblUserType.setOpaque(true);

        cmbUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "Admin", "IT" }));
        cmbUserType.setBorder(null);
        cmbUserType.setFocusable(false);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLoginHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblWelcomeHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(cmbUserType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(chkShowPassword))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcomeHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoginHeader)
                .addGap(40, 40, 40)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(chkShowPassword)
                .addGap(30, 30, 30)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Handles the action event for the "Show password" checkbox. Toggles the
     * visibility of the password.
     */
    private void chkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPasswordActionPerformed
        // If the checkbox is selected
        if (chkShowPassword.isSelected()) {
            // Show the password
            txtPassword.setEchoChar((char) 0);
        } else {
            // Else, hide the password
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_chkShowPasswordActionPerformed

    /**
     * Handles the action event for the login button. Tries to authenticate the
     * user with the provided credentials.
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            performLogin();
        } catch (Exception ex) {
            showErrorDialog(ex.getMessage());
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * Handles mouse exit event on the login button by changing its background
     * color.
     */
    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setBackground(LIGHT_BLUE);
    }//GEN-LAST:event_btnLoginMouseEntered

    /**
     * Handles mouse hover event on the login button by resetting its background
     * color.
     */
    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setBackground(WHITE);
    }//GEN-LAST:event_btnLoginMouseExited

    /**
     * Displays an error dialog with the provided error message.
     *
     * @param errorMessage The error message to display in the dialog.
     */
    @Override
    public void showErrorDialog(String errorMessage) {
        // Show a dialog with the error message
        JOptionPane.showMessageDialog(pnlMain, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Logs in the user and validates the enter username, password, and user
     * type
     */
    private void performLogin() {
        // Get the user input for username, password, and selected user type
        String enteredUsername = txtUsername.getText().trim();
        String enteredPassword = new String(txtPassword.getPassword()).trim();
        String selectedUserType = cmbUserType.getSelectedItem().toString();

        boolean loginSuccessful = false;

        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/data/login_credentials.csv"))) {
            // Skip header
            String[] header = reader.readNext();

            String[] record;

            // Loop through each record in the CSV file.
            while ((record = reader.readNext()) != null) {
                // The columns in CSV are: 0 - Username, 1 - Password, 2 - User Type
                String csvUsername = record[0].trim();
                String csvPassword = record[1].trim();
                String csvUserType = record[2].trim();

                // If the entered credentials and user type match with the data from CSV file
                if (enteredUsername.equals(csvUsername)
                        && enteredPassword.equals(csvPassword)
                        && selectedUserType.equalsIgnoreCase(csvUserType)) {
                    loginSuccessful = true;
                    break;
                }
            }
        } catch (IOException | CsvValidationException e) {
            // If an error occurs while reading the CSV file, show a message saying it
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading credentials", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // If login was successful
        if (loginSuccessful) {
            String username = enteredUsername;
            int employeeNumber = Integer.parseInt(username.substring(1));

            if (selectedUserType.equalsIgnoreCase("Employee")) {
                JOptionPane.showMessageDialog(this, "Login successful as " + selectedUserType);

                new MotorPHMainMenu(employeeNumber).setVisible(true);
            } else if (selectedUserType.equalsIgnoreCase("IT")) {
                new MotorPHMainMenu(employeeNumber).setVisible(true);
            } else if (selectedUserType.equalsIgnoreCase("Admin")) {
                new MotorPHMainMenu(employeeNumber).setVisible(true);
            }

            // Close the window
            this.dispose();
        } else {
            // Else if login failed, show an error message to the user
            JOptionPane.showMessageDialog(this, "Invalid credentials or user type", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chkShowPassword;
    private javax.swing.JComboBox<String> cmbUserType;
    private javax.swing.JLabel lblLoginHeader;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserType;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcomeHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
