package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/time")
public class ArticleController {

    @GetMapping("/now")
    public String getCurrentTime() {
        return LocalTime.now().toString();
    }
}
