/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Provides AES encryption and decryption functionality.
 *
 * @author Lance
 */
public class Encryption {

    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "MotorPHSecretKey1".getBytes(); // Must be 16 bytes for AES-128

    /**
     * Encrypts a given plaintext string using AES encryption.
     *
     * @param data The plaintext string to be encrypted
     * @return The encrypted string encoded in Base64
     * @throws Exception If an error occurs during encryption
     */
    public static String encrypt(String data) throws Exception {
        try {
            // Create AES key
            SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);

            // Initialize Cipher
            Cipher cipher = Cipher.getInstance(ALGORITHM);

            // Set mode to encryption
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt data
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            // Encode to Base64
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new Exception("Error during encryption: " + e.getMessage(), e);
        }
    }

    /**
     * Decrypts an AES-encrypted Base64-encoded string.
     *
     * @param encryptedData The Base64-encoded encrypted string
     * @return The decrypted plaintext string
     * @throws Exception If an error occurs during decryption
     */
    public static String decrypt(String encryptedData) throws Exception {
        try {
            // Create AES key
            SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);

            // Initialize Cipher
            Cipher cipher = Cipher.getInstance(ALGORITHM);

            // Set mode to decryption
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Decode Base64
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);

            // Decrypt and return plaintext
            return new String(cipher.doFinal(decodedBytes));
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new Exception("Error during decryption: " + e.getMessage(), e);
        }
    }
}
