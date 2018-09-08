package com.xcode.rest.task.two;

import com.xcode.rest.task.two.Data;
import com.xcode.rest.task.two.NumbersSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
public class SortController {
    @Autowired
    NumbersSort numbersSort;
    @Autowired
    DataMapper dataMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/numbers/sort-command", consumes =  APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sortCommand(@RequestBody DataDto dataDto) {
        try {
            Data data = dataMapper.mapToData(dataDto);
            int[] numbers = ChangeString.changeString(data.getNumbers());
            int[] sort = numbersSort.sorts(numbers, data.getOrder());
            ResponseEntity<?> responseEntity = new ResponseEntity<>(sort, HttpStatus.OK);
            int httpStatus = responseEntity.getStatusCodeValue();
            return new ResponseEntity<>("sort numbers: " + Arrays.toString(sort) + " code HTTP is: " + httpStatus, HttpStatus.OK);
        } catch (Exception ex) {
            ResponseEntity<?> responseEntity = new ResponseEntity<>("Wrong Data ", HttpStatus.BAD_REQUEST);
            int httpStatus = responseEntity.getStatusCodeValue();
            return new ResponseEntity<>("Wrong Data error ==> code HTTP is: " + httpStatus, HttpStatus.BAD_REQUEST);
        }
    }
}
