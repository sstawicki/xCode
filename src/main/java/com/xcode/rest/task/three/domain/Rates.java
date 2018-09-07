package com.xcode.rest.task.three.domain;

import java.math.BigDecimal;

public class Rates {
    private String currency;
    private String code;
    private BigDecimal mid;

    public Rates(String currency, String code, BigDecimal mid) {
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getMid() {
        return mid;
    }
}
