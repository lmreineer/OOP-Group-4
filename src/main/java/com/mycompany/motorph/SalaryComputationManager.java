/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph;

import com.mycompany.motorph.calculation.TimeCalculation;
import com.mycompany.motorph.calculation.WageCalculation;
import com.mycompany.motorph.employee.EmployeeInformation;
import com.mycompany.motorph.model.DateRange;
import java.util.List;

/**
 * * This class is responsible for computing an employee's salary.
 *
 * @author User
 */
public class SalaryComputationManager {

    private final int employeeNumber; // The logged-in employee's unique identifier

    /**
     * Constructs a SalaryComputationManager for the given employee.
     *
     * @param employeeNumber The employee's ID used for retrieving payroll data
     */
    public SalaryComputationManager(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * Computes the salary details for the given month.
     *
     * @param selectedMonth The selected month (formatted as "MM") for payroll
     * computation
     * @return A list of salary details
     * @throws Exception If an error occurs while retrieving salary information
     */
    public List<String> computeSalary(String selectedMonth) throws Exception {
        WageCalculation wageCalculation = new WageCalculation();
        DateRange dateRange = DateRange.createMonthRange(selectedMonth);
        return wageCalculation.calculateWage(employeeNumber, dateRange);
    }

    /**
     * Retrieves the employee's hourly wage rate.
     *
     * <p>
     * This method gets the hourly rate from the employee's record
     *
     * @return The hourly rate as a double or 0.0 if retrieval fails
     */
    public double getHourlyRate() {
        try {
            EmployeeInformation employeeInfo = new EmployeeInformation();
            List<String> details = employeeInfo.showEmployeeInformation(employeeNumber);

            // Index 18 is assumed to store the hourly rate in the employee information list
            return Double.parseDouble(details.get(18).replace(",", ""));
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     * Computes the number of days worked within a given month.
     *
     * This method calculates the number of working days using the
     * TimeCalculation module.
     *
     * @return The total number of days worked or 0 if an error occurs
     */
    public long getDaysWorked() {
        try {
            TimeCalculation timeCalc = new TimeCalculation();
            return timeCalc.calculateNumberOfDays(DateRange.createMonthRange("01")); // Using a sample month
        } catch (Exception e) {
            return 0;
        }
    }
}
