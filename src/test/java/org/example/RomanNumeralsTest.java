package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {

    /*
   1 ➔ I
   2 ➔ II
   3 ➔ III
   4 ➔ IV
   5 ➔ V
   9 ➔ IX
  21 ➔ XXI
  50 ➔ L
 100 ➔ C
 500 ➔ D
1000 ➔ M
     */

    @Test
    void convert_exampleTestCases_success() {
        assertEquals("I", RomanNumerals.convert(1));
        assertEquals("II", RomanNumerals.convert(2));
        assertEquals("III", RomanNumerals.convert(3));
        assertEquals("IV", RomanNumerals.convert(4));
        assertEquals("V", RomanNumerals.convert(5));
        assertEquals("IX", RomanNumerals.convert(9));
        assertEquals("XXI", RomanNumerals.convert(21));
        assertEquals("L", RomanNumerals.convert(50));
        assertEquals("C", RomanNumerals.convert(100));
        assertEquals("D", RomanNumerals.convert(500));
        assertEquals("M", RomanNumerals.convert(1000));
    }
}