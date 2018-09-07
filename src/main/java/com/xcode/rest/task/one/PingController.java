package com.xcode.rest.task.one;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    private static final String PONG = "pong";

    @RequestMapping(method = RequestMethod.GET, value = "/status/ping")
    public String getPing(){
        return PONG;
    }
}
