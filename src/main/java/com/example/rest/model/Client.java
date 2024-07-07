package com.example.rest.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    String name;
    LocalDateTime birthDay;
}