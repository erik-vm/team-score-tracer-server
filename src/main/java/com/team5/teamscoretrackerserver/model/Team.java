package com.team5.teamscoretrackerserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Team {
    @MongoId
    private String teamId;
    @Indexed(unique=true)
    private String teamName;
    private Integer teamScore;
    private List<Activity> activityList;

    public Team(String teamName, Integer teamScore) {
        this.teamName = teamName;
        this.teamScore = teamScore;
    }
}
