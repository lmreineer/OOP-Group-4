/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import java.io.IOException;

/**
 * Manages the authentication and password security.
 *
 * @author Lance
 */
public class SecurityManager {

    private final Authentication authentication;

    /**
     * Initializes the security manager and authentication.
     *
     * @throws java.io.IOException
     */
    public SecurityManager() throws IOException {
        this.authentication = new Authentication();
    }

    /**
     * Authenticates a user by verifying their login credentials.
     *
     * @param username The username entered by the user
     * @param password The password entered by the user
     * @param division The user type the user is logging in under
     * @return True if authentication is successful, otherwise false
     */
    public boolean login(String username, String password, String division) {
        return authentication.authenticateUser(username, password, division);
    }

    /**
     * Generates a hashed password.
     *
     * @param password The plaintext password to be hashed
     * @return The hashed password
     */
    public String createHashedPassword(String password) {
        return PasswordManager.hashPassword(password);
    }
}
