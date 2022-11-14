package com.team5.teamscoretrackerserver.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task {

    @Id
    private String id;
    private String title;
    private String description;
    private int points;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.points = 0;
    }
}
