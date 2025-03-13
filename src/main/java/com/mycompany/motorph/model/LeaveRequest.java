package com.mycompany.motorph.model;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LeaveRequest {

    private int employeeNumber;
    private String startDate;
    private String endDate;
    private String leaveRequestPurpose;
    private String leaveStatus;
    private String name;
    private String leaveRemarks;
    private int leaveRequestID;

    public LeaveRequest() {
    }

    ;

    public LeaveRequest(int empID, String leaveStatus, String leaveRemarks) {
        this.leaveStatus = leaveStatus;
        this.leaveRemarks = leaveRemarks;
        this.leaveRequestID = empID;
    }

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

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public static List<LeaveRequest> getLeaveRequestList() {
        String filepath = "src/main/resources/data/Employee_leave_requests.csv";
        List<LeaveRequest> leaveRequestList = new ArrayList<>();
        File file = new File(filepath);

        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "File not found: " + filepath);
            return leaveRequestList;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String str = br.readLine(); // Skip the header
            while ((str = br.readLine()) != null) {
                String[] values = str.split(",");

                if (values.length < 7) {
                    System.err.println("Invalid row: " + str);
                    continue;
                }

                LeaveRequest leaveRequestInfo = new LeaveRequest();
                leaveRequestInfo.employeeNumber = Integer.parseInt(values[0].replace("\"", "").trim()); // Fix NumberFormatException
                leaveRequestInfo.setName(values[1].replace("\"", "").trim());
                leaveRequestInfo.setStartDate(values[2].replace("\"", "").trim());
                leaveRequestInfo.setEndDate(values[3].replace("\"", "").trim());
                leaveRequestInfo.setLeaveRequestPurpose(values[4].replace("\"", "").trim());
                leaveRequestInfo.setLeaveStatus(values[5].replace("\"", "").trim());
                leaveRequestInfo.setLeaveRemarks(values[6].replace("\"", "").trim());

                leaveRequestList.add(leaveRequestInfo);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading leave request file: " + e.getMessage());
        }
        return leaveRequestList;
    }

    public void updateLeaveRequest(LeaveRequest updatedLeaveRequest) {
        String filepath = "src/main/resources/data/Employee_leave_requests.csv";
        StringBuilder updatedCsvContent = new StringBuilder();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[0]) == updatedLeaveRequest.getLeaveRequestID()) {
                    values[5] = updatedLeaveRequest.getLeaveStatus();
                    values[6] = updatedLeaveRequest.getLeaveRemarks();
                }
                updatedCsvContent.append(String.join(",", values)).append("\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

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
            List<LeaveRequest> leaveRequestList = LeaveRequest.getLeaveRequestList();
            if (leaveRequestList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No leave requests found.");
                return model;
            }
            for (LeaveRequest leave : leaveRequestList) {
                Object[] rowData = {
                    leave.employeeNumber, leave.getName(), leave.getStartDate(), leave.getEndDate(),
                    leave.getLeaveRequestPurpose(), leave.getLeaveStatus(), leave.getLeaveRemarks()
                };
                model.addRow(rowData);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return model;
    }
}
