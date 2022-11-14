package com.team5.teamscoretrackerserver.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Data
@Document

public class Team {
    @Id
    private BigInteger teamId;
    @Indexed(unique=true)
    private Integer teamNumber;
    private Integer teamScore;
    private List<Activity> activityList;
}
