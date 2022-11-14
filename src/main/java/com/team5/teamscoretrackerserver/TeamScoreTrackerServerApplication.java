package com.team5.teamscoretrackerserver;

import com.team5.teamscoretrackerserver.models.Task;
import com.team5.teamscoretrackerserver.models.Team;
import com.team5.teamscoretrackerserver.repos.TaskRepo;
import com.team5.teamscoretrackerserver.repos.TeamRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TeamScoreTrackerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamScoreTrackerServerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner (TeamRepo teamRepo, TaskRepo taskRepo){
        return args -> {
            Task task = new Task("Build scoreboard", "Build scoreboard with UI");
            taskRepo.insert(task);
            Team team = new Team("Team5");
            teamRepo.insert(team);
        };
    }
}
