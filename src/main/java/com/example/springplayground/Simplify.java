package com.example.springplayground;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Simplify {


    @PostMapping(value = "/activities/simplify" produces="application/vnd.galvanize.detailed+json" )
    @JsonView(Views.DetailView.class)


}
