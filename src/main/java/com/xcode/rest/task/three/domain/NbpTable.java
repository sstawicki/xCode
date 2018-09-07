package com.xcode.rest.task.three.domain;

import java.time.LocalDate;
import java.util.List;

public class NbpTable {
    private String table;
    private String no;
    private LocalDate effectiveDate;
    private List<RatesDto> rates;

    public NbpTable(String table, String no, LocalDate effectiveDate, List<RatesDto> rates) {
        this.table = table;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public String getNo() {
        return no;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public List<RatesDto> getRates() {
        return rates;
    }
}

