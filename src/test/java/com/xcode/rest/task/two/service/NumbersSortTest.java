package com.xcode.rest.task.two.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class NumbersSortTest {

    @InjectMocks
    private NumbersSort numbersSort;
    @Test
    public void testSortsASC() {
        //Given
        int sort[] = {1,3,4};
        int numbers[] = {3,1,4};
        String sorts = "ASC";
        //When
        int[] result = numbersSort.sorts(numbers,sorts);
        //Then
        assertArrayEquals(sort,result);
    }

    @Test
    public void testSortDESC() {
        //Given
        int sort[] = {4,3,1};
        int numbers[] = {3,1,4};
        String sorts = "DESC";
        //When
        int[] result = numbersSort.sorts(numbers,sorts);
        //Then
        assertArrayEquals(sort,result);
    }
}