/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.motorph;

import com.mycompany.motorph.employee.EmployeeInformation;
import com.opencsv.exceptions.CsvValidationException;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 * A class that displays the specific employee's pay information based on the
 * selected month, and his/her full information and allows updating of them.
 *
 * @author Lance
 */
class EmployeeInformationFrame extends javax.swing.JFrame implements EmployeeInformationManager {

    // Constants for button coloring changes
    private static final java.awt.Color LIGHT_BLUE = new java.awt.Color(203, 203, 239);
    private static final java.awt.Color WHITE = new java.awt.Color(255, 255, 255);
    private static final java.awt.Color RED = new java.awt.Color(191, 47, 47);
    private static final java.awt.Color GRAY = new java.awt.Color(242, 242, 242);
    
    private int employeeNumber;
    private boolean isEditing = false;

    /**
     * Creates new EmployeeInformationFrame.
     *
     * @param employeeInformation List of strings that contains initial employee
     * information.
     */
    public EmployeeInformationFrame(int employeeNumber) {
        this.employeeNumber = employeeNumber;
        initComponents();
        loadEmployeeData();
        
    }

    private void loadEmployeeData() {
         try {
            EmployeeInformation employeeInfoManager = new EmployeeInformation();
            List<String> employeeInfo = employeeInfoManager.showEmployeeInformation(employeeNumber);

            // Populate text fields with retrieved data
            updateEmployeeInformationFields(employeeInfo);
        } catch (IOException | ParseException | CsvValidationException e) {
            JOptionPane.showMessageDialog(this, "Error loading employee information: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
}
    

    private void setFieldsEditable(boolean editable) {
        System.out.println("Making fields editable: " + editable);
        txtLastName.setFocusable(true);
        txtFirstName.setFocusable(true);
        txtBirthdate.setFocusable(true);
        txtAddress.setFocusable(true);
        txtPhoneNumber.setFocusable(true);
        txtSssNumber.setFocusable(true);
        txtPhilHealthNumber.setFocusable(true);
        txtTinNumber.setFocusable(true);
        txtPagIbigNumber.setFocusable(true);
        txtStatus.setFocusable(true);
        txtPosition.setFocusable(true);
        txtImmediateSupervisor.setFocusable(true);
        txtBasicSalary.setFocusable(true);
        txtRiceSubsidy.setFocusable(true);
        txtPhoneAllowance.setFocusable(true);
        txtClothingAllowance.setFocusable(true);
        txtGrossSemimonthlyRate.setFocusable(true);
        txtHourlyRate.setFocusable(true);

        txtLastName.setEnabled(true);
        txtLastName.setEditable(editable);
        txtFirstName.setEnabled(true);
        txtFirstName.setEditable(editable);
        txtBirthdate.setEditable(editable);
        txtAddress.setEditable(editable);
        txtPhoneNumber.setEditable(editable);
        txtSssNumber.setEditable(editable);
        txtPhilHealthNumber.setEditable(editable);
        txtTinNumber.setEditable(editable);
        txtPagIbigNumber.setEditable(editable);
        txtStatus.setEditable(editable);
        txtPosition.setEditable(editable);
        txtImmediateSupervisor.setEditable(editable);
        txtBasicSalary.setEditable(editable);
        txtRiceSubsidy.setEditable(editable);
        txtPhoneAllowance.setEditable(editable);
        txtClothingAllowance.setEditable(editable);
        txtGrossSemimonthlyRate.setEditable(editable);
        txtHourlyRate.setEditable(editable);
}
private void saveEmployeeDetails() {
    try {
            int employeeNumber = Integer.parseInt(txtEmployeeNumber.getText());

            // Collect updated employee information from text fields
            List<String> updatedInfo = Arrays.asList(
                txtLastName.getText(),
                txtFirstName.getText(),
                txtBirthdate.getText(),
                txtAddress.getText(),
                txtPhoneNumber.getText(),
                txtSssNumber.getText(),
                txtPhilHealthNumber.getText(),
                txtTinNumber.getText(),
                txtPagIbigNumber.getText(),
                txtStatus.getText(),
                txtPosition.getText(),
                txtImmediateSupervisor.getText(),
                txtBasicSalary.getText(),
                txtRiceSubsidy.getText(),
                txtPhoneAllowance.getText(),
                txtClothingAllowance.getText(),
                txtGrossSemimonthlyRate.getText(),
                txtHourlyRate.getText()
            );

            // Call the method in EmployeeInformation.java to save updates
            EmployeeInformation employeeInfoManager = new EmployeeInformation();
            employeeInfoManager.updateEmployeeInformationInCsv(employeeNumber, updatedInfo);

            JOptionPane.showMessageDialog(this, "Employee information updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | ParseException | CsvValidationException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error updating employee information: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
}
    private void updateEmployeeInformationFields(List<String> employeeInfo) {
        if (employeeInfo.size() >= 18) {
            txtEmployeeNumber.setText(employeeInfo.get(0));
            txtLastName.setText(employeeInfo.get(1));
            txtFirstName.setText(employeeInfo.get(2));
            txtBirthdate.setText(employeeInfo.get(3));
            txtAddress.setText(employeeInfo.get(4));
            txtPhoneNumber.setText(employeeInfo.get(5));
            txtSssNumber.setText(employeeInfo.get(6));
            txtPhilHealthNumber.setText(employeeInfo.get(7));
            txtTinNumber.setText(employeeInfo.get(8));
            txtPagIbigNumber.setText(employeeInfo.get(9));
            txtStatus.setText(employeeInfo.get(10));
            txtPosition.setText(employeeInfo.get(11));
            txtImmediateSupervisor.setText(employeeInfo.get(12));
            txtBasicSalary.setText(employeeInfo.get(13));
            txtRiceSubsidy.setText(employeeInfo.get(14));
            txtPhoneAllowance.setText(employeeInfo.get(15));
            txtClothingAllowance.setText(employeeInfo.get(16));
            txtGrossSemimonthlyRate.setText(employeeInfo.get(17));
            txtHourlyRate.setText(employeeInfo.get(18));
        } else {
            JOptionPane.showMessageDialog(this, "Invalid employee data format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Creates a MouseAdapter for handling button hover effects.
     *
     * @param button JButton to apply hover effect
     * @param hoverColor Color when mouse hovers over the button
     * @param defaultColor Default color of the button
     * @return MouseAdapter created MouseAdapter for button hover effects
     */
    private MouseAdapter createButtonHoverAdapter(JButton button, Color hoverColor, Color defaultColor) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(defaultColor);
            }
        };
    }

  
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneMain = new javax.swing.JScrollPane();
        pnlMain = new javax.swing.JPanel();
        lblMotorPhHeader = new javax.swing.JLabel();
        lblEmployeeInformationHeader = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        lblBirthdate = new javax.swing.JLabel();
        txtBirthdate = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtSssNumber = new javax.swing.JTextField();
        lblSssNumber = new javax.swing.JLabel();
        txtPhilHealthNumber = new javax.swing.JTextField();
        lblPhilHealthNumber = new javax.swing.JLabel();
        txtTinNumber = new javax.swing.JTextField();
        lblTinNumber = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        txtPagIbigNumber = new javax.swing.JTextField();
        lblPagIbigNumber = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        lblPosition = new javax.swing.JLabel();
        txtBasicSalary = new javax.swing.JTextField();
        lblBasicSalary = new javax.swing.JLabel();
        txtPhoneAllowance = new javax.swing.JTextField();
        lblPhoneAllowance = new javax.swing.JLabel();
        txtGrossSemimonthlyRate = new javax.swing.JTextField();
        lblGrossSemimonthlyRate = new javax.swing.JLabel();
        txtImmediateSupervisor = new javax.swing.JTextField();
        lblImmediateSupervisor = new javax.swing.JLabel();
        txtRiceSubsidy = new javax.swing.JTextField();
        lblRiceSubsidy = new javax.swing.JLabel();
        txtClothingAllowance = new javax.swing.JTextField();
        lblClothingAllowance = new javax.swing.JLabel();
        txtHourlyRate = new javax.swing.JTextField();
        lblHourlyRate = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblBottomSeparator = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblEmployeeNumber = new javax.swing.JLabel();
        txtEmployeeNumber = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnBack2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee and Wage Information");
        setResizable(false);

        scrollPaneMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        lblMotorPhHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblMotorPhHeader.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblMotorPhHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMotorPhHeader.setText("MotorPH Payroll System");
        lblMotorPhHeader.setOpaque(true);

        lblEmployeeInformationHeader.setBackground(new java.awt.Color(223, 54, 54));
        lblEmployeeInformationHeader.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        lblEmployeeInformationHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeInformationHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployeeInformationHeader.setText("Employee Information");
        lblEmployeeInformationHeader.setOpaque(true);

        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLastName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtLastName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtLastName.setFocusable(false);
        txtLastName.setRequestFocusEnabled(false);
        txtLastName.setVerifyInputWhenFocusTarget(false);
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        lblLastName.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLastName.setText("Last Name:");
        lblLastName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblLastName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblLastName.setMaximumSize(new java.awt.Dimension(93, 25));
        lblLastName.setMinimumSize(new java.awt.Dimension(93, 25));
        lblLastName.setOpaque(true);

        lblBirthdate.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblBirthdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBirthdate.setText("Birthdate:");
        lblBirthdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblBirthdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblBirthdate.setMaximumSize(new java.awt.Dimension(93, 25));
        lblBirthdate.setMinimumSize(new java.awt.Dimension(93, 25));
        lblBirthdate.setOpaque(true);

        txtBirthdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBirthdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtBirthdate.setFocusable(false);

        txtPhoneNumber.setEditable(false);
        txtPhoneNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhoneNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtPhoneNumber.setFocusable(false);

        lblPhoneNumber.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhoneNumber.setText("Phone #:");
        lblPhoneNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblPhoneNumber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPhoneNumber.setMaximumSize(new java.awt.Dimension(93, 25));
        lblPhoneNumber.setMinimumSize(new java.awt.Dimension(93, 25));
        lblPhoneNumber.setOpaque(true);

        txtAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtAddress.setFocusable(false);

        lblAddress.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddress.setText("Address:");
        lblAddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblAddress.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAddress.setMaximumSize(new java.awt.Dimension(93, 25));
        lblAddress.setMinimumSize(new java.awt.Dimension(93, 25));
        lblAddress.setOpaque(true);

        txtSssNumber.setEditable(false);
        txtSssNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSssNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtSssNumber.setFocusable(false);

        lblSssNumber.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblSssNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSssNumber.setText("SSS #:");
        lblSssNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblSssNumber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSssNumber.setMaximumSize(new java.awt.Dimension(93, 25));
        lblSssNumber.setMinimumSize(new java.awt.Dimension(93, 25));
        lblSssNumber.setOpaque(true);

        txtPhilHealthNumber.setEditable(false);
        txtPhilHealthNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhilHealthNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtPhilHealthNumber.setFocusable(false);

        lblPhilHealthNumber.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblPhilHealthNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhilHealthNumber.setText("PhilHealth #:");
        lblPhilHealthNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblPhilHealthNumber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPhilHealthNumber.setMaximumSize(new java.awt.Dimension(93, 25));
        lblPhilHealthNumber.setMinimumSize(new java.awt.Dimension(93, 25));
        lblPhilHealthNumber.setOpaque(true);

        txtTinNumber.setEditable(false);
        txtTinNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTinNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtTinNumber.setFocusable(false);

        lblTinNumber.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblTinNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTinNumber.setText("TIN:");
        lblTinNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblTinNumber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTinNumber.setMaximumSize(new java.awt.Dimension(93, 25));
        lblTinNumber.setMinimumSize(new java.awt.Dimension(93, 25));
        lblTinNumber.setOpaque(true);

        txtStatus.setEditable(false);
        txtStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtStatus.setFocusable(false);
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Status:");
        lblStatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblStatus.setMaximumSize(new java.awt.Dimension(93, 25));
        lblStatus.setMinimumSize(new java.awt.Dimension(93, 25));
        lblStatus.setOpaque(true);

        txtPagIbigNumber.setEditable(false);
        txtPagIbigNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPagIbigNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtPagIbigNumber.setFocusable(false);

        lblPagIbigNumber.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblPagIbigNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPagIbigNumber.setText("Pag-IBIG #:");
        lblPagIbigNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblPagIbigNumber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPagIbigNumber.setMaximumSize(new java.awt.Dimension(93, 25));
        lblPagIbigNumber.setMinimumSize(new java.awt.Dimension(93, 25));
        lblPagIbigNumber.setOpaque(true);

        txtPosition.setEditable(false);
        txtPosition.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPosition.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtPosition.setFocusable(false);

        lblPosition.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPosition.setText("Position:");
        lblPosition.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblPosition.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPosition.setMaximumSize(new java.awt.Dimension(93, 25));
        lblPosition.setMinimumSize(new java.awt.Dimension(93, 25));
        lblPosition.setOpaque(true);

        txtBasicSalary.setEditable(false);
        txtBasicSalary.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBasicSalary.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtBasicSalary.setFocusable(false);

        lblBasicSalary.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblBasicSalary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBasicSalary.setText("Basic Salary:");
        lblBasicSalary.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblBasicSalary.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblBasicSalary.setMaximumSize(new java.awt.Dimension(93, 25));
        lblBasicSalary.setMinimumSize(new java.awt.Dimension(93, 25));
        lblBasicSalary.setOpaque(true);

        txtPhoneAllowance.setEditable(false);
        txtPhoneAllowance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhoneAllowance.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtPhoneAllowance.setFocusable(false);

        lblPhoneAllowance.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblPhoneAllowance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhoneAllowance.setText("Phone Allowance:");
        lblPhoneAllowance.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblPhoneAllowance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPhoneAllowance.setMaximumSize(new java.awt.Dimension(93, 25));
        lblPhoneAllowance.setMinimumSize(new java.awt.Dimension(93, 25));
        lblPhoneAllowance.setOpaque(true);

        txtGrossSemimonthlyRate.setEditable(false);
        txtGrossSemimonthlyRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrossSemimonthlyRate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtGrossSemimonthlyRate.setFocusable(false);

        lblGrossSemimonthlyRate.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblGrossSemimonthlyRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGrossSemimonthlyRate.setText("Gross Semi-monthly Rate:");
        lblGrossSemimonthlyRate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblGrossSemimonthlyRate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblGrossSemimonthlyRate.setMaximumSize(new java.awt.Dimension(93, 25));
        lblGrossSemimonthlyRate.setMinimumSize(new java.awt.Dimension(93, 25));
        lblGrossSemimonthlyRate.setOpaque(true);

        txtImmediateSupervisor.setEditable(false);
        txtImmediateSupervisor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtImmediateSupervisor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtImmediateSupervisor.setFocusable(false);

        lblImmediateSupervisor.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblImmediateSupervisor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImmediateSupervisor.setText("Immediate Supervisor:");
        lblImmediateSupervisor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblImmediateSupervisor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImmediateSupervisor.setMaximumSize(new java.awt.Dimension(93, 25));
        lblImmediateSupervisor.setMinimumSize(new java.awt.Dimension(93, 25));
        lblImmediateSupervisor.setOpaque(true);

        txtRiceSubsidy.setEditable(false);
        txtRiceSubsidy.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRiceSubsidy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtRiceSubsidy.setFocusable(false);

        lblRiceSubsidy.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblRiceSubsidy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRiceSubsidy.setText("Rice Subsidy:");
        lblRiceSubsidy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblRiceSubsidy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRiceSubsidy.setMaximumSize(new java.awt.Dimension(93, 25));
        lblRiceSubsidy.setMinimumSize(new java.awt.Dimension(93, 25));
        lblRiceSubsidy.setOpaque(true);

        txtClothingAllowance.setEditable(false);
        txtClothingAllowance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClothingAllowance.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtClothingAllowance.setFocusable(false);

        lblClothingAllowance.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblClothingAllowance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClothingAllowance.setText("Clothing Allowance:");
        lblClothingAllowance.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblClothingAllowance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblClothingAllowance.setMaximumSize(new java.awt.Dimension(93, 25));
        lblClothingAllowance.setMinimumSize(new java.awt.Dimension(93, 25));
        lblClothingAllowance.setOpaque(true);

        txtHourlyRate.setEditable(false);
        txtHourlyRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHourlyRate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtHourlyRate.setFocusable(false);

        lblHourlyRate.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblHourlyRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHourlyRate.setText("Hourly Rate:");
        lblHourlyRate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblHourlyRate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblHourlyRate.setMaximumSize(new java.awt.Dimension(93, 25));
        lblHourlyRate.setMinimumSize(new java.awt.Dimension(93, 25));
        lblHourlyRate.setOpaque(true);

        lblFirstName.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFirstName.setText("First Name:");
        lblFirstName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblFirstName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblFirstName.setMaximumSize(new java.awt.Dimension(93, 25));
        lblFirstName.setMinimumSize(new java.awt.Dimension(93, 25));
        lblFirstName.setOpaque(true);

        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFirstName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtFirstName.setFocusable(false);

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

        btnUpdate.setBackground(new java.awt.Color(40, 167, 69));
        btnUpdate.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setFocusable(false);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblEmployeeNumber.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        lblEmployeeNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployeeNumber.setText("Employee #");
        lblEmployeeNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        lblEmployeeNumber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblEmployeeNumber.setMaximumSize(new java.awt.Dimension(93, 25));
        lblEmployeeNumber.setMinimumSize(new java.awt.Dimension(93, 25));
        lblEmployeeNumber.setOpaque(true);

        txtEmployeeNumber.setEditable(false);
        txtEmployeeNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmployeeNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtEmployeeNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtEmployeeNumber.setFocusable(false);

        btnDelete.setBackground(new java.awt.Color(220, 53, 69));
        btnDelete.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setFocusable(false);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack2.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        btnBack2.setText("Back");
        btnBack2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnBack2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack2.setFocusable(false);
        btnBack2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBack2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBack2MouseExited(evt);
            }
        });
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBottomSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEmployeeInformationHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblMotorPhHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                        .addComponent(lblEmployeeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmployeeNumber))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLastName))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFirstName))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBirthdate))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhoneNumber))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblSssNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSssNumber))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblPhilHealthNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhilHealthNumber))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblTinNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTinNumber))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblPagIbigNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPagIbigNumber))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStatus))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPosition))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblImmediateSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImmediateSupervisor))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBasicSalary))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblRiceSubsidy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRiceSubsidy))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblPhoneAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhoneAllowance))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblClothingAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClothingAllowance))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                        .addComponent(lblGrossSemimonthlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGrossSemimonthlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                        .addComponent(lblHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblMotorPhHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lblEmployeeInformationHeader)
                .addGap(15, 15, 15)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSssNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSssNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhilHealthNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhilHealthNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTinNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTinNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPagIbigNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPagIbigNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImmediateSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImmediateSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRiceSubsidy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRiceSubsidy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClothingAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClothingAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrossSemimonthlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrossSemimonthlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(lblBottomSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        scrollPaneMain.setViewportView(pnlMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Handles the action event of the back button to close the current page.
     */
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    if (!isEditing) {
        // Enable text fields for editing
        setFieldsEditable(true);
        btnUpdate.setText("Save"); // Change button text
    } else {
        // Save changes and disable editing
        saveEmployeeDetails();
        setFieldsEditable(false);
        btnUpdate.setText("Update"); // Reset button text
    }
    isEditing = !isEditing; // Toggle state
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * Handles mouse exit event on the back button by resetting its background
     * color.
     */
    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        btnUpdate.setBackground(WHITE);
    }//GEN-LAST:event_btnUpdateMouseExited

    /**
     * Handles mouse hover event on the back button by changing its background
     * color.
     */
    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        btnUpdate.setBackground(LIGHT_BLUE);
    }//GEN-LAST:event_btnUpdateMouseEntered

    /**
     * Handles the action event of the exit button to exit the application.
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // Exit the application
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * Handles mouse exit event on the exit button by resetting its background
     * color.
     */
    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(WHITE);
    }//GEN-LAST:event_btnExitMouseExited

    /**
     * Handles mouse hover event on the exit button by changing its background
     * color.
     */
    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(RED);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMouseExited

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       int confirm = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete this employee?", 
        "Confirm Deletion", 
        JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Get the employee number from the text field
                int employeeNum = Integer.parseInt(txtEmployeeNumber.getText());

                // Call the method to delete from CSV
                EmployeeInformation employeeInfoManager = new EmployeeInformation();
                employeeInfoManager.deleteEmployeeFromCsv(employeeNum);

                // Show success message
                JOptionPane.showMessageDialog(this, 
                    "Employee successfully deleted.", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);

                // Close the EmployeeInformationFrame after deletion
                this.dispose();
            } catch (IOException | CsvValidationException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error deleting employee: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBack2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack2MouseEntered

    private void btnBack2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack2MouseExited

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

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

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBasicSalary;
    private javax.swing.JLabel lblBirthdate;
    private javax.swing.JLabel lblBottomSeparator;
    private javax.swing.JLabel lblClothingAllowance;
    private javax.swing.JLabel lblEmployeeInformationHeader;
    private javax.swing.JLabel lblEmployeeNumber;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGrossSemimonthlyRate;
    private javax.swing.JLabel lblHourlyRate;
    private javax.swing.JLabel lblImmediateSupervisor;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMotorPhHeader;
    private javax.swing.JLabel lblPagIbigNumber;
    private javax.swing.JLabel lblPhilHealthNumber;
    private javax.swing.JLabel lblPhoneAllowance;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblRiceSubsidy;
    private javax.swing.JLabel lblSssNumber;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTinNumber;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JScrollPane scrollPaneMain;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBasicSalary;
    private javax.swing.JTextField txtBirthdate;
    private javax.swing.JTextField txtClothingAllowance;
    private javax.swing.JTextField txtEmployeeNumber;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGrossSemimonthlyRate;
    private javax.swing.JTextField txtHourlyRate;
    private javax.swing.JTextField txtImmediateSupervisor;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPagIbigNumber;
    private javax.swing.JTextField txtPhilHealthNumber;
    private javax.swing.JTextField txtPhoneAllowance;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtRiceSubsidy;
    private javax.swing.JTextField txtSssNumber;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTinNumber;
    // End of variables declaration//GEN-END:variables
}
