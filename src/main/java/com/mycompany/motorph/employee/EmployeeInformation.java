/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.employee;

import com.mycompany.motorph.manager.RBACManager;
import com.mycompany.motorph.model.Employee;
import com.mycompany.motorph.repository.EmployeeDataReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class for managing employee information
 *
 * @author Lance
 */
public class EmployeeInformation {

    private static final SimpleDateFormat BIRTHDATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    private static final String EMPLOYEES_DATA_PATH = "src/main/resources/data/employee_information.csv";
    private static List<Employee> employeeCache = null; // Caching to optimize performance
    private static final Map<Integer, Employee> employeeMap = new HashMap<>();

    public EmployeeInformation() throws IOException, CsvValidationException, ParseException, EmployeeDataReader.EmployeeDataException {
        if (employeeCache == null) {
            loadEmployeeCache();
        }
    }

    /**
     * Loads employee data into memory to improve performance.
     */
    private void loadEmployeeCache() throws IOException, CsvValidationException, ParseException, EmployeeDataReader.EmployeeDataException {
        EmployeeDataReader employeeDataReader = new EmployeeDataReader();
        employeeCache = employeeDataReader.readEmployees(EMPLOYEES_DATA_PATH);
        for (Employee emp : employeeCache) {
            employeeMap.put(emp.getEmployeeNumber(), emp);
        }
    }

    /**
     * Displays employee information based on employee number.
     *
     * @param employeeNumber The employee number to search for
     * @return The Employee object
     * @throws EmployeeNotFoundException if the employee is not found
     */
    public Employee showEmployeeInformation(int employeeNumber) throws EmployeeNotFoundException {
        Employee employee = employeeMap.get(employeeNumber);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with number " + employeeNumber + " not found.");
        }
        return employee;
    }

    /**
     * Updates employee information if the user has the correct permissions.
     *
     * @param adminRole The role of the requesting user (should be "ADMIN")
     * @param employeeNumber The employee number to update
     * @param updatedEmployeeInfo The updated employee details
     * @throws UnauthorizedAccessException If the user does not have permission
     * @throws EmployeeNotFoundException If the employee does not exist
     * @throws IOException If a file error occurs
     * @throws CsvValidationException If data validation fails
     * @throws ParseException If there is an error parsing data
     * @throws com.mycompany.motorph.manager.RBACManager.InvalidRoleException
     */
    public void updateEmployeeInformationInCsv(String adminRole, int employeeNumber, List<String> updatedEmployeeInfo)
            throws UnauthorizedAccessException, EmployeeNotFoundException, IOException, CsvValidationException, ParseException, RBACManager.InvalidRoleException, EmployeeDataReader.EmployeeDataException {

        if (!RBACManager.hasPermission(adminRole, "UPDATE")) {
            throw new UnauthorizedAccessException("User does not have permission to update employee records.");
        }

        Employee employee = employeeMap.get(employeeNumber);
        if (employee == null) {
            throw new EmployeeNotFoundException("Cannot update. Employee with number " + employeeNumber + " not found.");
        }

        try {
            updateEmployee(employee, updatedEmployeeInfo);
            EmployeeDataReader employeeDataReader = new EmployeeDataReader();
            employeeDataReader.writeEmployees(EMPLOYEES_DATA_PATH, employeeCache);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid data format: missing required fields.");
        }
    }

    /**
     * Retrieves the list of all employees.
     *
     * @return The list of employees
     * @throws IOException If an I/O error occurs while reading the file
     * @throws CsvValidationException If data from a row is invalid
     * @throws ParseException If parsing error occurs
     * @throws
     * com.mycompany.motorph.repository.EmployeeDataReader.EmployeeDataException
     */
    public List<Employee> getAllEmployees() throws IOException, CsvValidationException, ParseException, EmployeeDataReader.EmployeeDataException {
        EmployeeDataReader employeeDataReader = new EmployeeDataReader();
        return employeeDataReader.readEmployees(EMPLOYEES_DATA_PATH);
    }

    /**
     * Finds an employee by their employee number.
     *
     * @param employees The list of employees to search in
     * @param employeeNumber The employee number to search for
     * @return The found employee, or null if not found
     */
    public Employee findEmployeeByNumber(List<Employee> employees, int employeeNumber) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeNumber() == employeeNumber)
                .findFirst()
                .orElse(null);
    }

    /**
     * Updates the employee fields with validated input data.
     */
    private void updateEmployee(Employee employee, List<String> updatedEmployeeInfo) throws ParseException {
        employee.setLastName(updatedEmployeeInfo.get(0));
        employee.setFirstName(updatedEmployeeInfo.get(1));
        employee.setBirthdate(BIRTHDATE_FORMAT.parse(updatedEmployeeInfo.get(2)));
        employee.setAddress(updatedEmployeeInfo.get(3));
        employee.setPhoneNumber(updatedEmployeeInfo.get(4));
        employee.setSssNumber(updatedEmployeeInfo.get(5));
        employee.setPhilHealthNumber(updatedEmployeeInfo.get(6));
        employee.setTin(updatedEmployeeInfo.get(7));
        employee.setPagIbigNumber(updatedEmployeeInfo.get(8));
        employee.setStatus(updatedEmployeeInfo.get(9));
        employee.setPosition(updatedEmployeeInfo.get(10));
        employee.setImmediateSupervisor(updatedEmployeeInfo.get(11));
        employee.setBasicSalary(parseDouble(updatedEmployeeInfo.get(12)));
        employee.setRiceSubsidy(parseDouble(updatedEmployeeInfo.get(13)));
        employee.setPhoneAllowance(parseDouble(updatedEmployeeInfo.get(14)));
        employee.setClothingAllowance(parseDouble(updatedEmployeeInfo.get(15)));
        employee.setGrossSemimonthlyRate(parseDouble(updatedEmployeeInfo.get(16)));
        employee.setHourlyRate(parseDouble(updatedEmployeeInfo.get(17)));
    }

    /**
     * Parses double values safely, removing commas if necessary.
     */
    private double parseDouble(String value) {
        return Double.parseDouble(value.replace(",", ""));
    }

    /**
     * Custom exception for handling employee not found cases.
     */
    public static class EmployeeNotFoundException extends Exception {

        public EmployeeNotFoundException(String message) {
            super(message);
        }
    }

    /**
     * Custom exception for handling unauthorized access.
     */
    public static class UnauthorizedAccessException extends Exception {

        public UnauthorizedAccessException(String message) {
            super(message);
        }
    }
}
