package com.team5.teamscoretrackerserver.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document
public class Activity {
    private BigInteger activityId;
    private String activityName;
    private Integer score;
}
