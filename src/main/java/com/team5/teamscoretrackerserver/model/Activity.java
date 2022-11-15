package com.team5.teamscoretrackerserver.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Activity {
    private Integer activityId;
    private String activityName;
    private Integer score;
}
