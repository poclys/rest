package com.example.rest.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {
    private long id;
    private String name;
    private String status;
    private Date startDate;
    private Date endDate;
    private String type;
    private String description;
    
}
