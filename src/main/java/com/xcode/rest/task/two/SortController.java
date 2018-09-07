package com.xcode.rest.task.two;

import com.xcode.rest.task.two.Data;
import com.xcode.rest.task.two.NumbersSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
public class SortController {
    @Autowired
    NumbersSort numbersSort;

    @RequestMapping(method = RequestMethod.POST, value = "/numbers/sort-command", consumes =  APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sortCommand(@RequestBody Data data){
        try {
            int[] sort = numbersSort.sorts(data.getNumbers(),data.getOrder());
            return new ResponseEntity<>(sort, HttpStatus.OK);
        } catch (Exception ex){
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

}