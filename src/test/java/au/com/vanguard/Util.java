package au.com.vanguard;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static boolean isValidPerCentage(Double percentageChange) {
        return percentageChange > -100 || percentageChange < 100;
    }

    public static boolean isValidDate(String date) {
        return false;
    }

    public static List<String> getValidCurrencyCode() {
        //Can be part of schema valdation test
        return Arrays.asList("USD", "AUD");
    }

    public static List<String> getPriceStatusCode() {
        // can be moved to schema validation test
        return Arrays.asList("FINAL", "ESTIMATE");
    }
}
