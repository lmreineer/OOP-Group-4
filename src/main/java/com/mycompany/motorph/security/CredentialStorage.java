/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles the secure retrieval of user credentials from the storage file.
 *
 * @author Lance
 */
public class CredentialStorage {

    private static final String FILE_PATH = "src/main/resources/data/login_credentials_hashed.csv";

    /**
     * Reads and loads credentials from the CSV file into a map.
     *
     * @return A map where the key is the username and the value is an array
     * which contains the hashed password and division.
     * @throws java.io.FileNotFoundException
     */
    public static Map<String, String[]> loadCredentials() throws FileNotFoundException, IOException {
        Map<String, String[]> credentialsMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        String line;

        // Skip header
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] credentials = line.split(",");

            if (credentials.length == 3) {
                String username = credentials[0].trim();
                String passwordHash = credentials[1].trim();
                String division = credentials[2].trim();

                credentialsMap.put(username, new String[]{passwordHash, division});
            }
        }

        return credentialsMap;
    }
}
