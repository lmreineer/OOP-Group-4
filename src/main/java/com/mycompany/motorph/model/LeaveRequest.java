/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mark
 */
public class LeaveRequest extends Employee {
    
    public LeaveRequest(){};

    public LeaveRequest(int empID, String leaveStatus, String leaveRemarks) {
        this.leaveStatus = leaveStatus;
        this.leaveRemarks = leaveRemarks;
        this.leaveRequestID = empID;
    }

    private String startDate;
    private String endDate;
    private String leaveRequestPurpose;
    private String leaveStatus;
    private String name;
    private String leaveRemarks;
    private int leaveRequestID;

    public int getLeaveRequestID() {
        return leaveRequestID;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getLeaveRemarks() {
        return leaveRemarks;
    }

    public void setLeaveRemarks(String leaveRemarks) {
        this.leaveRemarks = leaveRemarks;
    }

//    private double numberOfDays;
    public void setLeaveRequestPurpose(String leaveRequestPurpose) {
        this.leaveRequestPurpose = leaveRequestPurpose;
    }

    public String getLeaveRequestPurpose() {
        return leaveRequestPurpose;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

//    public double getNumberOfDays() {
//        return numberOfDays;
//    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

//    public void setNumberOfDays(double numberOfDays) {
//        this.numberOfDays = numberOfDays;
//    }
//    private static double calculateNumberOfDays() {
//
//        LocalDateTime startDate;
//        LocalDateTime EndDate;
//        long daysBetween = Duration.between(startDate, EndDate).toDays();
//   
//        return daysBetween;
//    }
//            
    /**
     *
     * @return
     */
public static List<LeaveRequest> getLeaveRequestList() {
    String filepath = "src\\main\\resources\\data\\Employee_leave_requests.csv";

    List<LeaveRequest> leaveRequestList = new ArrayList<>();

    File file = new File(filepath);
    if (!file.exists()) {
        JOptionPane.showMessageDialog(null, "File not found: " + filepath);
        return leaveRequestList; // Return an empty list instead of null
    }

    try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
        String str = br.readLine(); // Skip header

        while ((str = br.readLine()) != null) {
            String[] values = str.split(",");

            if (values.length < 7) {
                System.err.println("Invalid row: " + str);
                continue;
            }

            LeaveRequest leaveRequestInfo = new LeaveRequest();
            leaveRequestInfo.setEmployeeNumber(Integer.parseInt(values[0].trim()));
            leaveRequestInfo.setName(values[1].trim());
            leaveRequestInfo.setStartDate(values[2].trim());
            leaveRequestInfo.setEndDate(values[3].trim());
            leaveRequestInfo.setLeaveRequestPurpose(values[4].trim());
            leaveRequestInfo.setLeaveStatus(values[5].trim());
            leaveRequestInfo.setLeaveRemarks(values[6].trim());

            leaveRequestList.add(leaveRequestInfo);
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace(); // Print error details
        JOptionPane.showMessageDialog(null, "Error reading leave request file: " + e.getMessage());
    }

    return leaveRequestList;
}

    
    
    
        public void updateLeaveRequest(LeaveRequest updatedLeaveRequest) {
        String filepath = "src\\main\\resources\\data\\Employee_leave_requests.csv";
        StringBuilder updatedCsvContent = new StringBuilder();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                // Skip the row if it matches the employee ID and we are updating
                if (Integer.parseInt(values[0]) == updatedLeaveRequest.getLeaveRequestID()) {
                    
                        // Update values for the matching employee
                        
                        values[5] = updatedLeaveRequest.getLeaveStatus();
                        values[6] = updatedLeaveRequest.getLeaveRemarks();
                }

                // Append all lines (including the updated one) to the new content
                updatedCsvContent.append(String.join(",", values)).append("\n");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        // Then write the updated content back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(updatedCsvContent.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
        public static DefaultTableModel getLeaveRequestTableModel() {
        String[] headers = {"ID", "Name", "Start_Date", "End_Date", "Purpose", "Status", "Remarks"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);

        try {
            // Get the leave request data
            List<LeaveRequest> leaveRequestList = LeaveRequest.getLeaveRequestList();

            if (leaveRequestList == null || leaveRequestList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No leave requests found.");
                return model;
            }

            for (LeaveRequest leave : leaveRequestList) {
                int id = leave.getEmployeeNumber();
                String name = leave.getName();
                String startDate = leave.getStartDate();
                String endDate = leave.getEndDate();
                String leavePurpose = leave.getLeaveRequestPurpose();
                String leaveStatus = leave.getLeaveStatus();
                String leaveRemarks = leave.getLeaveRemarks();
                Object[] rowData = {id, name, startDate, endDate, leavePurpose, leaveStatus, leaveRemarks};
                model.addRow(rowData);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return model;
    }
}
