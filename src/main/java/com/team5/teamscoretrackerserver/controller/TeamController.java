package com.team5.teamscoretrackerserver.controller;

import com.team5.teamscoretrackerserver.exeptions.TeamNotFoundException;
import com.team5.teamscoretrackerserver.model.Team;
import com.team5.teamscoretrackerserver.service.TeamService;
import dtos.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;


@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/add")
    public Team addTeam(@RequestBody Team team){
       return teamService.addTeam(team);
    }

    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/team-dto")
    public List<TeamDTO> getTeamDTO() {
        return teamService.getTeamDTO();
    }

    @PutMapping("/find={name}")
    Team findTeamByName(@PathVariable("name") String name) throws TeamNotFoundException {
      return teamService.findTeamByName(name);
    }

    @PutMapping("/id={teamId}")
    Team findTeamById(@PathVariable("teamId")BigInteger teamId) throws TeamNotFoundException {
        return teamService.findTeamById(teamId);
    }
}
