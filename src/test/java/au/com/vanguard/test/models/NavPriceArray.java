package au.com.vanguard.test.models;

public class NavPriceArray {

    private Double amountChange;
    private String asOfDate;
    private Currency currency;
    private Boolean isFinal;
    private MeasureType measureType;
    private Double percentChange;
    private Double price;
    private PricePeriodType pricePeriodType;
    private PriceStatusType priceStatusType;
    private Object yield;
    private Boolean _final;

    public Double getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(Double amountChange) {
        this.amountChange = amountChange;
    }

    public String getAsOfDate() {
        return asOfDate;
    }

    public void setAsOfDate(String asOfDate) {
        this.asOfDate = asOfDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Boolean getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(Boolean isFinal) {
        this.isFinal = isFinal;
    }

    public MeasureType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(MeasureType measureType) {
        this.measureType = measureType;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PricePeriodType getPricePeriodType() {
        return pricePeriodType;
    }

    public void setPricePeriodType(PricePeriodType pricePeriodType) {
        this.pricePeriodType = pricePeriodType;
    }

    public PriceStatusType getPriceStatusType() {
        return priceStatusType;
    }

    public void setPriceStatusType(PriceStatusType priceStatusType) {
        this.priceStatusType = priceStatusType;
    }

    public Object getYield() {
        return yield;
    }

    public void setYield(Object yield) {
        this.yield = yield;
    }

    public Boolean getFinal() {
        return _final;
    }

    public void setFinal(Boolean _final) {
        this._final = _final;
    }

}