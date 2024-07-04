package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {

    //todo remove duplicate cases

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

    @Test
    void convert_singleNumeralCases_success() {
        assertEquals("I", RomanNumerals.convert(1));
        assertEquals("V", RomanNumerals.convert(5));
        assertEquals("X", RomanNumerals.convert(10));
        assertEquals("L", RomanNumerals.convert(50));
        assertEquals("C", RomanNumerals.convert(100));
        assertEquals("D", RomanNumerals.convert(500));
        assertEquals("M", RomanNumerals.convert(1000));
    }

    @Test
    void convert_intOutOfRange_failure() {
        assertEquals("unable to represent integer " + -1 + " using roman numerals", RomanNumerals.convert(-1));
        assertEquals("unable to represent integer " + 4000 + " using roman numerals", RomanNumerals.convert(4000));
    }

    @Test
    void convert_subtractiveCases_success() {
        assertEquals("IV", RomanNumerals.convert(4));
        assertEquals("IX", RomanNumerals.convert(9));
        assertEquals("XL", RomanNumerals.convert(40));
        assertEquals("XC", RomanNumerals.convert(90));
        assertEquals("CD", RomanNumerals.convert(400));
        assertEquals("CM", RomanNumerals.convert(900));
    }

    @Test
    void convert_singleDigitCases_success() {
        assertEquals("I", RomanNumerals.convert(1));
        assertEquals("II", RomanNumerals.convert(2));
        assertEquals("III", RomanNumerals.convert(3));
        assertEquals("IV", RomanNumerals.convert(4));
        assertEquals("V", RomanNumerals.convert(5));
        assertEquals("VI", RomanNumerals.convert(6));
        assertEquals("VII", RomanNumerals.convert(7));
        assertEquals("VIII", RomanNumerals.convert(8));
        assertEquals("IX", RomanNumerals.convert(9));
    }

    @Test
    void convert_doubleDigitCases_success() {
        assertEquals("X", RomanNumerals.convert(10));
        assertEquals("XX", RomanNumerals.convert(20));
        assertEquals("XXX", RomanNumerals.convert(30));
        assertEquals("XL", RomanNumerals.convert(40));
        assertEquals("L", RomanNumerals.convert(50));
        assertEquals("LX", RomanNumerals.convert(60));
        assertEquals("LXX", RomanNumerals.convert(70));
        assertEquals("LXXX", RomanNumerals.convert(80));
        assertEquals("XC", RomanNumerals.convert(90));
    }

    @Test
    void convert_tripleDigitCases_success() {
        assertEquals("C", RomanNumerals.convert(100));
        assertEquals("CC", RomanNumerals.convert(200));
        assertEquals("CCC", RomanNumerals.convert(300));
        assertEquals("CD", RomanNumerals.convert(400));
        assertEquals("D", RomanNumerals.convert(500));
        assertEquals("DC", RomanNumerals.convert(600));
        assertEquals("DCC", RomanNumerals.convert(700));
        assertEquals("DCCC", RomanNumerals.convert(800));
        assertEquals("CM", RomanNumerals.convert(900));
    }

    @Test
    void convert_quadDigitCases_success() {
        assertEquals("M", RomanNumerals.convert(1000));
        assertEquals("MM", RomanNumerals.convert(2000));
        assertEquals("MMM", RomanNumerals.convert(3000));
        assertEquals("unable to represent integer " + 4000 + " using roman numerals", RomanNumerals.convert(4000));
    }

    //misc examples with more complex numbers - i.e. numbers not multiples of 10/100/1000 etc

    @Test
    void convert_complexNumberCases_success() {
        assertEquals("XXXIX", RomanNumerals.convert(39));
        assertEquals("CCXLVI", RomanNumerals.convert(246));
        assertEquals("DCCLXXXIX", RomanNumerals.convert(789));
        assertEquals("MMCDXXI", RomanNumerals.convert(2421));
        //containing zeros
        assertEquals("CLX", RomanNumerals.convert(160));
        assertEquals("CCVII", RomanNumerals.convert(207));
        assertEquals("MIX", RomanNumerals.convert(1009));
        assertEquals("MLXVI", RomanNumerals.convert(1066));
    }




    //todo find csv dataset of mappings? make it? import as datasource for parameterized test
    //all valid int cases (<4000) from csv


    //Subtractive notation is used for 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).


    //A number containing two or more decimal digits is built by appending the Roman numeral equivalent for each, from highest to lowest
    //0 is omitted
    //The largest number that can be represented in this manner is 3,999

    /*
    check valid int
    split int into 1s, 10s, 100s etc
    map each split int to a set of 1-3 numerals related to unit
        check for Subtractive cases (starts with 4 or 9)
        check for starts with 1 or 5 (will map to single numeral?)
            1 -> 1 of numeral
            5 -> 1 of next numeral
        else (2,3,6,7,8)
            2 -> 2 of numeral
            3 -> 3 of numeral
            6 -> 1 of next numeral + 1 of numeral
            7 -> 1 of next numeral + 2 of numeral
            8 -> 1 of next numeral + 3 of numeral

    combine numerals into full string

    e.g. 2,421

    2000 = 1000 + 1000 = MM
    400 = CD
    20 = 10 + 10 = XX
    1 = I

    2,421 = MM + CD + XX + I = MMCDXXI.
     */

    //other test cases

    /*
    single numeral numbers
    I -> 1
    V -> 5
    X -> 10
    L -> 50
    C -> 100
    D -> 500
    M -> 1000

    when to combine numerals

    each numeral max 3 in a row?
    I, II, III

    then go up to next numeral -1
    IV

    then next numeral following up to 3 current numeral
    V, VI, VII, VIII


    XXX = 10 + 10 + 10 = 30
    40 = 50 - 10 = XL




     */
}