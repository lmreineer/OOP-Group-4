///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.motorph.security;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
///**
// *
// * @author User
// */
//public class PasswordEncryptor {
//
//    private static final String FILE_PATH = "src/main/resources/data/login_credentials.csv";
//    private static final String OUTPUT_FILE = "src/main/resources/data/login_credentials_hashed.csv";
//
//    public static void main(String[] args) {
//        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH)); BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
//
//            String line;
//            bw.write("Username,Password,Division\n"); // Write header
//
//            br.readLine(); // Skip original header
//
//            while ((line = br.readLine()) != null) {
//                String[] credentials = line.split(",");
//                if (credentials.length == 3) {
//                    String username = credentials[0].trim();
//                    String plaintextPassword = credentials[1].trim();
//                    String division = credentials[2].trim();
//
//                    String hashedPassword = PasswordManager.hashPassword(plaintextPassword);
//                    bw.write(username + "," + hashedPassword + "," + division + "\n");
//                }
//            }
//
//            System.out.println("Passwords hashed successfully! New file: " + OUTPUT_FILE);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
