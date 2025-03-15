/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Provides secure AES encryption and decryption functionality.
 *
 * @author Lance
 */
public class Encryption {

    private static final Logger LOGGER = Logger.getLogger(Encryption.class.getName());
    private static final String ALGORITHM = "AES";

    // Secure key retrieval
    private static final byte[] KEY = KeyManager.getEncryptionKey();

    /**
     * Encrypts a given plaintext string using AES encryption.
     *
     * @param data The plaintext string to be encrypted
     * @return The encrypted string encoded in Base64
     * @throws EncryptionException If an error occurs during encryption
     */
    public static String encrypt(String data) throws EncryptionException {
        try {
            SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);

            Cipher cipher = Cipher.getInstance(ALGORITHM);

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(data.getBytes());

            String encryptedData = Base64.getEncoder().encodeToString(encryptedBytes);

            return encryptedData;
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            LOGGER.log(Level.SEVERE, "Error during encryption: {0}", e.getMessage());
            throw new EncryptionException("Encryption failed.", e);
        }
    }

    /**
     * Decrypts an AES-encrypted Base64-encoded string.
     *
     * @param encryptedData The Base64-encoded encrypted string
     * @return The decrypted plaintext string
     * @throws EncryptionException If an error occurs during decryption
     */
    public static String decrypt(String encryptedData) throws EncryptionException {
        try {
            SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);

            Cipher cipher = Cipher.getInstance(ALGORITHM);

            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);

            String decryptedData = new String(cipher.doFinal(decodedBytes));

            return decryptedData;
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            LOGGER.log(Level.SEVERE, "Error during decryption: {0}", e.getMessage());
            throw new EncryptionException("Decryption failed.", e);
        }
    }

    /**
     * Custom exception for handling encryption errors.
     */
    public static class EncryptionException extends Exception {

        public EncryptionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
