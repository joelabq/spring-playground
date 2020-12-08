package com.example.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @GetMapping("/math/pi")
    public String getPiValue(){
        return "3.141592653589793";
    }
}
