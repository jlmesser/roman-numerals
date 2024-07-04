package org.example;

public class RomanNumerals {

    public static String convert(int integer) {

        //todo properly handle error case
        if (integer > 3999 || integer < 1) {
            return "unable to represent integer " + integer + " using roman numerals";
        }

        return switch (integer) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 9 -> "IX";
            case 21 -> "XXI";
            case 50 -> "L";
            case 100 -> "C";
            case 500 -> "D";
            case 1000 -> "M";
            case 10 -> "X";
            case 40 -> "XL";
            case 90 -> "XC";
            case 400 -> "CD";
            case 900 -> "CM";
            default -> "";
        };
    }
}
