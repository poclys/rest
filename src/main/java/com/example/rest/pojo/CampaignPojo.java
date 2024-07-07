package com.example.rest.pojo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignPojo {
    private long id;
    private String name;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String type;
    private String description;
    
}
