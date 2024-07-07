package com.example.rest.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.Client;

@RestController
public class ClientController {


    @GetMapping("/client")
    public Client getAllClient() {
        return Client.builder().birthDay(LocalDateTime.now()).name("testName").build();
    }

    @PostMapping("/client")
    public Client createClient() {
        return Client.builder().birthDay(LocalDateTime.now()).name("testName").build();
    }
}