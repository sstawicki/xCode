package com.xcode.rest.task.two.cotroller;

import com.google.gson.Gson;
import com.xcode.rest.task.two.domain.Data;
import com.xcode.rest.task.two.domain.DataDto;
import com.xcode.rest.task.two.mapper.DataMapper;
import com.xcode.rest.task.two.service.ChangeString;
import com.xcode.rest.task.two.service.NumbersSort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SortController.class)
public class SortControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DataMapper dataMapper;
    @MockBean
    private ChangeString changeString;
    @MockBean
    private NumbersSort numbersSort;

    @Test
    public void testSortCommandWrongData() throws Exception {
        //Given
        DataDto dataDto = new DataDto("a,3,4,1", "ASC");
        Data data = new Data("a,3,4,1", "ASC");
        when(dataMapper.mapToData(dataDto)).thenReturn(data);
        when(changeString.change(data.getNumbers())).thenReturn(null);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(dataDto);
        //When & Then
        mockMvc.perform(post("/numbers/sort-command")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(result -> result.equals("Wrong Data error ==> code HTTP is: 400"));
    }

    @Test
    public void testSortCommandCorrectData() throws Exception {
        //Given
        DataDto dataDto = new DataDto("2,3,4,1", "DESC");
        Data data = new Data("2,3,4,1", "DESC");
        int[] numbers = {2,3,4,1};
        int[] numberSort = {4,3,2,1};
        when(dataMapper.mapToData(dataDto)).thenReturn(data);
        when(changeString.change(data.getNumbers())).thenReturn(numbers);
        when(numbersSort.sorts(numbers,data.getOrder())).thenReturn(numberSort);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(dataDto);
        //When & Then
        mockMvc.perform(post("/numbers/sort-command")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}