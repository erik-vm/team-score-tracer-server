package com.team5.teamscoretrackerserver.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigInteger;

@Data
@Document
public class Activity {
    @MongoId
    private String activityId;
    private String activityName;
    private Integer score;
}
