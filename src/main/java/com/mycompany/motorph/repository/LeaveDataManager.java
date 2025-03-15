/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.repository;

import com.mycompany.motorph.model.Leave;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Manages leave applications.
 *
 * @author Lance
 */
public class LeaveDataManager {

    private static final Logger LOGGER = Logger.getLogger(LeaveDataManager.class.getName());
    private static final String LEAVE_REQUESTS_PATH = "src/main/resources/data/Employee_leave_requests.csv";
    private static final String[] HEADER = {"Employee Number", "Leave Type", "Start Date", "End Date", "Reason", "Sick Leave", "Vacation Leave", "Emergency Leave"};

    /**
     * Saves a leave application to the CSV file.
     *
     * @param leave The leave application to be saved
     * @throws LeaveDataException If an error occurs
     */
    public void saveLeaveApplication(Leave leave) throws LeaveDataException {
        try {
            List<Leave> leaves = loadLeaveApplications();

            if (leaves.stream().anyMatch(l -> l.getEmployeeNumber() == leave.getEmployeeNumber())) {
                throw new LeaveDataException("Record already exists for employee number: " + leave.getEmployeeNumber());
            }

            leaves.add(leave);
            writeLeaveData(leaves);

        } catch (IOException | CsvValidationException e) {
            LOGGER.log(Level.SEVERE, "Error saving leave application: {0}", e.getMessage());
            throw new LeaveDataException("Failed to save leave application.", e);
        }
    }

    /**
     * Retrieves leave applications for a specific employee.
     *
     * @param employeeNumber
     * @return employeeLeaves
     * @throws
     * com.mycompany.motorph.repository.LeaveDataManager.LeaveDataException
     */
    public List<Leave> getLeavesByEmployeeNumber(int employeeNumber) throws LeaveDataException {
        try {
            List<Leave> allLeaves = loadLeaveApplications();
            List<Leave> employeeLeaves = allLeaves.stream()
                    .filter(leave -> leave.getEmployeeNumber() == employeeNumber)
                    .collect(Collectors.toList());

            if (employeeLeaves.isEmpty()) {
                throw new LeaveDataException("No leave information found for employee number: " + employeeNumber);
            }
            return employeeLeaves;

        } catch (IOException | CsvValidationException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving leave data: {0}", e.getMessage());
            throw new LeaveDataException("Failed to retrieve leave data.", e);
        }
    }

    /**
     * Retrieves leave applications for a specific employee.
     *
     * @return leaves
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvValidationException
     */
    public List<Leave> loadLeaveApplications() throws IOException, CsvValidationException {
        List<Leave> leaves = new ArrayList<>();
        File file = new File(LEAVE_REQUESTS_PATH);

        if (file.exists()) {
            try (CSVReader reader = new CSVReader(new FileReader(file))) {
                String[] data;
                boolean firstLine = true;

                while ((data = reader.readNext()) != null) {
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }
                    Leave leave = new Leave(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3],
                            data[4]
                    );
                    leave.setSickLeaveAmount(Double.parseDouble(data[5]));
                    leave.setVacationLeaveAmount(Double.parseDouble(data[6]));
                    leave.setEmergencyLeaveAmount(Double.parseDouble(data[7]));
                    leaves.add(leave);
                }
            }
        }
        return leaves;
    }

    /**
     * Writes leave data securely to the CSV file.
     */
    private void writeLeaveData(List<Leave> leaves) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(LEAVE_REQUESTS_PATH))) {
            writer.writeNext(HEADER);
            for (Leave l : leaves) {
                writer.writeNext(new String[]{
                    String.valueOf(l.getEmployeeNumber()),
                    l.getLeaveType(),
                    l.getStartDate(),
                    l.getEndDate(),
                    l.getReason(),
                    String.valueOf(l.getSickLeaveAmount()),
                    String.valueOf(l.getVacationLeaveAmount()),
                    String.valueOf(l.getEmergencyLeaveAmount())
                });
            }
        }
    }

    /**
     * Custom exception for handling leave data errors.
     */
    public static class LeaveDataException extends Exception {

        public LeaveDataException(String message) {
            super(message);
        }

        public LeaveDataException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
