/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import com.mycompany.motorph.security.Authentication.AuthenticationException;
import com.mycompany.motorph.security.PasswordManager.PasswordEncryptionException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manages authentication and password security
 *
 * @author Lance
 */
public class SecurityManager {

    private static final Logger LOGGER = Logger.getLogger(SecurityManager.class.getName());
    private final Authentication authentication;

    /**
     * Initializes the security manager and authentication.
     *
     * @throws IOException If credential loading fails
     * @throws
     * com.mycompany.motorph.security.CredentialStorage.CredentialStorageException
     */
    public SecurityManager() throws IOException, CredentialStorage.CredentialStorageException {
        this.authentication = new Authentication();
    }

    /**
     * Authenticates a user by verifying their login credentials.
     *
     * @param username The username entered by the user
     * @param password The password entered by the user
     * @param division The user type the user is logging in under
     * @return True if authentication is successful, otherwise false
     * @throws AuthenticationException If authentication fails
     */
    public boolean login(String username, String password, String division) throws AuthenticationException {
        if (username == null || password == null || division == null) {
            LOGGER.log(Level.WARNING, "Login attempt with missing credentials.");
            throw new AuthenticationException("Username, password, and division cannot be null.");
        }

        boolean isAuthenticated = authentication.authenticateUser(username, password, division);

        if (!isAuthenticated) {
            LOGGER.log(Level.WARNING, "Failed login attempt for user: {0}", username);
        }
        return isAuthenticated;
    }

    /**
     * Generates a hashed password securely.
     *
     * @param password The plaintext password to be hashed
     * @return The hashed password
     * @throws PasswordEncryptionException If hashing fails
     */
    public String createHashedPassword(String password) throws PasswordEncryptionException {
        if (password == null || password.trim().isEmpty()) {
            throw new PasswordEncryptionException("Password cannot be empty.", new IllegalArgumentException());
        }

        String hashedPassword = PasswordManager.hashPassword(password);
        return hashedPassword;
    }
}
