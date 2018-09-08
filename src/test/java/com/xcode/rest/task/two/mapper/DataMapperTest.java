package com.xcode.rest.task.two.mapper;

import com.xcode.rest.task.two.domain.Data;
import com.xcode.rest.task.two.domain.DataDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class DataMapperTest {
    @InjectMocks
    private DataMapper dataMapper;

    @Test
    public void testMapToData() {
        //Given
        DataDto dataDto = new DataDto("2,4,1", "ASC");
        //When
        Data data = dataMapper.mapToData(dataDto);
        //Then
        assertEquals("2,4,1", data.getNumbers());
        assertEquals("ASC", data.getOrder());
    }

    @Test
    public void mapToDataDto() {
        //Given
        Data data = new Data("2,4,1", "ASC");
        //When
        DataDto dataDto = dataMapper.mapToDataDto(data);
        //Then
        assertEquals("2,4,1", dataDto.getNumbers());
        assertEquals("ASC", dataDto.getOrder());
    }
}