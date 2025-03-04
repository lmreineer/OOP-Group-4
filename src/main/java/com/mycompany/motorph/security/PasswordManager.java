/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import org.mindrot.jbcrypt.BCrypt;

/**
 * This handles password encryption and verification using bcrypt hashing.
 *
 * @author Lance
 */
public class PasswordManager {

    /**
     * This method hashes a password using bcrypt.
     *
     * @param password The plaintext password to be hashed
     * @return The hashed password
     */
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12)); // Generate a hash with 12 salt rounds
    }

    /**
     * Verifies if the entered password matches the hashed password stored in
     * the file.
     *
     * @param enteredPassword The user-entered password
     * @param storedHash The stored hashed password
     * @return True if passwords match otherwise false
     */
    public static boolean verifyPassword(String enteredPassword, String storedHash) {
        return BCrypt.checkpw(enteredPassword, storedHash);
    }
}
