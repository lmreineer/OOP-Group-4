/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.motorph;

/**
 * A class that represents the Manage Leave Menu in the application.
 * <p>
 * It allows users to navigate to either the leave application page or the leave
 * balance page.
 *
 * @author Lance
 */
class ManageLeaveMenu extends javax.swing.JFrame {

    // Constants for button coloring changes
    private static final java.awt.Color LIGHT_BLUE = new java.awt.Color(203, 203, 239);
    private static final java.awt.Color WHITE = new java.awt.Color(255, 255, 255);
    private static final java.awt.Color RED = new java.awt.Color(191, 47, 47);

    /**
     * Creates new form ManageLeavePage
     */
    public ManageLeaveMenu() {
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
        lblMotorPhHeader = new javax.swing.JLabel();
        lblLeaveManagementMenuHeader = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLeaveApplication = new javax.swing.JButton();
        btnLeaveBalance = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Leave Management Menu");

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        lblMotorPhHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblMotorPhHeader.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblMotorPhHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMotorPhHeader.setText("MotorPH Payroll System");
        lblMotorPhHeader.setOpaque(true);

        lblLeaveManagementMenuHeader.setBackground(new java.awt.Color(223, 54, 54));
        lblLeaveManagementMenuHeader.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        lblLeaveManagementMenuHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblLeaveManagementMenuHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLeaveManagementMenuHeader.setText("Leave Management Menu");
        lblLeaveManagementMenuHeader.setOpaque(true);

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
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

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
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

        btnLeaveApplication.setBackground(new java.awt.Color(255, 255, 255));
        btnLeaveApplication.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        btnLeaveApplication.setText("Leave Application");
        btnLeaveApplication.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnLeaveApplication.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLeaveApplication.setFocusable(false);
        btnLeaveApplication.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLeaveApplicationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLeaveApplicationMouseExited(evt);
            }
        });
        btnLeaveApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveApplicationActionPerformed(evt);
            }
        });

        btnLeaveBalance.setBackground(new java.awt.Color(255, 255, 255));
        btnLeaveBalance.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        btnLeaveBalance.setText("Leave Balance");
        btnLeaveBalance.setToolTipText("");
        btnLeaveBalance.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnLeaveBalance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLeaveBalance.setFocusable(false);
        btnLeaveBalance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLeaveBalanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLeaveBalanceMouseExited(evt);
            }
        });
        btnLeaveBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveBalanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMotorPhHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblLeaveManagementMenuHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLeaveApplication, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLeaveBalance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMotorPhHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLeaveManagementMenuHeader)
                .addGap(15, 15, 15)
                .addComponent(btnLeaveApplication, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btnLeaveBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Handles the action event of the leave application button to open the
     * leave application page.
     */
    private void btnLeaveApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveApplicationActionPerformed
        // Open LeaveApplicationPage
        new LeaveApplicationPage().setVisible(true);
    }//GEN-LAST:event_btnLeaveApplicationActionPerformed

    /**
     * Handles the action event of the leave balance button to open the leave
     * balance page.
     */
    private void btnLeaveBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveBalanceActionPerformed
        // Open LeaveBalancePage
        new LeaveBalancePage().setVisible(true);
    }//GEN-LAST:event_btnLeaveBalanceActionPerformed

    /**
     * Handles mouse hover event on the leave application button by changing its
     * background color.
     */
    private void btnLeaveApplicationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLeaveApplicationMouseEntered
        btnLeaveApplication.setBackground(LIGHT_BLUE);
    }//GEN-LAST:event_btnLeaveApplicationMouseEntered

    /**
     * Handles mouse exit event on the leave application button by resetting its
     * background color.
     */
    private void btnLeaveApplicationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLeaveApplicationMouseExited
        btnLeaveApplication.setBackground(WHITE);
    }//GEN-LAST:event_btnLeaveApplicationMouseExited

    /**
     * Handles mouse hover event on the leave balance button by changing its
     * background color.
     */
    private void btnLeaveBalanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLeaveBalanceMouseEntered
        btnLeaveBalance.setBackground(LIGHT_BLUE);
    }//GEN-LAST:event_btnLeaveBalanceMouseEntered

    /**
     * Handles mouse exit event on the leave balance button by resetting its
     * background color.
     */
    private void btnLeaveBalanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLeaveBalanceMouseExited
        btnLeaveBalance.setBackground(WHITE);
    }//GEN-LAST:event_btnLeaveBalanceMouseExited

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLeaveApplication;
    private javax.swing.JButton btnLeaveBalance;
    private javax.swing.JLabel lblLeaveManagementMenuHeader;
    private javax.swing.JLabel lblMotorPhHeader;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
