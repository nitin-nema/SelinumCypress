package com.example.SelinumCypress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/api/greeting")
    public String greeting() {
        return "Hello, World!";
    }
}
