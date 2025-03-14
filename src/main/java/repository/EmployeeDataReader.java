/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

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

/**
 * A class that reads employee data from the data file.
 *
 * @author Lance
 */
public class EmployeeDataReader {

    private final SimpleDateFormat BIRTHDATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    // Expected total number of data per column from the data
    private static final int EMPLOYEE_EXPECTED_COL_LENGTH = 19;

    /**
     * Reads employee data from the data file and returns a list of employees.
     *
     * @param filePath The path to the employee_information data file
     * @return The list of employee data read from the file
     * @throws IOException If an I/O error occurs while reading the file
     * @throws CsvValidationException If data from a row is invalid
     * @throws ParseException If parsing error occurs
     */
    public List<Employee> readEmployees(String filePath) throws IOException, CsvValidationException, ParseException {
        List<Employee> employees = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] data;
            reader.readNext(); // Skip header

            while ((data = reader.readNext()) != null) {
                if (data.length != EMPLOYEE_EXPECTED_COL_LENGTH) {
                    System.err.println("Skipping invalid row (expected " + EMPLOYEE_EXPECTED_COL_LENGTH + " columns, found " + data.length + "): " + String.join(",", data));
                    continue; // Skip this row and move to the next
                }

                employees.add(createEmployeeFromData(data));
            }
        }

        return employees;
    }

    /**
     * Writes employee data to the specified file path.
     *
     * @param filePath The path to the employee data CSV file
     * @param employees The list of Employee objects to write to the file
     * @throws IOException If an I/O error occurs while writing to the file
     */
    public void writeEmployees(String filePath, List<Employee> employees) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write the header row
            writer.writeNext(getHeader());
            // Loop through each employee
            for (Employee employee : employees) {
                // Write data for each employee
                writer.writeNext(getEmployeeData(employee));
            }
        }
    }

    /**
     * Retrieves the header for the CSV file.
     *
     * @return An array containing the header fields
     */
    private String[] getHeader() {
        return new String[]{"Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number",
            "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position", "Immediate Supervisor",
            "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance",
            "Gross Semi-monthly Rate", "Hourly Rate"};
    }

    /**
     * Retrieves the data for a specific employee in CSV format.
     *
     * @param employee The employee object to retrieve data from
     * @return An array containing the employee's data
     */
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

    /**
     * Creates an Employee object from an array of employee data.
     *
     * @param employeeData The array containing employee data
     * @return The employee object created with the data
     * @throws ParseException If a parsing error occurs
     */
    private Employee createEmployeeFromData(String[] employeeData) throws ParseException {
        Employee employee = new Employee(Integer.parseInt(employeeData[0]),
                employeeData[1],
                employeeData[2],
                new SimpleDateFormat("MM/dd/yyyy").parse(employeeData[3]),
                employeeData[4],
                employeeData[5],
                employeeData[10],
                employeeData[11],
                Integer.parseInt(employeeData[0]),
                employeeData[6],
                employeeData[7],
                employeeData[8],
                employeeData[9],
                employeeData[11],
                employeeData[12],
                parseDouble(employeeData[13]),
                parseDouble(employeeData[14]),
                parseDouble(employeeData[15]),
                parseDouble(employeeData[16]),
                parseDouble(employeeData[17]),
                parseDouble(employeeData[18]));

        employee.setEmployeeNumber(Integer.parseInt(employeeData[0]));
        employee.setLastName(employeeData[1]);
        employee.setFirstName(employeeData[2]);
        employee.setBirthdate(BIRTHDATE_FORMAT.parse(employeeData[3]));
        employee.setAddress(employeeData[4]);
        employee.setPhoneNumber(employeeData[5]);
        employee.setSssNumber(employeeData[6]);
        employee.setPhilHealthNumber(employeeData[7]);
        employee.setTin(employeeData[8]);
        employee.setPagIbigNumber(employeeData[9]);
        employee.setStatus(employeeData[10]);
        employee.setPosition(employeeData[11]);
        employee.setImmediateSupervisor(employeeData[12]);
        employee.setBasicSalary(parseDouble(employeeData[13]));
        employee.setRiceSubsidy(parseDouble(employeeData[14]));
        employee.setPhoneAllowance(parseDouble(employeeData[15]));
        employee.setClothingAllowance(parseDouble(employeeData[16]));
        employee.setGrossSemimonthlyRate(parseDouble(employeeData[17]));
        employee.setHourlyRate(parseDouble(employeeData[18]));

        return employee;
    }

    /**
     * Removes commas from a String value then parses it to double.
     *
     * @param value The value to be parsed
     * @return The parsed double value
     */
    private double parseDouble(String value) {
        return Double.parseDouble(value.replaceAll(",", ""));
    }
}
