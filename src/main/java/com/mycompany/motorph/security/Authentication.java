/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles user authentication securely with logging.
 *
 * @author Lance
 */
public class Authentication {

    private static final Logger LOGGER = Logger.getLogger(Authentication.class.getName());
    private static final Map<String, Integer> loginAttempts = new ConcurrentHashMap<>();
    private static final int MAX_ATTEMPTS = 5;
    private final Map<String, String[]> credentials;

    /**
     * Initializes authentication by loading credentials from storage.
     *
     * @throws IOException If credential loading fails
     * @throws
     * com.mycompany.motorph.security.CredentialStorage.CredentialStorageException
     */
    public Authentication() throws IOException, CredentialStorage.CredentialStorageException {
        this.credentials = CredentialStorage.loadCredentials();
    }

    /**
     * Validates user login credentials securely.
     *
     * @param username The username entered by the user
     * @param enteredPassword The password entered by the user
     * @param selectedDivision The user type the user is logging in under
     * @return True if authentication is successful, otherwise false
     * @throws AuthenticationException If authentication fails
     */
    public boolean authenticateUser(String username, String enteredPassword, String selectedDivision) throws AuthenticationException {
        if (!credentials.containsKey(username)) {
            logFailedAttempt(username);
            throw new AuthenticationException("Invalid username or password.");
        }

        String[] userData = credentials.get(username);
        String storedHash = userData[0];
        String storedDivision = userData[1];

        if (storedDivision.equalsIgnoreCase(selectedDivision) && PasswordManager.verifyPassword(enteredPassword, storedHash)) {
            return true;
        }

        logFailedAttempt(username);
        throw new AuthenticationException("Invalid username or password.");
    }

    /**
     * Logs failed login attempts to track potential brute-force attacks.
     */
    private void logFailedAttempt(String username) {
        loginAttempts.put(username, loginAttempts.getOrDefault(username, 0) + 1);
        LOGGER.log(Level.WARNING, "Failed login attempt for user: {0}",
                new Object[]{username, loginAttempts.get(username), MAX_ATTEMPTS});
    }

    /**
     * Custom exception for handling authentication errors.
     */
    public static class AuthenticationException extends Exception {

        public AuthenticationException(String message) {
            super(message);
        }
    }
}
