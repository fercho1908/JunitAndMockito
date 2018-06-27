package com.j4guanatos.banxico.utils;

/**
 * Created by prueba on 10/11/16.
 */
public enum CurrencyEnum {
    USD("SF43718", "USD"),
    EUR("SF46410", "EUR"),
    CAD("SF60632", "CAD"),
    JPY("SF60632", "JPY"),
    GBP("SF60632", "GBP");

    private String serieId;
    private String currency;

    private CurrencyEnum(String serieId, String currency) {
        this.serieId = serieId;
        this.currency = currency;
    }

    public String getSerieId() {
        return serieId;
    }

    public String getCurrency() {
        return currency;
    }

    public CurrencyEnum[] getEnums() {
        return values();
    }
}
