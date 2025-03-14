/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class RBACManager {

    private static final Map<String, String[]> rolePermissions = new HashMap<>();

    static {
        rolePermissions.put("ADMIN", new String[]{"VIEW", "UPDATE", "DELETE"});
        rolePermissions.put("EMPLOYEE", new String[]{"VIEW"});
        rolePermissions.put("IT", new String[]{"VIEW", "UPDATE"});
    }

    public static boolean hasPermission(String role, String permission) {
        String[] permissions = rolePermissions.get(role);
        if (permissions == null) {
            return false;
        }
        for (String perm : permissions) {
            if (perm.equalsIgnoreCase(permission)) {
                return true;
            }
        }
        return false;
    }
}
