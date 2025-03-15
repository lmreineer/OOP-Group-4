/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles the secure retrieval of user credentials from the storage file.
 *
 * @author Lance
 */
public class CredentialStorage {

    private static final Logger LOGGER = Logger.getLogger(CredentialStorage.class.getName());
    private static final String FILE_PATH = "src/main/resources/data/login_credentials_hashed.csv";

    /**
     * Reads and loads credentials from the CSV file into a map.
     *
     * @return A map where the key is the username and the value is an array
     * containing the hashed password and division.
     * @throws CredentialStorageException If the credentials file is missing or
     * unreadable
     */
    public static Map<String, String[]> loadCredentials() throws CredentialStorageException {
        Map<String, String[]> credentialsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(",");

                if (credentials.length != 3) {
                    LOGGER.log(Level.WARNING, "Skipping invalid credential entry: {0}", line);
                    continue;
                }

                String username = credentials[0].trim();
                String passwordHash = credentials[1].trim();
                String division = credentials[2].trim();
                credentialsMap.put(username, new String[]{passwordHash, division});
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error loading credentials file: {0}", e.getMessage());
            throw new CredentialStorageException("Failed to load credentials file.", e);
        }

        return credentialsMap;
    }

    /**
     * Custom exception for handling credential storage errors.
     */
    public static class CredentialStorageException extends Exception {

        public CredentialStorageException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
