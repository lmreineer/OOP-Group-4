/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph;

import com.mycompany.motorph.calculation.WageCalculation;
import com.mycompany.motorph.employee.EmployeeInformation;
import com.mycompany.motorph.model.DateRange;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * * This class is responsible for computing an employee's salary.
 *
 * @author User
 */
public class SalaryComputationManager {

    private final int employeeNumber;

    // The date format for the attendance records
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd");

    /**
     * Constructs a new constructor for the specified employee.
     *
     * @param employeeNumber The unique employee number
     */
    public SalaryComputationManager(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * Computes the salary details for the given month.
     *
     * @param selectedMonth The month for which the salary is calculated
     * @return A list of salary components
     * @throws Exception If an error occurs during salary computation
     */
    public List<String> computeSalary(String selectedMonth) throws Exception {
        WageCalculation wageCalculation = new WageCalculation();
        DateRange dateRange = DateRange.createMonthRange(selectedMonth);
        return wageCalculation.calculateWage(employeeNumber, dateRange);
    }

    /**
     * Retrieves the hourly rate for the employee.
     *
     * @return The hourly wage of the employee. Returns 0 if an error occurs
     */
    public double getHourlyRate() {
        try {
            EmployeeInformation employeeInfo = new EmployeeInformation();
            List<String> details = employeeInfo.showEmployeeInformation(employeeNumber);

            // Extract hourly rate from employee info
            return Double.parseDouble(details.get(18).replace(",", ""));
        } catch (CsvValidationException | IOException | NumberFormatException | ParseException e) {
            // Return 0 if retrieval fails
            return 0;
        }
    }

    /**
     * Computes the number of days worked by the employee for the selected
     * month.
     *
     * @param selectedMonth The selected month in MM format
     * @return The number of workdays the employee attended
     * @throws CsvValidationException If an error occurs while reading the CSV
     * file
     */
    public String getDaysWorked(String selectedMonth) throws CsvValidationException {
        try {
            WageCalculation wageCalculation = new WageCalculation();
            DateRange dateRange = DateRange.createMonthRange(selectedMonth);
            List<String[]> attendanceData = wageCalculation.readAttendanceData();

            Set<String> uniqueWorkDays = new HashSet<>();

            for (String[] record : attendanceData) {
                if (record.length < 6) {
                    // Ensure that the record has enough columns
                    continue;
                }
                int empNum = Integer.parseInt(record[0]);

                if (empNum == employeeNumber) {
                    // Column index 3 stores the date
                    String dateString = record[3];

                    // Convert String to Date
                    Date attendanceDate = DATE_FORMAT.parse(dateString);

                    // Check if the date falls within the selected month
                    if (dateRange.isWithinDateRange(attendanceDate)) {
                        // Store as String to count unique days
                        uniqueWorkDays.add(dateString);
                    }
                }
            }

            return uniqueWorkDays.isEmpty() ? "Not Recorded" : String.valueOf(uniqueWorkDays.size());

        } catch (IOException | ParseException e) {
            // Return "N/A" if an error occurs
            return "Not Recorded";
        }
    }

}
