package au.com.vanguard.test.models;

public class Currency {

    private String currencyCode;
    private String currencyLocation;
    private String currencySymbol;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyLocation() {
        return currencyLocation;
    }

    public void setCurrencyLocation(String currencyLocation) {
        this.currencyLocation = currencyLocation;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

}