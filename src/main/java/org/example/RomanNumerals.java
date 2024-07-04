package org.example;

import java.util.Map;

import static org.example.DecimalPlaceNumerals.*;

public class RomanNumerals {
    public static final int MAX_NUMERAL = 3999;
    public static final int MIN_NUMERAL = 1;
    public static final Map<Integer, String> SUBTRACTIVE = Map.of(4, "IV", 9, "IX", 40, "XL", 90, "XC", 400, "CD", 900, "CM");

    /*
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
     */

    public static String convert(int integer) {

        //todo properly handle error case
        if (integer > MAX_NUMERAL || integer < MIN_NUMERAL) {
            return "unable to represent integer " + integer + " using roman numerals";
        }

        //split int into decimal places

        String intStr = Integer.toString(integer);

        //handle one digit
        if (intStr.length() == 1) {
            int firstDigit = Integer.parseInt(intStr.substring(0, 1));

            return getOnes(firstDigit);
        }

        //handle two digits
        if (intStr.length() == 2) {
            int firstDigit = Integer.parseInt(intStr.substring(0, 1));
            int secondDigit = Integer.parseInt(intStr.substring(1, 2));

            String ones = getOnes(secondDigit);
            String tens = getTens(firstDigit);

            return tens + ones;
        }

        //handle 3 digits
        if (intStr.length() == 3) {
            int firstDigit = Integer.parseInt(intStr.substring(0, 1));
            int secondDigit = Integer.parseInt(intStr.substring(1, 2));
            int thirdDigit = Integer.parseInt(intStr.substring(2, 3));

            String ones = getOnes(thirdDigit);
            String tens = getTens(secondDigit);
            String hundreds = getHundreds(firstDigit);

            return hundreds + tens + ones;
        }

        if (intStr.length() == 4) {
            int firstDigit = Integer.parseInt(intStr.substring(0, 1));
            int secondDigit = Integer.parseInt(intStr.substring(1, 2));
            int thirdDigit = Integer.parseInt(intStr.substring(2, 3));
            int fourthDigit = Integer.parseInt(intStr.substring(3, 4));

            String ones = getOnes(fourthDigit);
            String tens = getTens(thirdDigit);
            String hundreds = getHundreds(secondDigit);
            String thousands = getThousands(firstDigit);

            return thousands + hundreds + tens + ones;
        }

        //handle subtractive cases
        if (SUBTRACTIVE.containsKey(integer)) {
            return SUBTRACTIVE.get(integer);
        }


        return switch (integer) {
            default -> "not yet handled";
        };
    }

    private static String getThousands(int firstDigit) {
        return switch (firstDigit) {
            case 0 -> "";
            case 1 -> ONE_THOUSAND.getNumeral();
            case 2 -> ONE_THOUSAND.getNumeral() + ONE_THOUSAND.getNumeral();
            case 3 -> ONE_THOUSAND.getNumeral() + ONE_THOUSAND.getNumeral() + ONE_THOUSAND.getNumeral();
            case 4 -> SUBTRACTIVE.get(4 * ONE_THOUSAND.getValue());
            default -> throw new IllegalStateException("Unexpected value: " + firstDigit);
        };
    }

    private static String getHundreds(int firstDigit) {
        return switch (firstDigit) {
            case 0 -> "";
            case 1 -> ONE_HUNDRED.getNumeral();
            case 2 -> ONE_HUNDRED.getNumeral() + ONE_HUNDRED.getNumeral();
            case 3 -> ONE_HUNDRED.getNumeral() + ONE_HUNDRED.getNumeral() + ONE_HUNDRED.getNumeral();
            case 4 -> SUBTRACTIVE.get(4 * ONE_HUNDRED.getValue());
            case 5 -> FIVE_HUNDRED.getNumeral();
            case 6 -> FIVE_HUNDRED.getNumeral() + ONE_HUNDRED.getNumeral();
            case 7 -> FIVE_HUNDRED.getNumeral() + ONE_HUNDRED.getNumeral() + ONE_HUNDRED.getNumeral();
            case 8 -> FIVE_HUNDRED.getNumeral() + ONE_HUNDRED.getNumeral() + ONE_HUNDRED.getNumeral() + ONE_HUNDRED.getNumeral();
            case 9 -> SUBTRACTIVE.get(9 * ONE_HUNDRED.getValue());
            default -> throw new IllegalStateException("Unexpected value: " + firstDigit);
        };
    }

    private static String getTens(int firstDigit) {
        return switch (firstDigit) {
            case 0 -> "";
            case 1 -> TEN.getNumeral();
            case 2 -> TEN.getNumeral() + TEN.getNumeral();
            case 3 -> TEN.getNumeral() + TEN.getNumeral() + TEN.getNumeral();
            case 4 -> SUBTRACTIVE.get(4 * TEN.getValue());
            case 5 -> FIFTY.getNumeral();
            case 6 -> FIFTY.getNumeral() + TEN.getNumeral();
            case 7 -> FIFTY.getNumeral() + TEN.getNumeral() + TEN.getNumeral();
            case 8 -> FIFTY.getNumeral() + TEN.getNumeral() + TEN.getNumeral() + TEN.getNumeral();
            case 9 -> SUBTRACTIVE.get(9 * TEN.getValue());
            default -> throw new IllegalStateException("Unexpected value: " + firstDigit);
        };
    }

    private static String getOnes(int firstDigit) {
        return switch (firstDigit) {
            case 0 -> "";
            case 1 -> ONE.getNumeral();
            case 2 -> ONE.getNumeral() + ONE.getNumeral();
            case 3 -> ONE.getNumeral() + ONE.getNumeral() + ONE.getNumeral();
            case 4 -> SUBTRACTIVE.get(4 * ONE.getValue());
            case 5 -> FIVE.getNumeral();
            case 6 -> FIVE.getNumeral() + ONE.getNumeral();
            case 7 -> FIVE.getNumeral() + ONE.getNumeral() + ONE.getNumeral();
            case 8 -> FIVE.getNumeral() + ONE.getNumeral() + ONE.getNumeral() + ONE.getNumeral();
            case 9 -> SUBTRACTIVE.get(9 * ONE.getValue());
            default -> throw new IllegalStateException("Unexpected value: " + firstDigit);
        };
    }

}
