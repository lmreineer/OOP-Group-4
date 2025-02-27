/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.motorph.calculation;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lance1
 */
public class WithholdingTaxCalculationTest {

    // Margin of error for comparisons with double
    private static final double DELTA = 0.001;

    private static final double MAX_TAXABLE_INCOME = 80000.0;

    @Test
    public void calculateWithholdingTax_NotEligibleForWithholdingTax() {
        // Create a sample gross wage that is not eligible to get a withholding tax
        double grossWage = 20000.0;

        WithholdingTaxCalculation withholdingTaxCalculation = new WithholdingTaxCalculation();
        double withholdingTax;
        try {
            withholdingTax = withholdingTaxCalculation.calculateWithholdingTax(grossWage);
             assertEquals(0.0, withholdingTax, DELTA, "Withholding tax should be zero for gross wage below taxable income");
        } catch (IOException ex) {
            Logger.getLogger(WithholdingTaxCalculationTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(WithholdingTaxCalculationTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Assert that the withholding tax calculated is zero
      
    }

    @Test
    public void calculateWithholdingTax_EligibleForWithholdingTax() {
        // Create a sample gross wage that is assigned to the maximum taxable income range eligible for deductions
        double grossWage = MAX_TAXABLE_INCOME;

        WithholdingTaxCalculation withholdingTaxCalculation = new WithholdingTaxCalculation();
        double withholdingTax;
        try {
            withholdingTax = withholdingTaxCalculation.calculateWithholdingTax(grossWage);
             assertTrue(withholdingTax > 0.0, "Withholding tax should be greater than zero for gross wage equal to maximum taxable income");
        } catch (IOException ex) {
            Logger.getLogger(WithholdingTaxCalculationTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(WithholdingTaxCalculationTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Assert that the withholding tax calculated is greater than zero
       
    }
}
