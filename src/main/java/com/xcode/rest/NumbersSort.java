package com.xcode.rest;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class NumbersSort {
    private static final String ASC = "ASC";
    private static final String DESC = "DESC";

    public int[] sorts(int[] numbers, String howSort) {
        int[] resultASC = Arrays.stream(numbers)
                .sorted()
                .toArray();
        int[] resultDESC = new int[numbers.length];
        if (howSort.equals(ASC)) {
            return resultASC;
        } else if (howSort.equals(DESC)) {
            int n = numbers.length - 1;
            for (int i = 0; i <= (numbers.length - 1); i++) {
                resultDESC[i] = resultASC[n];
                n--;
            }
            return resultDESC;
        } else {
            // dopisać Exception
            return numbers;
        }
    }
}
