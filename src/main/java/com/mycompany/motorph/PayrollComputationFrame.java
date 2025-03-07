/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This provides a user interface for employees to compute their salary.
 *
 * @author User
 */
public class PayrollComputationFrame extends JFrame {

    private final int employeeNumber;  // The logged-in employee's ID
    private final JPanel wagePanel;  // Panel that holds salary details
    private final Map<String, JLabel> valueLabels; // Stores labels for salary details
    private JComboBox<String> monthComboBox; // Dropdown menu for selecting a month
    private JButton computeButton;

    /**
     * Constructs a PayrollComputationFrame for the given employee.
     *
     * @param employeeNumber The employee's ID used for retrieving payroll data
     */
    public PayrollComputationFrame(int employeeNumber) {
        this.employeeNumber = employeeNumber;
        setTitle("Salary Computation");
        setSize(500, 420);
        setLayout(new BorderLayout());

        // Create the top panel (month selection & compute button)
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Panel to display salary details
        wagePanel = new JPanel(new GridLayout(0, 2, 10, 10));
        valueLabels = new HashMap<>();

        // Initialize labels with default values
        initializeLabels();
        add(wagePanel, BorderLayout.CENTER);

        // Add a close button at the bottom
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose()); // Closes the window
        add(closeButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Creates the top panel which contains the month selection dropdown and the
     * compute button.
     *
     * @return A JPanel containing the month selection and compute button
     */
    private JPanel createTopPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Month:"));

        // Dropdown for selecting a month
        String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);
        panel.add(monthComboBox);

        // Compute button to trigger salary computation
        computeButton = new JButton("Compute");
        computeButton.addActionListener(e -> computeSalary());
        panel.add(computeButton);

        return panel;
    }

    /**
     * Initializes labels for displaying salary details. The values are all set
     * to "0" by default.
     */
    private void initializeLabels() {
        String[] labels = {"Rate Per Hour", "Days Worked", "Gross Wage", "SSS Deduction",
            "PhilHealth Deduction", "Pag-IBIG Deduction", "Withholding Tax",
            "Late Arrival Deduction", "Total Deductions", "Net Wage"};

        for (String label : labels) {
            JLabel valueLabel = createLabeledRow(label, "0");
            valueLabels.put(label, valueLabel);
        }
    }

    /**
     * Creates a labeled row with a title and an initial value.
     *
     * @param labelText The title of the label
     * @param initialValue The initial value to display (default: "0")
     * @return A JLabel representing the value field
     */
    private JLabel createLabeledRow(String labelText, String initialValue) {
        JLabel label = new JLabel(labelText + ":");
        JLabel value = new JLabel(initialValue);
        wagePanel.add(label);
        wagePanel.add(value);
        return value;
    }

    /**
     * Computes the salary for the selected month and updates the displayed
     * values.
     */
    private void computeSalary() {
        String selectedMonth = String.format("%02d", monthComboBox.getSelectedIndex() + 1); // Convert month index to two-digit format

        try {
            // Create a SalaryComputationManager instance for processing salary details
            SalaryComputationManager computationManager = new SalaryComputationManager(employeeNumber);
            List<String> wageInfo = computationManager.computeSalary(selectedMonth);

            // Update the UI with computed values
            valueLabels.get("Rate Per Hour").setText(String.format("%.2f", computationManager.getHourlyRate()));
            valueLabels.get("Days Worked").setText(String.valueOf(computationManager.getDaysWorked(selectedMonth)));

            // This is a list of fields related to wages to update in the UI
            String[] wageKeys = {"Gross Wage", "SSS Deduction", "PhilHealth Deduction", "Pag-IBIG Deduction",
                "Withholding Tax", "Late Arrival Deduction", "Total Deductions", "Net Wage"};

            // Loop through wageKeys and update their corresponding UI labels
            for (int i = 0; i < wageKeys.length; i++) {
                valueLabels.get(wageKeys[i]).setText(wageInfo.get(i));
            }

            // Refresh UI to reflect the updated values
            wagePanel.revalidate();
            wagePanel.repaint();

        } catch (Exception ex) {
            // Show error message if computation fails
            JOptionPane.showMessageDialog(this, "Error computing salary: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
