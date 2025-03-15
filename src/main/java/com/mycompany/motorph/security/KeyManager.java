/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * Manages AES encryption keys securely.
 *
 * Generates and retrieves AES encryption keys dynamically.
 *
 * @author Lance
 */
public class KeyManager {

    private static SecretKey secretKey;

    /**
     * Generates a secure AES key if not already generated.
     *
     * @return The AES secret key in bytes
     */
    public static byte[] getEncryptionKey() {
        if (secretKey == null) {
            try {
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                // AES-128
                keyGen.init(128, new SecureRandom());
                secretKey = keyGen.generateKey();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(KeyManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return secretKey.getEncoded();
    }

    /**
     * Retrieves the AES key as a Base64-encoded string.
     *
     * @return The Base64-encoded AES key
     * @throws Exception If key retrieval fails
     */
    public static String getEncodedKey() throws Exception {
        return Base64.getEncoder().encodeToString(getEncryptionKey());
    }
}
