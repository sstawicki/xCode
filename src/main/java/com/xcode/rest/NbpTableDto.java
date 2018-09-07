package com.xcode.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NbpTableDto {
    @JsonProperty("table")
    private String table;
    @JsonProperty("no")
    private String no;
    @JsonProperty("effectiveDate")
    private LocalDate effectiveDate;
    @JsonProperty("rates")
    private List<RatesDto> rates;

    public NbpTableDto(String table, String no, LocalDate effectiveDate, List<RatesDto> rates) {
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

    @Override
    public String toString() {
        return "NbpTableDto{" +
                "table='" + table + '\'' +
                ", no='" + no + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", rates=" + rates +
                '}';
    }
}
