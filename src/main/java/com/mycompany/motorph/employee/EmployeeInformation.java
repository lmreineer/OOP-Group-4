package com.mycompany.motorph.employee;

import com.mycompany.motorph.model.Employee;
import com.mycompany.motorph.data.EmployeeDataReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class for managing employee information.
 */
public class EmployeeInformation {

    private static final SimpleDateFormat BIRTHDATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    private static final String EMPLOYEES_DATA_PATH = "src/main/resources/data/employee_information.csv";

    /**     
     * Displays employee information for the given employee number.
     * @param employeeNumber
     * @return 
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvValidationException
     * @throws java.text.ParseException
     */
    public List<String> showEmployeeInformation(int employeeNumber) throws IOException, CsvValidationException, ParseException {
        List<Employee> employees = getAllEmployees();
        Employee foundEmployee = findEmployeeByNumber(employees, employeeNumber);
        
        if (foundEmployee != null) {
            return foundEmployee.getEmployeeInformation();
        } else {
            throw new IllegalArgumentException("Employee not found.");
        }
    }

    /**
     * Updates employee information in the CSV file.
     * @param employeeNumber
     * @param updatedEmployeeInfo
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvValidationException
     * @throws java.text.ParseException
     */
    public void updateEmployeeInformationInCsv(int employeeNumber, List<String> updatedEmployeeInfo) throws IOException, CsvValidationException, ParseException {
        EmployeeDataReader employeeDataReader = new EmployeeDataReader();
        List<Employee> employees = employeeDataReader.readEmployees(EMPLOYEES_DATA_PATH);
        
        for (Employee employee : employees) {
            if (employee.getEmployeeNumber() == employeeNumber) {
                updateEmployee(employee, updatedEmployeeInfo);
                break;
            }
        }

        employeeDataReader.writeEmployees(EMPLOYEES_DATA_PATH, employees);
    }

    /**
     * Retrieves all employees from the CSV file.
     */
    public List<Employee> getAllEmployees() throws IOException, CsvValidationException, ParseException {
        EmployeeDataReader employeeDataReader = new EmployeeDataReader();
        return employeeDataReader.readEmployees(EMPLOYEES_DATA_PATH);
    }

    /**
     * Finds an employee by their employee number.
     */
    private Employee findEmployeeByNumber(List<Employee> employees, int employeeNumber) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeNumber() == employeeNumber)
                .findFirst()
                .orElse(null);
    }

    /**
     * Updates an employee's details.
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
        employee.setBasicSalary(Double.parseDouble(updatedEmployeeInfo.get(12).replace(",", "")));
        employee.setRiceSubsidy(Double.parseDouble(updatedEmployeeInfo.get(13).replace(",", "")));
        employee.setPhoneAllowance(Double.parseDouble(updatedEmployeeInfo.get(14).replace(",", "")));
        employee.setClothingAllowance(Double.parseDouble(updatedEmployeeInfo.get(15).replace(",", "")));
        employee.setGrossSemimonthlyRate(Double.parseDouble(updatedEmployeeInfo.get(16).replace(",", "")));
        employee.setHourlyRate(Double.parseDouble(updatedEmployeeInfo.get(17).replace(",", "")));
    }
    public void deleteEmployeeFromCsv(int employeeNumber) throws IOException, CsvValidationException {
        try {
            EmployeeDataReader employeeDataReader = new EmployeeDataReader();
            List<Employee> employees = employeeDataReader.readEmployees(EMPLOYEES_DATA_PATH);
            
            // Remove the employee with the matching employee number
            employees.removeIf(employee -> employee.getEmployeeNumber() == employeeNumber);
            
            // Write updated list back to CSV
            employeeDataReader.writeEmployees(EMPLOYEES_DATA_PATH, employees);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
