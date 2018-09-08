package com.xcode.rest.task.two;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataDto {
    @JsonProperty("numbers")
    private String numbers;
    @JsonProperty("order")
    private String order;

    public DataDto() {
    }

    public DataDto(String numbers, String order) {
        this.numbers = numbers;
        this.order = order;
    }

    public String getNumbers() {
        return numbers;
    }

    public String getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "numbers='" + numbers + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
