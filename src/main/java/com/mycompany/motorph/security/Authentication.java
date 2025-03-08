/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import java.io.IOException;
import java.util.Map;

/**
 * This class verifies login credentials.
 *
 * @author Lance
 */
public class Authentication {

    private final Map<String, String[]> credentials;

    /**
     * This initializes the authentication by loading credentials from storage.
     *
     * @throws java.io.IOException
     */
    public Authentication() throws IOException {
        this.credentials = CredentialStorage.loadCredentials();
    }

    /**
     * Validates the login credentials.
     *
     * @param username The username entered by the user
     * @param enteredPassword The password entered by the user
     * @param selectedDivision The user type the user is logging in under
     * @return True if authentication is successful, otherwise false
     */
    public boolean authenticateUser(String username, String enteredPassword, String selectedDivision) {
        if (credentials.containsKey(username)) {
            String[] userData = credentials.get(username);
            String storedHash = userData[0];
            String storedDivision = userData[1];

            return storedDivision.equalsIgnoreCase(selectedDivision)
                    && PasswordManager.verifyPassword(enteredPassword, storedHash);
        }

        return false;
    }
}
