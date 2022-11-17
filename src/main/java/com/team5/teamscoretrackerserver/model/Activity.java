package com.team5.teamscoretrackerserver.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
public class Activity {
    @MongoId
    private String activityId;
    private String activityName;
    private Integer score;
}
