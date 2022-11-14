package com.team5.teamscoretrackerserver.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Team {
    @Id
    private String id;
    private String name;
    private int overallScore;
    private List<Task> tasks;

    public Team(String name) {
        this.name = name;
        this.overallScore = 0;
    }

}
