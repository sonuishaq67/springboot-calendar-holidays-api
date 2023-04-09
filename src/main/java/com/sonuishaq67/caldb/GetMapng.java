package com.sonuishaq67.caldb;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMapng {

    @ResponseBody
    @GetMapping("/")
    String index() {
        return "Hello, World!";
    }
}
       
