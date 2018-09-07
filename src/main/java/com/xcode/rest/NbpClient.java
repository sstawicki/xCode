package com.xcode.rest;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class NbpClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CoreConfiguration coreConfiguration;


    public List<NbpTableDto> getNbpBoards() {
        URI uri = UriComponentsBuilder.fromHttpUrl(coreConfiguration.getNbpApiEndpoint()).build().encode().toUri();
        NbpTableDto[] boardsResponse = restTemplate.getForObject(uri, NbpTableDto[].class);
        if (boardsResponse != null) {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();

    }

}
