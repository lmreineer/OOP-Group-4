/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Handles password encryption and verification securely using bcrypt.
 *
 * @author Lance
 */
public class PasswordManager {

    private static final Logger LOGGER = Logger.getLogger(PasswordManager.class.getName());
    private static final int SALT_ROUNDS = 12;

    /**
     * Hashes a password using bcrypt with predefined salt rounds.
     *
     * @param password The plaintext password to be hashed
     * @return The hashed password
     * @throws PasswordEncryptionException If hashing fails
     */
    public static String hashPassword(String password) throws PasswordEncryptionException {
        try {
            if (password == null || password.trim().isEmpty()) {
                throw new IllegalArgumentException("Password cannot be null or empty.");
            }
            return BCrypt.hashpw(password, BCrypt.gensalt(SALT_ROUNDS));
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "Error hashing password: {0}", e.getMessage());
            throw new PasswordEncryptionException("Password hashing failed.", e);
        }
    }

    /**
     * Verifies if the entered password matches the stored hashed password.
     *
     * @param enteredPassword The user-entered password
     * @param storedHash The stored hashed password
     * @return True if passwords match, otherwise false
     */
    public static boolean verifyPassword(String enteredPassword, String storedHash) {
        if (enteredPassword == null || storedHash == null) {
            LOGGER.log(Level.WARNING, "Password verification failed due to null values.");
            return false;
        }
        boolean match = BCrypt.checkpw(enteredPassword, storedHash);
        if (!match) {
            LOGGER.log(Level.WARNING, "Incorrect password attempt.");
        }
        return match;
    }

    /**
     * Custom exception for handling password encryption errors.
     */
    public static class PasswordEncryptionException extends Exception {

        public PasswordEncryptionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
