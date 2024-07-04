package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.example.DecimalPlaceNumerals.*;

public class RomanNumerals {
    public static final int MAX_NUMERAL = 3999;
    public static final int MIN_NUMERAL = 1;
    public static final Map<Integer, String> SUBTRACTIVE = Map.of(4, "IV", 9, "IX", 40, "XL", 90, "XC", 400, "CD", 900, "CM");

    public static String convert(int integer) {

        //todo properly handle error case
        if (integer > MAX_NUMERAL || integer < MIN_NUMERAL) {
            return "unable to represent integer " + integer + " using roman numerals";
        }

        String intStr = Integer.toString(integer);

        ArrayList<String> objects = new ArrayList<>(Arrays.asList(intStr.split("")));

        List<String> reversed = objects.reversed();

        ArrayList<String> sb = new ArrayList<>();

        int size = reversed.size();
        for (int i = 0; i < size; i++) {
            int digit = Integer.parseInt(reversed.removeFirst());

            switch (i) {
                case 0 -> sb.add(getMapped(digit, ONE, FIVE));
                case 1 -> sb.add(getMapped(digit, TEN, FIFTY));
                case 2 -> sb.add(getMapped(digit, ONE_HUNDRED, FIVE_HUNDRED));
                case 3 -> sb.add(getMapped(digit, ONE_THOUSAND, ONE_THOUSAND));
            }

        }

        return String.join("", sb.reversed());

    }

    private static String getMapped(int firstDigit, DecimalPlaceNumerals lower, DecimalPlaceNumerals higher) {
        return switch (firstDigit) {
            case 0 -> "";
            case 1 -> lower.getNumeral();
            case 2 -> lower.getNumeral() + lower.getNumeral();
            case 3 -> lower.getNumeral() + lower.getNumeral() + lower.getNumeral();
            case 4 -> SUBTRACTIVE.get(4 * lower.getValue()); //todo magic numbers
            case 5 -> higher.getNumeral();
            case 6 -> higher.getNumeral() + lower.getNumeral();
            case 7 -> higher.getNumeral() + lower.getNumeral() + lower.getNumeral();
            case 8 -> higher.getNumeral() + lower.getNumeral() + lower.getNumeral() + lower.getNumeral();
            case 9 -> SUBTRACTIVE.get(9 * lower.getValue());
            default -> throw new IllegalStateException("Unexpected value: " + firstDigit);
        };
    }

}
