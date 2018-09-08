package com.xcode.rest.task.two.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Data {
    @JsonProperty("numbers")
    private String numbers;
    @JsonProperty("order")
    private String order;

    public Data() {
    }

    public Data(String numbers, String order) {
        this.numbers = numbers;
        this.order = order;
    }

    public String getNumbers() {
        return numbers;
    }

    public String getOrder() {
        return order;
    }

}
