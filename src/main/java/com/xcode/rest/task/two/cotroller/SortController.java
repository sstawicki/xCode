package com.xcode.rest.task.two.cotroller;

import com.xcode.rest.task.two.service.ChangeString;
import com.xcode.rest.task.two.service.NumbersSort;
import com.xcode.rest.task.two.domain.Data;
import com.xcode.rest.task.two.domain.DataDto;
import com.xcode.rest.task.two.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class SortController {
    @Autowired
    private NumbersSort numbersSort;
    @Autowired
    private DataMapper dataMapper;
    @Autowired
    private ChangeString changeString;

    @RequestMapping(method = RequestMethod.POST, value = "numbers/sort-command", consumes =  APPLICATION_JSON_VALUE)
    public String sortCommand(@RequestBody DataDto dataDto) {
        try {
            Data data = dataMapper.mapToData(dataDto);
            if(data.getNumbers().isEmpty()){
                return "Write numbers code HTTP is: 400";
            } else {
                int[] numbers = changeString.change(data.getNumbers());
                int[] sort = numbersSort.sorts(numbers, data.getOrder());
                ResponseEntity<?> responseEntity = new ResponseEntity<>(sort, HttpStatus.OK);
                int httpStatus = responseEntity.getStatusCodeValue();
                return "Numbers sort: " + Arrays.toString(sort) + " code HTTP is: " + httpStatus;
            }
        } catch (Exception ex) {
            ResponseEntity<?> responseEntity = new ResponseEntity<>("Wrong Data ", HttpStatus.BAD_REQUEST);
            int httpStatus = responseEntity.getStatusCodeValue();
            return "Wrong Data error ==> code HTTP is: " + httpStatus;
        }
    }
}
