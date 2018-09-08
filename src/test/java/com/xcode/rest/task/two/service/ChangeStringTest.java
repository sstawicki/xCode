package com.xcode.rest.task.two.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ChangeStringTest {

    @InjectMocks
    private ChangeString changeString;

    @Test
    public void testChangeCorectString() {
        //Given
        int num[] = {2,1,3};
        String numbers = "2,1,3";
        //When
        int[] result = changeString.change(numbers);
        //Then
        assertArrayEquals(num, result);
    }

    @Test
    public void testChangeWrongString() {
        //Given
        String numbers = "a,1,3";
        //When
        int[] result = changeString.change(numbers);
        //Then
        assertNull(result);
    }
}