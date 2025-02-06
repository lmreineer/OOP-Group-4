/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.motorph;

import com.mycompany.motorph.employee.EmployeeInformation;
import com.mycompany.motorph.model.Employee;
import com.opencsv.exceptions.CsvValidationException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * A class that represents the Employee Search Page of the application.
 * <p>
 * It allows users to select a specific employee based on their employee number.
 * Implements the EmployeeInformationManager interface.
 *
 * @author Lance
 */
class EmployeeSearchPage extends javax.swing.JFrame implements EmployeeInformationManager {

    // Constants for button coloring changes
    private static final java.awt.Color LIGHT_BLUE = new java.awt.Color(203, 203, 239);
    private static final java.awt.Color WHITE = new java.awt.Color(255, 255, 255);
    private static final java.awt.Color RED = new java.awt.Color(191, 47, 47);

    private boolean toggleOnButtonClicked = false;
    private int clickCount = 0;

    /**
     * Creates new EmployeeSearchPage.
     */
    public EmployeeSearchPage() {
        initComponents();
        populateEmployeeTable();
        setupTableMouseListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUpAdminAction = new javax.swing.JPopupMenu();
        btnUpdateEmployeeInformation = new javax.swing.JMenuItem();
        btnComputeSalary = new javax.swing.JMenuItem();
        btnChangeCredentials = new javax.swing.JMenuItem();
        scrollPaneMain = new javax.swing.JScrollPane();
        pnlMain = new javax.swing.JPanel();
        lblMotorPhHeader = new javax.swing.JLabel();
        lblEmployeeSearchHeader = new javax.swing.JLabel();
        lblBottomSeparator = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBasicEmployeeInformation = new javax.swing.JTable();
        tglOn = new javax.swing.JToggleButton();
        tglOff = new javax.swing.JToggleButton();
        lblEmployeeSelectionToggle = new javax.swing.JLabel();

        btnUpdateEmployeeInformation.setText("Update Emplyee Information");
        btnUpdateEmployeeInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEmployeeInformationActionPerformed(evt);
            }
        });
        PopUpAdminAction.add(btnUpdateEmployeeInformation);

        btnComputeSalary.setText("Compute Salary");
        PopUpAdminAction.add(btnComputeSalary);

        btnChangeCredentials.setText("Change Credentials");
        PopUpAdminAction.add(btnChangeCredentials);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Employee Search");
        setResizable(false);

        scrollPaneMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        lblMotorPhHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblMotorPhHeader.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblMotorPhHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMotorPhHeader.setText("MotorPH Payroll System");
        lblMotorPhHeader.setOpaque(true);

        lblEmployeeSearchHeader.setBackground(new java.awt.Color(223, 54, 54));
        lblEmployeeSearchHeader.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        lblEmployeeSearchHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeSearchHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployeeSearchHeader.setText("Employee Search");
        lblEmployeeSearchHeader.setOpaque(true);

        lblBottomSeparator.setBackground(new java.awt.Color(51, 51, 51));
        lblBottomSeparator.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        lblBottomSeparator.setForeground(new java.awt.Color(255, 255, 255));
        lblBottomSeparator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomSeparator.setOpaque(true);

        btnExit.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        btnExit.setText("Exit");
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setFocusable(false);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setFocusable(false);
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblBasicEmployeeInformation.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        tblBasicEmployeeInformation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Number", "Last Name", "First Name", "SSS #", "PhilHealth #", "TIN", "Pag-IBIG #"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBasicEmployeeInformation.setEnabled(false);
        tblBasicEmployeeInformation.setFocusable(false);
        tblBasicEmployeeInformation.setRowHeight(24);
        tblBasicEmployeeInformation.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBasicEmployeeInformation);
        if (tblBasicEmployeeInformation.getColumnModel().getColumnCount() > 0) {
            tblBasicEmployeeInformation.getColumnModel().getColumn(0).setResizable(false);
            tblBasicEmployeeInformation.getColumnModel().getColumn(1).setResizable(false);
            tblBasicEmployeeInformation.getColumnModel().getColumn(3).setResizable(false);
            tblBasicEmployeeInformation.getColumnModel().getColumn(4).setResizable(false);
            tblBasicEmployeeInformation.getColumnModel().getColumn(5).setResizable(false);
        }

        tglOn.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        tglOn.setText("On");
        tglOn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tglOn.setFocusable(false);
        tglOn.setMaximumSize(new java.awt.Dimension(105, 17));
        tglOn.setMinimumSize(new java.awt.Dimension(105, 17));
        tglOn.setPreferredSize(new java.awt.Dimension(105, 17));
        tglOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tglOnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tglOnMouseExited(evt);
            }
        });
        tglOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglOnActionPerformed(evt);
            }
        });

        tglOff.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        tglOff.setText("Off");
        tglOff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tglOff.setFocusable(false);
        tglOff.setMaximumSize(new java.awt.Dimension(105, 17));
        tglOff.setMinimumSize(new java.awt.Dimension(105, 17));
        tglOff.setPreferredSize(new java.awt.Dimension(105, 17));
        tglOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tglOffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tglOffMouseExited(evt);
            }
        });
        tglOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglOffActionPerformed(evt);
            }
        });

        lblEmployeeSelectionToggle.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        lblEmployeeSelectionToggle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployeeSelectionToggle.setText("Employee Selection Toggle");
        lblEmployeeSelectionToggle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBottomSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEmployeeSearchHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblMotorPhHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1)
                .addGap(12, 12, 12))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmployeeSelectionToggle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(tglOn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tglOff, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblMotorPhHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lblEmployeeSearchHeader)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblEmployeeSelectionToggle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tglOff, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglOn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(lblBottomSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        scrollPaneMain.setViewportView(pnlMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void setupTableMouseListener() {
    // Add mouse listener to handle table row clicks
    tblBasicEmployeeInformation.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int rowIndex = tblBasicEmployeeInformation.getSelectedRow();
            // If a row is selected and toggle button is on
            if (rowIndex != -1 && toggleOnButtonClicked) {
                // Show employee information

                // Show the popup menu at the mouse location
                showPopupMenu(e);
            }
        }
    });
}

    /**
     * Handles the action event of the back button to close the current page.
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Close the current page
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Handles mouse hover event on the back button by changing its background
     * color.
     */
    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setBackground(LIGHT_BLUE);
    }//GEN-LAST:event_btnBackMouseEntered

    /**
     * Handles mouse exit event on the back button by resetting its background
     * color.
     */
    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setBackground(WHITE);
    }//GEN-LAST:event_btnBackMouseExited

    /**
     * Handles the action event of the exit button to exit the application.
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // Exit the application
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * Handles mouse hover event on the exit button by changing its background
     * color.
     */
    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(RED);
    }//GEN-LAST:event_btnExitMouseEntered

    /**
     * Handles mouse exit event on the exit button by resetting its background
     * color.
     */
    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(WHITE);
    }//GEN-LAST:event_btnExitMouseExited

    /**
     * Handles the action event of the "Toggle On" button to handle its clicks.
     */
    private void tglOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglOnActionPerformed
        handleToggleOn();
    }//GEN-LAST:event_tglOnActionPerformed

    /**
     * Handles the action event of the "Toggle Off" button to handle its clicks.
     */
    private void tglOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglOffActionPerformed
        handleToggleOff();
    }//GEN-LAST:event_tglOffActionPerformed

    /**
     * Handles mouse hover event on the "Toggle On" button by changing its
     * background color.
     */
    private void tglOnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tglOnMouseEntered
        tglOn.setBackground(LIGHT_BLUE);
    }//GEN-LAST:event_tglOnMouseEntered

    /**
     * Handles mouse exit event on the "Toggle On" button by resetting its
     * background color.
     */
    private void tglOnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tglOnMouseExited
        tglOn.setBackground(WHITE);
    }//GEN-LAST:event_tglOnMouseExited

    /**
     * Handles mouse hover event on the "Toggle Off" button by changing its
     * background color.
     */
    private void tglOffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tglOffMouseEntered
        tglOff.setBackground(LIGHT_BLUE);
    }//GEN-LAST:event_tglOffMouseEntered

    /**
     * Handles mouse exit event on the "Toggle Off" button by resetting its
     * background color.
     */
    private void tglOffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tglOffMouseExited
        tglOff.setBackground(WHITE);
    }//GEN-LAST:event_tglOffMouseExited

    private void btnUpdateEmployeeInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEmployeeInformationActionPerformed
        // TODO add your handling code here:
           // Get the selected row index from the table
    int rowIndex = tblBasicEmployeeInformation.getSelectedRow();

    // Check if a valid row is selected (rowIndex will be -1 if no row is selected)
    if (rowIndex != -1) {
        // Pass the row index to the showEmployeeInformation method
        showEmployeeInformation(rowIndex);
    } else {
        // Optionally show an error message if no row is selected
        JOptionPane.showMessageDialog(this, "Please select an employee row first.", "Error", JOptionPane.ERROR_MESSAGE);
    }

        
    }//GEN-LAST:event_btnUpdateEmployeeInformationActionPerformed
private void showPopupMenu(MouseEvent e) {
    // If you already have a popup menu, just show it at the mouse location
    PopUpAdminAction.show(tblBasicEmployeeInformation, e.getX(), e.getY());
}
    /**
     * Displays an error dialog with the provided error message.
     *
     * @param errorMessage The error message to display in the dialog.
     */
    @Override
    public void showErrorDialog(String errorMessage) {
        // Show a dialog with the error message
        JOptionPane.showMessageDialog(pnlMain, "Error updating employee information: " + errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Handles the action event of the toggle on button to enable selection of
     * employee and show its information.
     */
    private void handleToggleOn() {
        // Increment the click count
        toggleOnButtonClicked = true;
        updateToggleState();
    }
    private void updateToggleState() {
        tblBasicEmployeeInformation.setEnabled(toggleOnButtonClicked);
        tglOn.setSelected(toggleOnButtonClicked);
        tglOff.setSelected(!toggleOnButtonClicked);
    }
    /**
     * Handles the action event of the toggle off button to disable selection of
     * employee and reset toggle state.
     */
    private void handleToggleOff() {
           toggleOnButtonClicked = false;
           updateToggleState();
    }

    /**
     * Populates the employee table with all employees' basic information.
     * Populates employee table based on the provided employee number. Gets data
     * from the EmployeeInformation class and fills the appropriate rows.
     */
    private void populateEmployeeTable() {
        try {
            // Get employee data
            EmployeeInformation employeeInformation = new EmployeeInformation();
            List<Employee> employees = employeeInformation.getAllEmployees();

            // Populate table with employee data
            DefaultTableModel model = (DefaultTableModel) tblBasicEmployeeInformation.getModel();
            for (Employee employee : employees) {
                model.addRow(new Object[]{
                    employee.getEmployeeNumber(),
                    employee.getLastName(),
                    employee.getFirstName(),
                    employee.getSssNumber(),
                    employee.getPhilHealthNumber(),
                    employee.getTin(),
                    employee.getPagIbigNumber()
                });
            }
        } catch (IOException | ParseException | CsvValidationException e) {
            showErrorDialog(e.getMessage());
        }
    }

    /**
     * Displays employee information in a new frame.
     *
     * @param rowIndex The index of the selected row in the table
     */
    private void showEmployeeInformation(int rowIndex) {
        try {
            // Get selected employee's information
            DefaultTableModel model = (DefaultTableModel) tblBasicEmployeeInformation.getModel();

            int employeeNumber = (int) model.getValueAt(rowIndex, 0);

            EmployeeInformation employeeInformation = new EmployeeInformation();

            List<String> employeeDetails = employeeInformation.showEmployeeInformation(employeeNumber);

            // Display information in a new frame
            new EmployeeInformationFrame(employeeDetails).setVisible(true);
        } catch (IOException | ParseException | CsvValidationException e) {
            // Show error dialog with the exception message
            showErrorDialog(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For information see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeSearchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeSearchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeSearchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeSearchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeSearchPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu PopUpAdminAction;
    private javax.swing.JButton btnBack;
    private javax.swing.JMenuItem btnChangeCredentials;
    private javax.swing.JMenuItem btnComputeSalary;
    private javax.swing.JButton btnExit;
    private javax.swing.JMenuItem btnUpdateEmployeeInformation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBottomSeparator;
    private javax.swing.JLabel lblEmployeeSearchHeader;
    private javax.swing.JLabel lblEmployeeSelectionToggle;
    private javax.swing.JLabel lblMotorPhHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JScrollPane scrollPaneMain;
    private javax.swing.JTable tblBasicEmployeeInformation;
    private javax.swing.JToggleButton tglOff;
    private javax.swing.JToggleButton tglOn;
    // End of variables declaration//GEN-END:variables

}
