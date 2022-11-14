package com.team5.teamscoretrackerserver.Controller;

import com.team5.teamscoretrackerserver.Model.Team;
import com.team5.teamscoretrackerserver.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/addteam")
    public void addTeam(@RequestBody Team team){
        teamService.addTeam(team);
    }

    @GetMapping("/teams")
    public List<Team> getAllTeams() {

        return teamService.getAllTeams();
    }
}
