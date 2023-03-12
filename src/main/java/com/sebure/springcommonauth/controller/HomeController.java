package com.sebure.springcommonauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HomeController {

    @GetMapping({"", "/", "/test"})
    public String home(){
        return "home";
    }
}
