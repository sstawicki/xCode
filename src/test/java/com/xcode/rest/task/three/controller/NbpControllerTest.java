package com.xcode.rest.task.three.controller;

import com.xcode.rest.task.three.config.NbpClient;
import com.xcode.rest.task.three.domain.NbpTableDto;
import com.xcode.rest.task.three.domain.RatesDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NbpController.class)
public class NbpControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private NbpClient nbpClient;


    @Test
    public void testGetNbpBoardsWithCorrectCurrency() throws Exception {
        //Given
        RatesDto ratesDto = new RatesDto("Dolar Amerykanski", "USD", new BigDecimal(3.321));
        List<RatesDto> ratesDtoList = new ArrayList<>();
        ratesDtoList.add(ratesDto);
        NbpTableDto nbpTableDto = new NbpTableDto("Test", "1",  LocalDate.parse("2018-09-07"), ratesDtoList);
        List<NbpTableDto> nbpTableDtos = new ArrayList<>();
        nbpTableDtos.add(nbpTableDto);
        when(nbpClient.getNbpBoards()).thenReturn(nbpTableDtos);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(nbpTableDto);
        //When & Then
        mockMvc.perform(get("/currencies/get-current-currency-value-command/USD")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(result -> new BigDecimal(3.321));

    }

    @Test
    public void testGetNbpBoardsWithWrongCurrency() throws Exception {
        //Given
        RatesDto ratesDto = new RatesDto("Dolar Amerykanski", "USD", new BigDecimal(3.321));
        List<RatesDto> ratesDtoList = new ArrayList<>();
        ratesDtoList.add(ratesDto);
        NbpTableDto nbpTableDto = new NbpTableDto("Test", "1",  LocalDate.parse("2018-09-07"), ratesDtoList);
        List<NbpTableDto> nbpTableDtos = new ArrayList<>();
        nbpTableDtos.add(nbpTableDto);
        when(nbpClient.getNbpBoards()).thenReturn(nbpTableDtos);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(nbpTableDto);
        //When & Then
        mockMvc.perform(get("/currencies/get-current-currency-value-command/123")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is4xxClientError());


    }
}