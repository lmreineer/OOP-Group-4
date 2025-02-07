/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.motorph;

import com.mycompany.motorph.calculation.WageCalculation;
import com.mycompany.motorph.employee.EmployeeInformation;
import com.mycompany.motorph.model.DateRange;
import static com.mycompany.motorph.model.DateRange.createMonthRange;
import com.opencsv.exceptions.CsvValidationException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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

    private boolean deleteButtonClicked = false;

    private JButton btnCompute;
    private JComboBox<String> cmbMonth;
    private JLabel lblInstruction;
    private JPanel pnlTop;

    /**
     * Creates new EmployeeInformationFrame.
     *
     * @param employeeInformation List of strings that contains initial employee
     * information.
     */
    public EmployeeInformationFrame(List<String> employeeInformation) {
        initComponents();
        setupFrame(employeeInformation);
        assignClickHandlersToTextFields();
    }

    /**
     * Sets up the frame with initial components and layout.
     *
     * @param employeeDetails List of strings that contains initial employee
     * information.
     */
    private void setupFrame(List<String> employeeDetails) {
        setLayout(new BorderLayout());

        // Create components
        showInformation(employeeDetails);

        // Set frame visibility
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Creates the top panel with a label, combo box for months, and compute
     * button.
     *
     * @param employeeDetails List of strings that contains initial employee
     * information.
     */
//    private void initializeTopPanel(List<String> employeeDetails) {
//        // Create the label
//        lblInstruction = new JLabel("Select the month for wage information");
//
//        // Create the month combo box
//        String[] months = {
//            "January", "February", "March", "April", "May", "June",
//            "July", "August", "September", "October", "November", "December"
//        };
//        cmbMonth = new JComboBox<>(months);
//
//        // Create the compute button
//        btnCompute = createButton("Compute", e -> {
//            String selectedMonth = String.format("%02d", cmbMonth.getSelectedIndex() + 1);
//            showInformation(employeeDetails, selectedMonth);
//        });
//
//        btnCompute.addMouseListener(createButtonHoverAdapter(btnCompute, LIGHT_BLUE, WHITE));
//
//        btnCompute.setBackground(WHITE);
//        btnCompute.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//        scrollPaneMain.setVisible(false);  // Initially hide the information panel
//
//        // Create a panel for the top components
//        pnlTop = new JPanel();
//        // Add a 12-pixel margin
//        pnlTop.setBorder(new EmptyBorder(12, 12, 12, 12));
//        pnlTop.setBackground(Color.WHITE);
//        pnlTop.add(lblInstruction);
//        pnlTop.add(cmbMonth);
//
//        cmbMonth.setFocusable(false);
//        btnCompute.setFocusable(false);
//
//        // Add the top panel and the compute button to the frame
//        add(pnlTop, BorderLayout.NORTH);
//        add(btnCompute, BorderLayout.CENTER);
//    }
    /**
     * Creates a JButton with specified text and action listener.
     *
     * @param text Text to display on the button
     * @param actionListener ActionListener for button click event
     * @return JButton created button
     */
    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        return button;
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
     * Displays employee and wage information for the selected month.
     *
     * @param employeeDetails List of strings that contains employee
     * information.
     * @param selectedMonth Selected month in "MM" format.
     */
    public void showInformation(List<String> employeeDetails) {
//        remove(pnlTop);
//        remove(btnCompute);

        populateEmployeeInformation(employeeDetails.get(0));

        // Set the intended size
        scrollPaneMain.setPreferredSize(new Dimension(603, 627));
        scrollPaneMain.setVisible(true);
        add(scrollPaneMain, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        revalidate();
        repaint();

//        populateWageInformation(selectedMonth);
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
        btnBack = new javax.swing.JButton();
        lblEmployeeNumber = new javax.swing.JLabel();
        txtEmployeeNumber = new javax.swing.JTextField();

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

        txtLastName.setEditable(false);
        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLastName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtLastName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtLastName.setFocusable(false);

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

        txtBirthdate.setEditable(false);
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

        txtAddress.setEditable(false);
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

        txtFirstName.setEditable(false);
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

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBottomSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEmployeeInformationHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblMotorPhHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
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
                .addGap(6, 6, 6))
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
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
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
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Close the current page
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Handles mouse exit event on the back button by resetting its background
     * color.
     */
    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setBackground(WHITE);
    }//GEN-LAST:event_btnBackMouseExited

    /**
     * Handles mouse hover event on the back button by changing its background
     * color.
     */
    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setBackground(LIGHT_BLUE);
    }//GEN-LAST:event_btnBackMouseEntered

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
     * Updates the employee information text fields for the chosen employee.
     *
     * @param employeeInfo The information of the employee
     */
    private void updateEmployeeInformationFields(List<String> employeeInfo) {
        JTextField[] textFields = {txtEmployeeNumber, txtLastName, txtFirstName, txtBirthdate, txtAddress, txtPhoneNumber,
            txtSssNumber, txtPhilHealthNumber, txtTinNumber, txtPagIbigNumber, txtStatus, txtPosition,
            txtImmediateSupervisor, txtBasicSalary, txtRiceSubsidy, txtPhoneAllowance, txtClothingAllowance,
            txtGrossSemimonthlyRate, txtHourlyRate};

        // Set the text of each field with the employee information
        for (int i = 0; i < textFields.length; i++) {
            textFields[i].setText(employeeInfo.get(i));
        }
    }

    /**
     * Populates employee information fields based on the provided employee
     * number.
     *
     * @param employeeNumberString The employee number as a string.
     */
    private void populateEmployeeInformation(String employeeNumberString) {
        try {
            // Parse the employee number from the text field
            int employeeNumber = Integer.parseInt(employeeNumberString);

            // Get employee information
            List<String> employeeInfo = new EmployeeInformation().showEmployeeInformation(employeeNumber);

            // Populate text fields with employee information
            updateEmployeeInformationFields(employeeInfo);
//
//            // Enable the delete and update buttons
//            btnDeleteInfo.setEnabled(true);
//            btnUpdateInfo.setEnabled(true);
        } catch (IOException | ParseException | CsvValidationException | IllegalArgumentException e) {
            // Show error dialog with the exception message
            showErrorDialog(e.getMessage());
        }
    }

    /**
     * Populates wage information fields based on the provided employee number
     * and selected month.
     *
     * @param selectedMonth The selected month for which the wage information is
     * displayed
     */
    private void populateWageInformation(String selectedMonth) {
        try {
            int employeeNumber = Integer.parseInt(txtEmployeeNumber.getText());

            // Get employee information
            new EmployeeInformation().showEmployeeInformation(employeeNumber);

            // Create a DateRange object based on the selected month
            DateRange dateRange = createMonthRange(selectedMonth);

            // Create an instance of NetWageCalculation
            WageCalculation wageCalculation = new WageCalculation();

            // Get wage information for the given employee number and date range
            List<String> wageInfo = wageCalculation.calculateWage(employeeNumber, dateRange);

            // Display the net wage in the appropriate text fields
            updateWageInformationFields(wageInfo, selectedMonth);
        } catch (IOException | ParseException | CsvValidationException | IllegalArgumentException e) {
            // Show error dialog with the exception message
            showErrorDialog(e.getMessage());
        }
    }

    /**
     * Updates the wage information text fields for the chosen employee.
     *
     * @param wageInfo The wage information of the employee to display
     * @param selectedMonth The selected month for which the wage information is
     * displayed
     */
    private void updateWageInformationFields(List<String> wageInfo, String selectedMonth) {
        String monthName = getMonthName(selectedMonth);

//        txtMonth.setText(monthName);
//        txtGrossWage.setText(wageInfo.get(0));
//        txtSssDeduction.setText(wageInfo.get(1));
//        txtPhilHealthDeduction.setText(wageInfo.get(2));
//        txtPagIbigDeduction.setText(wageInfo.get(3));
//        txtWithholdingTax.setText(wageInfo.get(4));
//        txtLateArrivalDeduction.setText(wageInfo.get(5));
//        txtTotalDeductions.setText(wageInfo.get(6));
//        txtNetWage.setText(wageInfo.get(7));
    }

    /**
     * Gets the name of the month based on the provided month number.
     *
     * @param monthNumber The month number as a string
     * @return The name of the month.
     * @throws IllegalArgumentException If the month number is invalid (not
     * between 1 and 12).
     */
    private String getMonthName(String monthNumber) throws IllegalArgumentException {
        int monthInt = Integer.parseInt(monthNumber);
        if (monthInt < 1 || monthInt > 12) {
            showErrorDialog("Invalid month number: " + monthNumber);
        }

        Month month = Month.of(monthInt);
        // Convert to lowercase
        String monthName = month.toString().toLowerCase();
        // Capitalize first letter
        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1);

        return monthName;
    }

    /**
     * Assigns a mouse click event handler to a text field.
     *
     * @param textField JTextField to assign the click handler
     */
    private void assignClickHandlerToTextField(JTextField textField) {
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // When the mouse is clicked on the text field, call handleTextFieldClick method
                handleTextFieldClick(textField);
            }
        });
    }

    /**
     * Assigns mouse click event handlers to all text fields.
     */
    private void assignClickHandlersToTextFields() {
        JTextField[] textFields = {
            txtLastName, txtFirstName, txtBirthdate, txtAddress, txtPhoneNumber,
            txtSssNumber, txtPhilHealthNumber, txtTinNumber, txtPagIbigNumber,
            txtStatus, txtPosition, txtImmediateSupervisor, txtBasicSalary,
            txtRiceSubsidy, txtPhoneAllowance, txtClothingAllowance,
            txtGrossSemimonthlyRate, txtHourlyRate
        };

        // Assign click event handler to each text field
        for (JTextField field : textFields) {
            assignClickHandlerToTextField(field);
        }
    }

    /**
     * Handles mouse click event on a text field.
     *
     * @param textField JTextField that was clicked
     */
    private void handleTextFieldClick(JTextField textField) {
        // If deleteButtonClicked is true
        if (deleteButtonClicked) {
            // Clear the text field
            textField.setText("");
        }
    }

    /**
     * Sets the editability of the fields.
     *
     * @param allowed A boolean for indicating whether the fields should be
     * editable.
     */
    private void setFieldsEditable(boolean allowed) {
        // Define an array of text fields
        JTextField[] textFields = {
            txtLastName, txtFirstName, txtBirthdate, txtAddress, txtPhoneNumber,
            txtSssNumber, txtPhilHealthNumber, txtTinNumber, txtPagIbigNumber,
            txtStatus, txtPosition, txtImmediateSupervisor, txtBasicSalary,
            txtRiceSubsidy, txtPhoneAllowance, txtClothingAllowance,
            txtGrossSemimonthlyRate, txtHourlyRate
        };

        // Loop through each text field
        for (JTextField field : textFields) {
            // Change text fields' background color
            field.setBackground(allowed ? WHITE : GRAY);

            if (deleteButtonClicked) {
                field.setCursor(new Cursor(Cursor.HAND_CURSOR));
                // Set text fields to non-editable
                field.setEditable(false);
                field.setFocusable(false);
            } else {
                deleteButtonClicked = false;
                field.setCursor(new Cursor(Cursor.TEXT_CURSOR));
                // Set text fields to editable
                field.setEditable(allowed);
                field.setFocusable(allowed);
            }
        }

        // Enable the save button
//        btnSave.setEnabled(true);
    }

    /**
     * Gathers employee information from the fields.
     *
     * @return A list of strings that contains the employee information.
     */
    private List<String> gatherEmployeeInformationFromFields() {
        List<String> employeeInfo = new ArrayList<>();

        // Add the text of each field to the list
        employeeInfo.add(txtLastName.getText());
        employeeInfo.add(txtFirstName.getText());
        employeeInfo.add(txtBirthdate.getText());
        employeeInfo.add(txtAddress.getText());
        employeeInfo.add(txtPhoneNumber.getText());
        employeeInfo.add(txtSssNumber.getText());
        employeeInfo.add(txtPhilHealthNumber.getText());
        employeeInfo.add(txtTinNumber.getText());
        employeeInfo.add(txtPagIbigNumber.getText());
        employeeInfo.add(txtStatus.getText());
        employeeInfo.add(txtPosition.getText());
        employeeInfo.add(txtImmediateSupervisor.getText());
        employeeInfo.add(txtBasicSalary.getText());
        employeeInfo.add(txtRiceSubsidy.getText());
        employeeInfo.add(txtPhoneAllowance.getText());
        employeeInfo.add(txtClothingAllowance.getText());
        employeeInfo.add(txtGrossSemimonthlyRate.getText());
        employeeInfo.add(txtHourlyRate.getText());

        return employeeInfo;
    }

    /**
     * Updates the employee information based on input from fields. Gets data
     * and updates CSV files.
     */
    private void updateEmployeeInformation() {
        try {
            // Parse the employee number from the text field
            int employeeNumber = Integer.parseInt(txtEmployeeNumber.getText());

            // Gather the updated employee information from the fields
            List<String> updatedEmployeeInfo = gatherEmployeeInformationFromFields();

            // Update the employee information in the CSV file
            new EmployeeInformation().updateEmployeeInformationInCsv(employeeNumber, updatedEmployeeInfo);

            // Set fields non-editable after saving
            setFieldsEditable(false);
            // Set deleteButtonClicked value to false
            deleteButtonClicked = false;
        } catch (IOException | ParseException | CsvValidationException | IllegalArgumentException e) {
            // Show error dialog with the exception message
            showErrorDialog(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
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
