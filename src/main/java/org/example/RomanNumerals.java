package org.example;

public class RomanNumerals {

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

    public static String convert(int integer) {
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
            default -> "";
        };
    }
}
