/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.repository;

import com.mycompany.motorph.model.Employee;
import com.mycompany.motorph.util.CurrencyUtil;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles reading and writing employee data.
 *
 * @author Lance
 */
public class EmployeeDataReader {

    private static final Logger LOGGER = Logger.getLogger(EmployeeDataReader.class.getName());
    private static final SimpleDateFormat BIRTHDATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    private static final int EMPLOYEE_EXPECTED_COL_LENGTH = 19;

    /**
     * Reads employee data from the CSV file.
     *
     * @param filePath The path to the employee data file
     * @return The list of Employee objects
     * @throws EmployeeDataException If data is invalid or missing
     */
    public List<Employee> readEmployees(String filePath) throws EmployeeDataException {
        List<Employee> employees = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] data;
            // Skip header
            reader.readNext();

            while ((data = reader.readNext()) != null) {
                if (data.length != EMPLOYEE_EXPECTED_COL_LENGTH) {
                    LOGGER.log(Level.WARNING, "Skipping invalid row: Expected {0} columns, found {1}", new Object[]{EMPLOYEE_EXPECTED_COL_LENGTH, data.length});
                    continue;
                }
                employees.add(createEmployeeFromData(data));
            }
        } catch (IOException | CsvValidationException | ParseException e) {
            LOGGER.log(Level.SEVERE, "Error reading employee data: {0}", e.getMessage());
            throw new EmployeeDataException("Failed to read employee data.", e);
        }

        return employees;
    }

    /**
     * Writes employee data securely to the CSV file.
     *
     * @param filePath The path to the employee data file
     * @param employees The list of Employee objects to write
     * @throws EmployeeDataException If an I/O error occurs
     */
    public void writeEmployees(String filePath, List<Employee> employees) throws EmployeeDataException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(getHeader());
            for (Employee employee : employees) {
                writer.writeNext(getEmployeeData(employee));
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing employee data: {0}", e.getMessage());
            throw new EmployeeDataException("Failed to write employee data.", e);
        }
    }

    private String[] getHeader() {
        return new String[]{"Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number",
            "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position", "Immediate Supervisor",
            "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance",
            "Gross Semi-monthly Rate", "Hourly Rate"};
    }

    private String[] getEmployeeData(Employee employee) {
        return new String[]{
            String.valueOf(employee.getEmployeeNumber()),
            employee.getLastName(),
            employee.getFirstName(),
            BIRTHDATE_FORMAT.format(employee.getBirthdate()),
            employee.getAddress(),
            employee.getPhoneNumber(),
            employee.getSssNumber(),
            employee.getPhilHealthNumber(),
            employee.getTin(),
            employee.getPagIbigNumber(),
            employee.getStatus(),
            employee.getPosition(),
            employee.getImmediateSupervisor(),
            CurrencyUtil.formatCurrency(employee.getBasicSalary()),
            CurrencyUtil.formatCurrency(employee.getRiceSubsidy()),
            CurrencyUtil.formatCurrency(employee.getPhoneAllowance()),
            CurrencyUtil.formatCurrency(employee.getClothingAllowance()),
            CurrencyUtil.formatCurrency(employee.getGrossSemimonthlyRate()),
            CurrencyUtil.formatCurrency(employee.getHourlyRate())
        };
    }

    private Employee createEmployeeFromData(String[] data) throws ParseException {
        return new Employee(
                Integer.parseInt(data[0]),
                data[1],
                data[2],
                BIRTHDATE_FORMAT.parse(data[3].trim()),
                data[4],
                data[5],
                data[10],
                data[11],
                Integer.parseInt(data[0]),
                data[6],
                data[7],
                data[8],
                data[9],
                data[11],
                data[12],
                parseDouble(data[13]),
                parseDouble(data[14]),
                parseDouble(data[15]),
                parseDouble(data[16]),
                parseDouble(data[17]),
                parseDouble(data[18])
        );
    }

    private double parseDouble(String value) {
        return Double.parseDouble(value.replace(",", ""));
    }

    /**
     * Custom exception for handling employee data errors.
     */
    public static class EmployeeDataException extends Exception {

        public EmployeeDataException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
