package com.team5.teamscoretrackerserver.service;

import com.team5.teamscoretrackerserver.exeptions.TeamNotFoundException;
import com.team5.teamscoretrackerserver.model.Team;
import com.team5.teamscoretrackerserver.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public void addTeam(Team team){
        teamRepository.save(team);
    }
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Team findTeamByName(String name) throws TeamNotFoundException {
        Optional<Team> teamOptional = teamRepository.findTeamByTeamName(name);
        if (teamOptional.isEmpty()){
            throw new TeamNotFoundException(name);
        }
        return teamOptional.get();
    }
}
