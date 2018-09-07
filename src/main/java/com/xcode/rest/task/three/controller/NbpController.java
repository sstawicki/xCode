package com.xcode.rest.task.three.controller;

import com.xcode.rest.task.three.config.NbpClient;
import com.xcode.rest.task.three.domain.NbpTableDto;
import com.xcode.rest.task.three.domain.RatesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class NbpController {
    @Autowired
    private NbpClient nbpClient;

    @RequestMapping(method = RequestMethod.GET, value = "/currencies/get-current-currency-value-command/{currency}")
    public ResponseEntity<?> getNbpBoards(@PathVariable String currency)  {
        try {
            List<NbpTableDto> currencyList = nbpClient.getNbpBoards();
            List<RatesDto> ratesDtos = currencyList.get(0).getRates();
            List<RatesDto> mid = ratesDtos.stream()
                    .filter(s -> s.getCode().equals(currency.toUpperCase()))
                    .collect(Collectors.toList());
            BigDecimal result =  mid.get(0).getMid();
            ResponseEntity<?> responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
            int httpStatus = responseEntity.getStatusCodeValue();
            return new ResponseEntity<>("value: " + result + " code HTTP is: " + httpStatus, HttpStatus.OK);
        } catch (Exception ex) {
            ResponseEntity<?> responseEntity = new ResponseEntity<>("Wrong Currency ", HttpStatus.BAD_REQUEST);
            int httpStatus = responseEntity.getStatusCodeValue();
            return new ResponseEntity<>("Wrong Code Currency error ==> code HTTP is: " + httpStatus, HttpStatus.BAD_REQUEST);
        }

    }

}
