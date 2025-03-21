/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.manager;

import com.mycompany.motorph.calculation.WageCalculation;
import com.mycompany.motorph.employee.EmployeeInformation;
import com.mycompany.motorph.model.DateRange;
import com.mycompany.motorph.model.Employee;
import com.mycompany.motorph.repository.EmployeeDataReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class manages employee salary computations.
 *
 * @author Lance
 */
public class SalaryComputationManager {

    private static final Logger LOGGER = Logger.getLogger(SalaryComputationManager.class.getName());
    private final int employeeNumber;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd");

    /**
     * Constructs a SalaryComputationManager for the specified employee.
     *
     * @param employeeNumber The unique employee number
     */
    public SalaryComputationManager(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * Computes salary details for a given month.
     *
     * @param selectedMonth The month for which salary is computed
     * @return A list of salary components
     * @throws SalaryComputationException If an error occurs during salary
     * computation
     */
    public List<String> computeSalary(String selectedMonth) throws SalaryComputationException {
        try {
            WageCalculation wageCalculation = new WageCalculation();
            DateRange dateRange = DateRange.createMonthRange(selectedMonth);
            return wageCalculation.calculateWage(employeeNumber, dateRange);
        } catch (CsvValidationException | IOException | ParseException e) {
            LOGGER.log(Level.SEVERE, "Error computing salary for employee {0}: {1}", new Object[]{employeeNumber, e.getMessage()});
            throw new SalaryComputationException("Failed to compute salary for employee " + employeeNumber, e);
        }
    }

    /**
     * Retrieves the hourly rate for the employee.
     *
     * @return The hourly wage of the employee
     * @throws EmployeeInformation.EmployeeNotFoundException If the employee is
     * not found
     * @throws
     * com.mycompany.motorph.repository.EmployeeDataReader.EmployeeDataException
     */
    public double getHourlyRate() throws EmployeeInformation.EmployeeNotFoundException, EmployeeDataReader.EmployeeDataException {
        try {
            EmployeeInformation employeeInfo = new EmployeeInformation();
            Employee details = employeeInfo.showEmployeeInformation(employeeNumber);
            return details.getHourlyRate();
        } catch (CsvValidationException | IOException | NumberFormatException | ParseException e) {
            LOGGER.log(Level.WARNING, "Error retrieving hourly rate for employee {0}: {1}", new Object[]{employeeNumber, e.getMessage()});
            return 0;
        }
    }

    /**
     * Computes the number of days worked by the employee for the selected
     * month.
     *
     * @param selectedMonth The selected month in MM format
     * @return The number of workdays attended, or "Not Recorded" if unavailable
     * @throws com.opencsv.exceptions.CsvValidationException
     */
    public String getDaysWorked(String selectedMonth) throws CsvValidationException {
        try {
            WageCalculation wageCalculation = new WageCalculation();
            DateRange dateRange = DateRange.createMonthRange(selectedMonth);
            List<String[]> attendanceData = wageCalculation.readAttendanceData();

            Set<String> uniqueWorkDays = new HashSet<>();

            for (String[] record : attendanceData) {
                if (record.length < 6) {
                    continue; // Ensure enough columns
                }
                int empNum = Integer.parseInt(record[0]);

                if (empNum == employeeNumber) {
                    String dateString = record[3];
                    Date attendanceDate = DATE_FORMAT.parse(dateString);

                    if (dateRange.isWithinDateRange(attendanceDate)) {
                        uniqueWorkDays.add(dateString);
                    }
                }
            }
            return uniqueWorkDays.isEmpty() ? "Not Recorded" : String.valueOf(uniqueWorkDays.size());

        } catch (IOException | ParseException e) {
            LOGGER.log(Level.WARNING, "Error retrieving work days for employee {0}: {1}", new Object[]{employeeNumber, e.getMessage()});
            return "Not Recorded";
        }
    }

    /**
     * Custom exception for handling salary computation errors.
     */
    public static class SalaryComputationException extends Exception {

        public SalaryComputationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
