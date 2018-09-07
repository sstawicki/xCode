package com.xcode.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Data {
    @JsonProperty("numbers")
    private int[] numbers;
    @JsonProperty("order")
    private String order;

    public Data() {
    }

    public Data(int[] numbers, String order, String status) {
        this.numbers = numbers;
        this.order = order;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public String getOrder() {
        return order;
    }


    @Override
    public String toString() {
        return "Data{" +
                "numbers=" + Arrays.toString(numbers) +
                ", order='" + order + '\'' +
                '}';
    }
}
