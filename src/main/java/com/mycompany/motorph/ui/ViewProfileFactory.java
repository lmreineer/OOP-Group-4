/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.ui;

import com.mycompany.motorph.manager.RBACManager;
import com.mycompany.motorph.model.Employee;

/**
 *
 * @author User
 */
public class ViewProfileFactory {

    private static EmployeeSearchPage employeeSearchPage;

    public static ViewProfileFrame createViewProfile(String role, Employee employeeInformation) {
        if (RBACManager.hasPermission(role, "UPDATE") || RBACManager.hasPermission(role, "DELETE")) {
            return new AdminViewProfileFrame(employeeInformation, role, employeeSearchPage);
        } else {
            return new EmployeeViewProfileFrame(employeeInformation);
        }
    }
}
