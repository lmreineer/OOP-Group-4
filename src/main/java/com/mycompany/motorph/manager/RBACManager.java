/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class ensures secure role-based permission handling and prevents
 * unauthorized access.
 *
 * @author Lance
 */
public class RBACManager {

    private static final Logger LOGGER = Logger.getLogger(RBACManager.class.getName());
    private static final Map<String, Set<String>> rolePermissions = new HashMap<>();

    static {
        rolePermissions.put("ADMIN", Set.of("VIEW", "UPDATE", "DELETE"));
        rolePermissions.put("EMPLOYEE", Set.of("VIEW"));
        rolePermissions.put("IT", Set.of("VIEW", "UPDATE"));
    }

    /**
     * Checks if a role has a specific permission.
     *
     * @param role The role of the user
     * @param permission The required permission
     * @return true if the role has the permission, false otherwise
     * @throws InvalidRoleException If the role does not exist
     */
    public static boolean hasPermission(String role, String permission) throws InvalidRoleException {
        Set<String> permissions = rolePermissions.get(role);
        if (permissions == null) {
            throw new InvalidRoleException("Invalid role: " + role);
        }

        boolean hasPermission = permissions.contains(permission.toUpperCase());
        if (!hasPermission) {
            LOGGER.log(Level.WARNING, "Unauthorized access attempt: Role '{0}' tried to access '{1}'", new Object[]{role, permission});
        }
        return hasPermission;
    }

    /**
     * Adds a new role with permissions.
     *
     * @param role The new role to add
     * @param permissions The set of permissions
     */
    public static void addRole(String role, Set<String> permissions) {
        rolePermissions.put(role.toUpperCase(), new HashSet<>(permissions));
    }

    /**
     * Custom exception for handling invalid roles.
     */
    public static class InvalidRoleException extends Exception {

        public InvalidRoleException(String message) {
            super(message);
        }
    }
}
