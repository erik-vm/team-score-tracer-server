package com.team5.teamscoretrackerserver.exeptions;

import java.time.LocalDateTime;

public class ErrorDetails {
private LocalDateTime timestamp;
private String message;
private String details;

//bellow are the fields of each error that will show
    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }



    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
