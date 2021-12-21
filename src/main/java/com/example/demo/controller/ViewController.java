package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value ="/")
    public String getOverview(){
        return "index.html";
    }
    @GetMapping(value ="/vote")
    public String getVoteOverview(){
        return "voteView.html";
    }
}
