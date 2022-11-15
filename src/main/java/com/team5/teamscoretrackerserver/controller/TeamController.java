package com.team5.teamscoretrackerserver.controller;

import com.team5.teamscoretrackerserver.exeptions.TeamNotFoundException;
import com.team5.teamscoretrackerserver.model.Team;
import com.team5.teamscoretrackerserver.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/add")
    public void addTeam(@RequestBody Team team){
        teamService.addTeam(team);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping("/find={name}")
    Team findTeamByName(@PathVariable("name") String name) throws TeamNotFoundException {
      return teamService.findTeamByName(name);
    }
}
