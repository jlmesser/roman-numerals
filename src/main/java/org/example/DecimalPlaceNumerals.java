package org.example;

public enum DecimalPlaceNumerals {
    /*
    single numeral numbers
    I -> 1
    V -> 5
    X -> 10
    L -> 50
    C -> 100
    D -> 500
    M -> 1000
     */

    ONE("I", 1),
    FIVE("V", 5),
    TEN("X", 10),
    FIFTY("L", 50),
    ONE_HUNDRED("C", 100),
    FIVE_HUNDRED("D", 500),
    ONE_THOUSAND("M", 1000);

    private final String numeral;
    private final int value;

    DecimalPlaceNumerals(String numeral, int value) {
        this.numeral = numeral;
        this.value = value;
    }

    public String getNumeral() {
        return numeral;
    }

    public int getValue() {
        return value;
    }
}
