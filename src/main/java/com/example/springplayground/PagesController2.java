package com.example.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagesController2 {

    @GetMapping("/new")
    public String fullSend(){
        return "Here I am";
    }
}
