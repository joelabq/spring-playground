package com.example.springplayground;

import com.fasterxml.jackson.annotation.JsonView;

import java.sql.Date;

public class User {
    @JsonView(Views.CompactView.class)
    private String user;
    private Date date;
    private String statusText;

    @JsonView(Views.DetailView.class)
    private String userId;
    private String email;


}
