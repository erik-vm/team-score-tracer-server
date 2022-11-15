package com.team5.teamscoretrackerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TeamScoreTrackerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamScoreTrackerServerApplication.class, args);
    }
}
